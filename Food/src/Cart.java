import java.util.ArrayList;

public class Cart {
    private ArrayList<Product> products = new ArrayList<>();

    public void addProduct(Product product, int amount) {
        for (int i = 0; i < amount; i++) {
            products.add(product);
        }
    }

    public double getPrice(int year, int month) {
        double price = 0;

        for (int i = 0; i < products.size(); i++) {
            price = price + products.get(i).getPrice(year, month);
        }

        return price;
    }

    public double getInflation(int year1, int month1, int year2, int month2) {
        double priceOne = getPrice(year1, month1);
        double priceTwo = getPrice(year2, month2);
        double inflation = 0.0f;
        int yearDiff = 0;
        int amountOfMonths = 0;

        if (year1 < year2) {
         yearDiff = year2 - year1;
         amountOfMonths = yearDiff * 12 + (month2 - month1);
         inflation = (priceTwo - priceOne) / priceOne * 100 / amountOfMonths * 12;
        }
        else if (year1 == year2) {
            amountOfMonths = Math.abs(month2 - month1);
            inflation = (priceTwo - priceOne) / priceOne * 100 / amountOfMonths * 12;
        }
        else {
            throw new IllegalArgumentException("Second year must be greater than first year or they have to be the same");
        }

        return inflation;
    }



}
