import java.time.LocalDate;

public class FlightRental {
    private String name;

    public FlightRental(String name) {
        this.name = name;
    }

    public void bookOutwardJourney(LocalDate start) {
        System.out.println("Outbond flight booked for "+start);
    }
    public void bookReturnJourney(LocalDate end) {
        System.out.println("Return flight booked for "+end);
    }

}
