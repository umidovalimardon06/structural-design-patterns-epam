import org.example.UKCarPriceCalculator;

public class Main {

    public static void main(String[] args) {
        CarPriceCalculator carPriceCalculator = new CarPriceCalculator("FORD", 3);
        printVehiclePrice(carPriceCalculator);

        TruckPriceCalculator truckPriceCalculator = new TruckPriceCalculator(10, 0);
        printVehiclePrice(truckPriceCalculator);

        UKCarPriceCalculator ukCarPriceCalculator = new UKCarPriceCalculator("UKF1",1);
///        printVehiclePrice(ukCarPriceCalculator);   this is the problem!


    }

    public static void printVehiclePrice(PriceCalculator calculator) {
        String price = calculator.calculatePrice();
        System.out.println("The price of vehicle is: " + price);
    }

}
