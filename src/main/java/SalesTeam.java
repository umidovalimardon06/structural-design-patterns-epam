import java.util.ArrayList;
import java.util.List;

public class SalesTeam implements Payee{

    private List<Payee> people = new ArrayList<>();

    void addManager(Payee payee) {
        people.add(payee);
    }

    void addSalesPerson(Payee payee) {
        people.add(payee);
    }

    @Override
    public void pay(int amount) {
        people.forEach(payee -> payee.pay(amount));
    }

}
