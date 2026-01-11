public class Manager implements Payee{
    private String name;

    public Manager(String name) {
        this.name = name;
    }

    @Override
    public void pay(int amount) {
        System.out.println(name + " has been paid $" + amount);
    }

}
