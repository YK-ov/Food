import java.nio.file.Path;
import java.util.Arrays;

public class Main {
    public static void main(String[] args){
        Path gasolineFile = Path.of("src/data/nonfood/benzyna.csv");

        NonFoodProduct gasoline = NonFoodProduct.fromCsv(gasolineFile);
        System.out.println(gasoline.getName());
        Double[] gasolinePrinces = gasoline.getPrices();
        //for (int i = 0; i < gasolinePrinces.length; i++) {
        //    System.out.println(gasolinePrinces[i]);
        //}
        double price = gasoline.getPrice(2022,1);

        System.out.println(price + " price");

        System.out.println("debugging foodProduct");

        Path beetRootFile = Path.of("src/data/food/buraki.csv");
        //FoodProduct.fromCsv(beetRootFile);

        FoodProduct beetRoot = FoodProduct.fromCsv(beetRootFile);
        //beetRoot.getPriceMap().forEach((key, value) -> System.out.println(key + " : " + Arrays.toString(value)));
        double toShow = beetRoot.getPrice(2011,1, "ŚLĄSKIE");
        System.out.println(toShow + " new price");
        double toShowAverage = beetRoot.getPrice(2022, 3);
        System.out.println(toShowAverage + " new price average");
    }



}
