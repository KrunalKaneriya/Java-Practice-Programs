// You job is to create a simple banking application.
// There should be a Bank class
// It should have an arraylist of Branches
// Each Branch should have an arraylist of Customers
// The Customer class should have an arraylist of Doubles (transactions)
// Customer:
// Name, and the ArrayList of doubles.
// Branch:
// Need to be able to add a new customer and initial transaction amount.
// Also needs to add additional transactions for that customer/branch
// Bank:
// Add a new branch
// Add a customer to that branch with initial transaction
// Add a transaction for an existing customer for that branch
// Show a list of customers for a particular branch and optionally a list
// of their transactions
// Demonstration autoboxing and unboxing in your code
// Hint: Transactions
// Add data validation.
// e.g. check if exists, or does not exist, etc.
// Think about where you are adding the code to perform certain actions
public class Main {

    public static void main(String[] args) {
        Bank sbi = new Bank("State Bank Of India");
        sbi.addBranch("Surat");
        sbi.addCustomer("Surat","Krunal",15.00);
        sbi.addCustomer("Surat","Khyati",5.00);
        sbi.addCustomer("Surat","Mona",150.00);
        sbi.addCustomer("Surat","Nanji",1500.00);
        System.out.println("======================================================");
        sbi.addBranch("Rajkot");
//        sbi.listBranches();
        sbi.addCustomer("Rajkot","Arvind",125.64);

        sbi.addTransaction("Surat","Krunal",45.056);
        sbi.addTransaction("Surat","Khyati",450.056);
        sbi.addTransaction("Surat","Mona",99.056);

        sbi.showTransactions("Surat",true);

//        if(!sbi.addCustomer("Melbourne","Brian",78950)){
//            System.out.println("Melbourne Branch is Not Added..");
//        }
//        if(!sbi.addBranch("Surat")) {
//            System.out.println("Surat Already Added..");
//        }
//        if(!sbi.addTransaction("Surat","Jack",4560)) {
//            System.out.println("Customer Not Present");
//        }
        if(!sbi.addCustomer("Surat","Krunal",4500)) {
            System.out.println("Customer Already Added..");
        }
        sbi.addTransaction("Surat","Krunal",15000);
        sbi.showTransactions("Surat",true);
    }
}
