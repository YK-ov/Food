import java.io.IOException;
import java.nio.file.Path;
import java.util.*;

public class FoodProduct extends Product {
    //Double[] prices;
    List<String> provinces;
    Map<String, Double[]> priceMap = new HashMap<>();

    private FoodProduct(String name, List<String> provinces, Map<String, Double[]> priceMap) {
        super(name);
        this.provinces = provinces;
        this.priceMap = priceMap;
    }

    public static FoodProduct fromCsv(Path path) {
        String name;
        Double[] prices;
        String province;

        try {
            Scanner scanner = new Scanner(path);
            name = scanner.nextLine();
            scanner.nextLine();
            List<String> wholeFileList = new ArrayList<>();
            Map<String, Double[]> map = new HashMap<>();

            String line = "";
            int lineCounter = 0;
            while (scanner.hasNextLine()) {
                if (lineCounter == 0) {
                    line = line + scanner.nextLine();
                }
                else {
                    line = line + " /" + scanner.nextLine();
                }
                lineCounter++;
            }
            line = line.replace(",", ".");

            line = Arrays.toString(line.split(";"));

            String[] split = line.split("/");
            split[0] = split[0].replace("[", "");
            split[split.length - 1] = split[split.length - 1].replace("]", "");

            List<String> provinces = new ArrayList<>();
            List<String> toBeChangedInDouble = new ArrayList<>();

            for (int i = 0; i < split.length; i++) {
                for (int j = 0; j < split[i].length(); j++) {
                    if (split[i].charAt(j) == 'E' && split[i].charAt(j + 1) == ',') {
                        provinces.add(split[i].substring(0, j+1));
                        toBeChangedInDouble.add(split[i].substring(j+3));
                    }

                }

                wholeFileList.add(Arrays.toString(split[i].split(",")));
            }

            List<Double> priceList = new ArrayList<>();

            for (int i = 0; i < toBeChangedInDouble.size(); i++) {
                String[] numbers = toBeChangedInDouble.get(i).split(",");
                for (int j = 0; j < numbers.length; j++) {
                    priceList.add(Double.parseDouble(numbers[j].trim()));
                }
            }

            Double[] priceArray = new Double[priceList.size()];
            for (int i = 0; i < priceList.size(); i++) {
                priceArray[i] = priceList.get(i);
            }

            int priceSize = 147;
            Double[] firstProvinceArray = new Double[priceSize];
            Double[] secondProvinceArray = new Double[priceSize];
            Double[] thirdProvinceArray = new Double[priceSize];
            Double[] fourthProvinceArray = new Double[priceSize];
            Double[] fifthProvinceArray = new Double[priceSize];
            Double[] sixthProvinceArray = new Double[priceSize];
            Double[] seventhProvinceArray = new Double[priceSize];
            Double[] eightProvinceArray = new Double[priceSize];
            Double[] ninthProvinceArray = new Double[priceSize];
            Double[] tenthProvinceArray = new Double[priceSize];
            Double[] eleventhProvinceArray = new Double[priceSize];
            Double[] twelfthProvinceArray = new Double[priceSize];
            Double[] thirteenthProvinceArray = new Double[priceSize];
            Double[] fourteenthProvinceArray = new Double[priceSize];
            Double[] fifteenthProvinceArray = new Double[priceSize];
            Double[] sixteenthProvinceArray = new Double[priceSize];

            int iterateIndex = 146;

            for (int i = 0; i < priceList.size(); i++) {
                if (i <= iterateIndex) {
                    firstProvinceArray[i] = priceList.get(i);
                }
                if (i > iterateIndex && i <= iterateIndex * 2 + 1) {
                    secondProvinceArray[i - iterateIndex - 1] = priceList.get(i);
                }
                if (i > iterateIndex * 2 + 1 && i <= iterateIndex * 3 + 2) {
                    thirdProvinceArray[i - iterateIndex * 2 - 2] = priceList.get(i);
                }
                if (i > iterateIndex * 3 + 2 && i <= iterateIndex * 4 + 3){
                    fourthProvinceArray[i - iterateIndex * 3 - 3] = priceList.get(i);
                }
                if (i > iterateIndex * 4 + 3 && i <= iterateIndex * 5 + 4){
                    fifthProvinceArray[i - iterateIndex * 4 - 4] = priceList.get(i);
                }
                if (i > iterateIndex * 5 + 4 && i <= iterateIndex * 6 + 5){
                    sixthProvinceArray[i - iterateIndex * 5 - 5] = priceList.get(i);
                }
                if (i > iterateIndex * 6 + 5 && i <= iterateIndex * 7 + 6){
                    seventhProvinceArray[i - iterateIndex * 6 - 6] = priceList.get(i);
                }
                if (i > iterateIndex * 7 + 6 && i <= iterateIndex * 8 + 7){
                    eightProvinceArray[i - iterateIndex * 7 - 7] = priceList.get(i);
                }
                if (i > iterateIndex * 8 + 7 && i <= iterateIndex * 9 + 8){
                    ninthProvinceArray[i - iterateIndex * 8 - 8] = priceList.get(i);
                }
                if (i > iterateIndex * 9 + 8 && i <= iterateIndex * 10 + 9){
                    tenthProvinceArray[i - iterateIndex * 9 - 9] = priceList.get(i);
                }
                if (i > iterateIndex * 10 + 9 && i <= iterateIndex * 11 + 10){
                    eleventhProvinceArray[i - iterateIndex * 10 - 10] = priceList.get(i);
                }
                if (i > iterateIndex * 11 + 10 && i <= iterateIndex * 12 + 11){
                    twelfthProvinceArray[i - iterateIndex * 11 - 11] = priceList.get(i);
                }
                if (i > iterateIndex * 12 + 11 && i <= iterateIndex * 13 + 12){
                    thirteenthProvinceArray[i - iterateIndex * 12 - 12] = priceList.get(i);
                }
                if (i > iterateIndex * 13 + 12 && i <= iterateIndex * 14 + 13){
                    fourteenthProvinceArray[i - iterateIndex * 13 - 13] = priceList.get(i);
                }
                if (i > iterateIndex * 14 + 13 && i <= iterateIndex * 15 + 14){
                    fifteenthProvinceArray[i - iterateIndex * 14 - 14] = priceList.get(i);
                }
                if (i > iterateIndex * 15 + 14 && i <= iterateIndex * 16 + 15){
                    sixteenthProvinceArray[i - iterateIndex * 15 - 15] = priceList.get(i);
                }
            }

            for (int i = 0; i < priceSize; i++) {
                for (int j = 0; j < provinces.size(); j++) {
                    if (j == 0){
                        map.put(provinces.get(j), firstProvinceArray);
                    }
                    if (j == 1){
                        map.put(provinces.get(j), secondProvinceArray);
                    }
                    if (j == 2){
                        map.put(provinces.get(j), thirdProvinceArray);
                    }
                    if (j == 3){
                        map.put(provinces.get(j), fourthProvinceArray);
                    }
                    if (j == 4){
                        map.put(provinces.get(j), fifthProvinceArray);
                    }
                    if (j == 5){
                        map.put(provinces.get(j), sixthProvinceArray);
                    }
                    if (j == 6){
                        map.put(provinces.get(j), seventhProvinceArray);
                    }
                    if (j == 7){
                        map.put(provinces.get(j), eightProvinceArray);
                    }
                    if (j == 8){
                        map.put(provinces.get(j), ninthProvinceArray);
                    }
                    if (j == 9){
                        map.put(provinces.get(j), tenthProvinceArray);
                    }
                    if (j == 10){
                        map.put(provinces.get(j), eleventhProvinceArray);
                    }
                    if (j == 11){
                        map.put(provinces.get(j), twelfthProvinceArray);
                    }
                    if (j == 12){
                        map.put(provinces.get(j), thirteenthProvinceArray);
                    }
                    if (j == 13){
                        map.put(provinces.get(j), fourteenthProvinceArray);
                    }
                    if (j == 14){
                        map.put(provinces.get(j), fifteenthProvinceArray);
                    }
                    if (j == 15){
                        map.put(provinces.get(j), sixteenthProvinceArray);
                    }
                }
            }

            /*
            for (Map.Entry<String, Double[]> entry : map.entrySet()) {
                System.out.println(entry.getKey() + " = " + Arrays.toString(entry.getValue()));
            } pretty sout of the map with array in it (array of doubles here)
            */


            return new FoodProduct(name, provinces, map);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }

    public Map<String, Double[]> getPriceMap() {
        return priceMap;
    }

    /*
    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (Map.Entry<String, Double[]> entry : priceMap.entrySet()) {
            result.append(entry.getKey()).append(" = ").append(Arrays.toString(entry.getValue()));
        }
        return result.toString();
    }
    */

    public double getPrice(int year, int month, String province) {
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

        for (Map.Entry<String, Double[]> entry : priceMap.entrySet()) {
            if (ultimateRightRange) {
                if (entry.getKey().equals(province)) {
                    for (int i = 0; i < entry.getValue().length; i++) {
                        if (startMonth == month && startYear == year) {
                            return entry.getValue()[i];
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
            }
        }

        throw new IndexOutOfBoundsException("Wrong date, the range is 01.2010 - 03.2022 or wrong province");
    }

    @Override
    public double getPrice(int year, int month) {
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

        double result = 0;
        int amountOfProvinces = 0;

        for (Map.Entry<String, Double[]> entry : priceMap.entrySet()) {
            int startYear = 2010;
            int startMonth = 1;
            int index = 0;

            amountOfProvinces++;
            if (ultimateRightRange) {
                while (!(startMonth == month && startYear == year)) {
                    index++;
                    startMonth++;
                    if (startMonth > 12) {
                        startMonth = 1;
                        startYear++;
                    }
                }
                result = result + entry.getValue()[index];
            }
        }

        if (!ultimateRightRange) {
            throw new IndexOutOfBoundsException("Wrong date, the range is 01.2010 - 03.2022");
        }
        result = result / amountOfProvinces;

        return result;
    }
}
