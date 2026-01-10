# Adapter Pattern Solution

## Yechim: Adapter Pattern

`UKCarPriceCalculator` ni `PriceCalculator` interfacega moslashtirish uchun Adapter klassidan foydalanamiz.

### Adapter Klassi

```java
import org.example.UKCarPriceCalculator;

public class Adapter implements PriceCalculator {
    private UKCarPriceCalculator ukCarPriceCalculator;

    public Adapter(UKCarPriceCalculator ukCarPriceCalculator) {
        this.ukCarPriceCalculator = ukCarPriceCalculator;
    }

    @Override
    public String calculatePrice() {
        return ukCarPriceCalculator.getPrice() + " : GDP";
    }
}
```

### Yangilangan Main Klassi

```java
import org.example.UKCarPriceCalculator;

public class Main {

    public static void main(String[] args) {
        CarPriceCalculator carPriceCalculator = new CarPriceCalculator("FORD", 3);
        printVehiclePrice(carPriceCalculator);

        TruckPriceCalculator truckPriceCalculator = new TruckPriceCalculator(10, 0);
        printVehiclePrice(truckPriceCalculator);

        UKCarPriceCalculator ukCarPriceCalculator = new UKCarPriceCalculator("UKF1", 1);
        
        // Adapter yordamida UKCarPriceCalculator ni PriceCalculator ga o'giramiz
        Adapter adapter = new Adapter(ukCarPriceCalculator);
        printVehiclePrice(adapter);  // ✓ Endi ishlaydi!
    }

    public static void printVehiclePrice(PriceCalculator calculator) {
        String price = calculator.calculatePrice();
        System.out.println("The price of vehicle is: " + price);
    }
}
```

## Qanday ishlaydi?

1. `Adapter` klassi `PriceCalculator` interfaceini implement qiladi
2. `Adapter` ichida `UKCarPriceCalculator` obyektini saqlaymiz
3. `calculatePrice()` metodi `UKCarPriceCalculator` ning `getPrice()` metodini chaqiradi
4. Natijani kerakli formatda qaytaradi

Bu klassik **Adapter Design Pattern** misoli - mos kelmaydigan interfacelarni bir-biriga bog'laydi.

---

## Muammoni ko'rish

Muammoning tavsifi `main` branchda joylashgan.