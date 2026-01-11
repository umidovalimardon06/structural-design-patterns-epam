public class ExpensesClient {

    public static void main(String[] args) {
        Manager kamil = new Manager("Kamil");
        SalesPerson bobur = new SalesPerson("Bobur", kamil);
        SalesPerson salima = new SalesPerson("Salima", kamil);

        SalesTeam team = new SalesTeam();
        team.addManager(kamil);
        team.addSalesPerson(bobur);
        team.addSalesPerson(salima);

        payPayee(kamil,100);
        payPayee(bobur,300);
        payPayee(team,200);

    }

    private static void payPayee(Payee payee, int amount) {
        System.out.println("Expenses have been requested");
        payee.pay(amount);
        System.out.println("Expenses have been paid\n");
    }


}
