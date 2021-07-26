public class Bank {
    private String name;
    private String accountNumber;
    private double balance;
    private String email;
    private String phoneNumber;

    public Bank(String name, String accountNumber, double balance, String email, String phoneNumber) {
        this.name = name;
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }
    public Bank() {
        this.name = "Null Name";
        this.accountNumber = "000";
        this.balance = 0.00;
        this.email = "Null";
        this.phoneNumber = "000";
    }

    public void deposit(double amount) {
        this.balance += amount;
        System.out.println("Deposited " + amount + " in Account " + this.name + " and Balance is " + this.balance);
    }

    public void withdraw(double amount) {
        if(this.balance < amount) {
            System.out.println("Insufficient Funds " + " Tried to Withdraw " + amount + " But Balance is " + this.balance);
        }
        this.balance -= amount;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public double getBalance() {
        System.out.println("The Balance is " + this.balance);
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
