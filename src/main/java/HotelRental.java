import java.time.LocalDate;

public class HotelRental {

    private String name;

    public HotelRental(String name) {
        this.name = name;
    }

    public void book(LocalDate checkinDate, LocalDate checkoutDate) {
        System.out.println("Hotel " + this.name + " booked for " + checkinDate + " to " + checkoutDate);
    }

}
