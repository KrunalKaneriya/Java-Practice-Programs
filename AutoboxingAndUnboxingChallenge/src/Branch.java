import java.util.ArrayList;

public class Branch {
    private ArrayList<Customer>customers;
    private String branchName;

    public Branch(String branchName) {
        this.branchName = branchName;
        this.customers = new ArrayList<>();
    }

    public ArrayList<Customer> getCustomers() {
        return customers;
    }

    public String getBranchName() {
        return branchName;
    }

    public boolean addCustomer(String customer,double initialAmount) {
        Customer tempCustomer = findCustomer(customer);
        System.out.println("Request For Adding Customer " + customer + " To Branch " + getBranchName());
        if(tempCustomer==null && initialAmount>0) {
            this.customers.add(new Customer(customer,initialAmount));
            System.out.println("Added Customer " + customer + " to Bank And Initial Amount Deposited " + initialAmount);
            return true;
        }
        else {
            System.out.println("Error Adding New Customer to Branch " + getBranchName());
            return false;
        }
    }

    public boolean addTransaction(String customerName,double amount) {
        Customer customer = findCustomer(customerName);
        if(customer!=null) {
            customer.getTransactions().add(amount);
            System.out.println("Added " + amount + " to Customer " + customer.getCustomerName());
            return true;
        }
        else {
            System.out.println("Error Adding Transaction to Customer " + customerName);
            return false;
        }
    }

    public Customer findCustomer(String CustomerName) {
       for(int i=0;i<this.customers.size();i++) {
           if(this.customers.get(i).getCustomerName().equalsIgnoreCase(CustomerName)) {
               return this.customers.get(i);
           }
       }
       return null;
    }


}
