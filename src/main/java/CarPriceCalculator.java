public class CarPriceCalculator implements PriceCalculator {

    private int age;
    private String model;
    public static int averageCarPrice = 6_000;

    public CarPriceCalculator(String model, int age) {
        this.model = model;
        this.age = age;
    }

    public int getRetailPrice() {
        switch (this.model) {
            case "FORD":
                return 3000;
            case "BMW":
                return 7000;
            default:
                return averageCarPrice;
        }
    }

    @Override
    public String calculatePrice() {
        int price = Math.max(getRetailPrice() - (age * 100), 0);
        return price + "USD";
    }
}
