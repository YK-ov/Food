public abstract class Product {
    private String name;

    protected Product(String name) {
        this.name = name;
    }

    protected String getName() {
        return name;
    }


    protected void setName(String name) {
        this.name = name;
    }

    public abstract double getPrice(int year, int month);

}
