import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class TrafficSimulator {

    static ArrayList<Vehicle> vehicles = new ArrayList<>();

    public static void main(String[] args) {
        Runnable createVehicles = new Runnable() {
            @Override
            public void run() {
                createRandomCar();
            }
        };
        Runnable removeVehicles = new Runnable() {
            @Override
            public void run() {
                removeCar();
            }
        };

        ScheduledExecutorService service = Executors.newScheduledThreadPool(1);
        service.scheduleAtFixedRate(createVehicles, 0, 3, TimeUnit.SECONDS);
        service.scheduleAtFixedRate(removeVehicles, 5, 5, TimeUnit.SECONDS);
    }

    private static void createRandomCar() {
        Random random = new Random();
        int randInt = random.nextInt(2);
        Vehicle vehicle = null;
        if (randInt == 0) {
            vehicle = new Car();
        } else {
            vehicle = new Truck();
        }
        vehicle.setLocation(random.nextInt(1000), random.nextInt(1000));
        System.out.println("Creating " + vehicle + ", type: " + vehicle.getType() +
                ", location: " + vehicle.getLocation()[0] + " " + vehicle.getLocation()[1]);
        vehicles.add(vehicle);
    }

    private static void removeCar() {
        System.out.println("Removing " + vehicles.getFirst());
        vehicles.removeFirst();
    }

}
