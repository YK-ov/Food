import java.io.IOException;
import java.nio.file.Path;
import java.util.*;

public class FoodProduct extends Product {
    //Double[] prices;
    String province;
    Map<String, Double> priceMap = new HashMap<>();

    private FoodProduct(String name, String province, Map<String, Double> priceMap) {
        super(name);
        //this.prices = prices;
        this.province = province;
        this.priceMap = priceMap;
    }

    public static void fromCsv(Path path) {
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
                line = line.replace(",", ".");
                if (lineCounter == 0) {
                    line = line + scanner.nextLine();
                }
                else {
                    line = line + " /" + scanner.nextLine();
                }
                lineCounter++;
                //System.out.println(line);
            }
            
            System.out.println(line + " whole line allegedly");
            System.out.println();
            line = Arrays.toString(line.split(";"));
            System.out.println(line + " whatever that is");

            //wholeFileList.add(line.trim().split("/")[0]);

            String[] split = line.split("/");
            split[0] = split[0].replace("[", "");
            split[split.length - 1] = split[split.length - 1].replace("]", "");

            String actualLine = "";
            List<String> provinces = new ArrayList<>();
            List<String> toBeChangedInDouble = new ArrayList<>();
            split[split.length - 1] = split[split.length - 1].replace(",", ".");


            for (int i = 0; i < split.length; i++) {
                for (int j = 0; j < split[i].length(); j++) {
                    if (split[i].charAt(j) == 'E' && split[i].charAt(j + 1) == ',') {
                        provinces.add(split[i].substring(0, j+1));
                        toBeChangedInDouble.add(split[i].substring(j+3));
                    }

                }

                wholeFileList.add(Arrays.toString(split[i].split(",")));
            }
            System.out.println(provinces + " provinces");

            List<Double> priceList = new ArrayList<>();


            for (int i = 0; i < toBeChangedInDouble.size(); i++) {
                String[] numbers = toBeChangedInDouble.get(i).split(",");
                for (int j = 0; j < numbers.length; j++) {
                    priceList.add(Double.parseDouble(numbers[j].trim()));
                }
            }


            for (int i = 0; i < priceList.size(); i++) {
                System.out.println(priceList.get(i) + " price" + " index=" + " " + i);
            }



/*
            for (int i = 0; i < wholeFileList.size(); i++) {
                if (wholeFileList.get(i).startsWith("D") || wholeFileList.get(i).startsWith("K") || wholeFileList.get(i).startsWith("L") || wholeFileList.get(i).startsWith("Ł")
                || wholeFileList.get(i).startsWith("M") || wholeFileList.get(i).startsWith("O") || wholeFileList.get(i).startsWith("P") || wholeFileList.get(i).startsWith("Ś")
                || wholeFileList.get(i).startsWith("W") || wholeFileList.get(i).startsWith("Z")) {

                    System.out.println(wholeFileList.get(i) + " regular");


                    //map.put(wholeFileList.get(i), new Double[]{Double.parseDouble(wholeFileList.get(i+1))});
                }
            }
*/


//            while (scanner.hasNextLine()) {
//                Arrays.stream(scanner.nextLine().split(";")).forEach(s -> wholeFileList.add(s));
//                System.out.println(wholeFileList + " from list");
//                province = wholeFileList.getFirst();
//                prices = new Double[wholeFileList.size() - 1];
//
//                String withoutAComma;
//                for (int i = 1; i < wholeFileList.size(); i++) {
//                    withoutAComma = wholeFileList.get(i).replace(",", ".");
//                    wholeFileList.set(i, withoutAComma);
//                }
//
//                for (int i = 0; i < prices.length; i++) {
//                    prices[i] = Double.parseDouble(wholeFileList.get(i + 1));
//                    //System.out.println(prices[i] + " prices double");
//                }
//
//
//                return new FoodProduct(name, prices, province);
//
//            }



            //System.out.println(wholeFileList + " new list");

/*
            for (int i = 0; i < prices.length; i++) {
                prices[i] = Double.parseDouble(wholeFileList.get(i + 1));
                //System.out.println(prices[i] + " prices double");
            }


            return new FoodProduct(name, prices, province);
*/

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

   // return null;
    }


    @Override
    public double getPrice(int year, int month) {
        return 0;
    }
}
