public class Main {

    public static void main(String[] args) {
        Bank krunal = new Bank("Krunal Kaneria","6353897450",50000,"xyz@gmail.com","9978965410");
        krunal.deposit(5000);
        krunal.getBalance();
        krunal.withdraw(4000);
        krunal.getBalance();
        krunal.withdraw(100000);

    }
}
