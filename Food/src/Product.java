import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.function.Function;

public abstract class Product {
    private String name;
    private static List<Product> products = new ArrayList<>();

    protected Product(String name) {
        this.name = name;
    }

    protected String getName() {
        return name;
    }


    protected void setName(String name) {
        this.name = name;
    }

    public static void clearProducts() {
        products.clear();
    }

    public static void addProducts(Function<Path, Product> functionalObject, Path directoryDataPath) throws FileNotFoundException {  // functional object, interface as parameter to the method here
        if (directoryDataPath.getFileName().toString().equals("food")) {
            String[] wholeDirectory = directoryDataPath.toFile().list();

            for (int i = 0; i < Objects.requireNonNull(wholeDirectory).length; i++) {
                products.add(functionalObject.apply(Path.of(directoryDataPath + "/" + wholeDirectory[i].trim())));
            }

        }
        if (directoryDataPath.getFileName().toString().equals("nonfood")) {
            String[] wholeDirectory = directoryDataPath.toFile().list();
            for (int i = 0; i < Objects.requireNonNull(wholeDirectory).length; i++) {
                products.add(functionalObject.apply(Path.of(directoryDataPath + "/" + wholeDirectory[i].trim())));
            }
        }
    }

    public static List<Product> getProducts() {
        return products;
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                '}';
    }

    public abstract double getPrice(int year, int month);

}
