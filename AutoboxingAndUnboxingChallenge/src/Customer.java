import java.util.ArrayList;

public class Customer {
    private String customerName;
    private ArrayList<Double>transactions;

    public Customer(String customerName,double initialAmount) {
        this.customerName = customerName;
        this.transactions = new ArrayList<>();
        this.transactions.add(initialAmount);
    }

    public Customer(String customerName) {
        this.customerName = customerName;
        this.transactions = new ArrayList<>();
    }

    public String getCustomerName() {
        return customerName;
    }

    public ArrayList<Double> getTransactions() {
        return transactions;
    }
}
