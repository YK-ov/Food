import java.io.IOException;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.Scanner;

public class NonFoodProduct extends Product{
    Double[] prices;

    private NonFoodProduct(String name, Double[] prices) {
        super(name);
        this.prices = prices;
    }

    public static NonFoodProduct fromCsv(Path path) {
        String name;
        Double[] prices;

        try {
            Scanner scanner = new Scanner(path);
            name = scanner.nextLine(); // odczytuję pierwszą linię i zapisuję ją jako nazwa
            scanner.nextLine(); // pomijam drugą linię z nagłówkiem tabeli
            prices = Arrays.stream(scanner.nextLine().split(";")) // odczytuję kolejną linię i dzielę ją na tablicę
                    .map(value -> value.replace(",",".")) // zamieniam polski znak ułamka dziesiętnego - przecinek na kropkę
                    .map(Double::valueOf) // konwertuję string na double
                    .toArray(Double[]::new); // dodaję je do nowo utworzonej tablicy

            scanner.close();

            return new NonFoodProduct(name, prices);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected String getName() {
        return super.getName();
    }

    @Override
    protected void setName(String name) {
        super.setName(name);
    }

    public Double[] getPrices() {  // to remove
        return prices;
    }

    @Override
    public double getPrice(int year, int month) {
        int startYear = 2010;
        int startMonth = 1;
        boolean inRightRange = false;
        boolean year2022RightRange = false;
        boolean ultimateRightRange = false;

        if (year == 2022 && month <= 3 && month >= 1) {
            year2022RightRange = true;
        }

        if ((year >= 2010 && year <= 2021) && (month >= 1 && month <= 12)) {
            inRightRange = true;
        }

        if (inRightRange || year2022RightRange) {
            ultimateRightRange = true;
        }


        for (int i = 0; i < prices.length; i++) {
            if (ultimateRightRange) {
                if (startMonth == month && startYear == year) {
                    return prices[i];
                }
                else {
                    startMonth++;
                    if (startMonth > 12) {
                        startMonth = 1;
                        startYear++;
                    }
                }

            }
        }

        throw new IndexOutOfBoundsException("Wrong date, the range is 01.2010 - 03.2022");
    }
}
