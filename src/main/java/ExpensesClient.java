public class ExpensesClient {

  public static void main(String[] args) {
    Manager kamil = new Manager("Kamil");
    Salesperson bob = new Salesperson("Bob", kamil);
    Salesperson sue = new Salesperson("Sue", kamil);

    SalesTeam team = new SalesTeam();
    team.addManager(kamil);
    team.addSalesperson(bob);
    team.addSalesperson(sue);

    payManager(kamil, 100);
    paySalesperson(bob, 300);
    payTeam(team, 200);

  }

  private static void payManager(Manager manager, int amount) {
    System.out.println("Expenses have been requested");
    manager.payExpenses(amount);
    System.out.println("Expenses have been paid\n");
  }

  private static void paySalesperson(Salesperson salesperson, int amount) {
    System.out.println("Expenses have been requested");
    salesperson.payExpenses(amount);
    System.out.println("Expenses have been paid\n");
  }

  private static void payTeam(SalesTeam team, int amount) {
    System.out.println("Expenses have been requested");
    team.payExpenses(amount);
    System.out.println("Expenses have been paid\n");
  }

}
