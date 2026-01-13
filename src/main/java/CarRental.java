import java.time.LocalDate;

public class CarRental {
    private String name;

    public CarRental(String name) {
        this.name = name;
    }

    public void book(LocalDate checkinDate, LocalDate checkoutDate){
        System.out.println("Car " + this.name + " booked for " + checkinDate + " to " + checkoutDate);
    }

}
