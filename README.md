# Adapter Problem Demonstration

## Muammo

Ushbu loyihada `UKCarPriceCalculator` klassini `printVehiclePrice()` metodiga uzatib bo'lmaydi.

## Kod

```java
public class Main {
    public static void main(String[] args) {
        CarPriceCalculator carPriceCalculator = new CarPriceCalculator("FORD", 3);
        printVehiclePrice(carPriceCalculator);  // ✓ Ishlaydi

        TruckPriceCalculator truckPriceCalculator = new TruckPriceCalculator(10, 0);
        printVehiclePrice(truckPriceCalculator);  // ✓ Ishlaydi

        UKCarPriceCalculator ukCarPriceCalculator = new UKCarPriceCalculator("UKF1", 1);
        // printVehiclePrice(ukCarPriceCalculator);  // ✗ ISHLAMAYDI!
    }

    public static void printVehiclePrice(PriceCalculator calculator) {
        String price = calculator.calculatePrice();
        System.out.println("The price of vehicle is: " + price);
    }
}
```

## Nima bo'lmoqda?

- `printVehiclePrice()` metodi faqat `PriceCalculator` tipidagi parametrni qabul qiladi
- `CarPriceCalculator` va `TruckPriceCalculator` `PriceCalculator` dan meros olgan
- `UKCarPriceCalculator` esa `PriceCalculator` dan meros olmagan yoki uni implement qilmagan
- Shuning uchun `UKCarPriceCalculator` ni `printVehiclePrice()` ga uzatib bo'lmaydi

## Xulosa

Bu **Adapter Pattern** muammosi - `UKCarPriceCalculator` mavjud interfeys bilan mos kelmaydi.