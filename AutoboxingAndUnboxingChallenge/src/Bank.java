import java.util.ArrayList;

public class Bank {
    private ArrayList<Branch>branches;
    private String bankName;

    public Bank(String bankName) {
        this.bankName = bankName;
        this.branches = new ArrayList<>();
    }

    public ArrayList<Branch> getBranches() {
        return branches;
    }

    public String getBankName() {
        return bankName;
    }

    public boolean addBranch(String branchName) {
        if(findBranch(branchName) == null) {
            Branch tempBranch = new Branch(branchName);
            this.branches.add(tempBranch);
            System.out.println("Branch " + branchName + " Added to Bank " + getBankName());
        }
        else {
            System.out.println("Error Adding New Branch To Bank");
        }
        return false;
    }

    public boolean addCustomer(String branch,String customer,double initialAmount) {
        Branch tempBranch = findBranch(branch);
        if(tempBranch!=null) {
            return tempBranch.addCustomer(customer,initialAmount);
        }
        return false;
    }

    public Branch findBranch(String branchName) {
        for (int i=0;i<branches.size();i++) {
            Branch checkedBranch = this.branches.get(i);
                if(checkedBranch.getBranchName().equals(branchName)) {
                    return checkedBranch;
                }
        }
        return null;
    }

    public boolean addTransaction(String branchName,String customerName,double amount) {
        Branch branch = findBranch(branchName);
        if(branch!=null) {
            branch.addTransaction(customerName,amount);
            return true;
        }
        System.out.println("Error Adding Transaction to Customer " + customerName + " of Branch " + branchName);
        return false;
    }

    public boolean showTransactions(String branchName,boolean showTransactions) {
        Branch branch = findBranch(branchName);
        if(branch!=null) {
            System.out.println("Showing Details of Branch " + branchName);

            ArrayList<Customer>customers = branch.getCustomers();

            for (int i=0;i<customers.size();i++) {
                Customer customer = customers.get(i);
                System.out.println("Customer " + customer.getCustomerName() + "[" + (i+1) + "]");
                if(showTransactions) {
                    System.out.println("Transactions");
                    ArrayList<Double> transactions = customer.getTransactions();
                    for(int j=0;j<transactions.size();j++) {
                        System.out.println("[" + (j+1) + "] Amount " + transactions.get(j));
                    }
                }
            }
            return true;
        }
        else {
            return false;
        }
    }

    public boolean listBranches() {
        if(this.branches.size()>=0) {
            for (int i=0;i<this.branches.size();i++) {
                System.out.println("Branch " + i + " : " + this.branches.get(i).getBranchName());
            }
            return true;
        }
        System.out.println("No Branches Are There..");
        return false;
    }


}
