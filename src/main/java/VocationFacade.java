import java.time.LocalDate;

public class VacationFacade {
    public void book(LocalDate startDate,LocalDate endDate){
        FlightRental flightRental = new FlightRental("F23");
        flightRental.bookOutwardJourney(startDate);
        flightRental.bookOutwardJourney(endDate);

        HotelRental hotelRental = new HotelRental("MiY");
        hotelRental.book(startDate,endDate);

        CarRental carRental = new CarRental("Mazda");
        carRental.book(startDate,endDate);
    }
}
