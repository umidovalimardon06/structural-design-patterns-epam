import java.time.LocalDate;

public class VocationClient {
    public static void main(String[] args) {
        LocalDate startDate = LocalDate.of(2026,1,15);
        LocalDate endDate = LocalDate.of(2026,5,15);

        VacationFacade facade = new VacationFacade();
        facade.book(startDate,endDate);

    }
}
