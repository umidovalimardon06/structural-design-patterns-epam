import java.time.LocalDate;

public class VocationClient {
    public static void main(String[] args) {
        LocalDate startDate = LocalDate.of(2026,1,15);
        LocalDate endDate = LocalDate.of(2026,5,15);

        FlightRental flightRental = new FlightRental("F23");
        flightRental.bookOutwardJourney(startDate);
        flightRental.bookOutwardJourney(endDate);

        HotelRental hotelRental = new HotelRental("MiY");
        hotelRental.book(startDate,endDate);

        CarRental carRental = new CarRental("Mazda");
        carRental.book(startDate,endDate);

    }
}
