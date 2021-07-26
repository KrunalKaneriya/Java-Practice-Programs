import java.util.ArrayList;
import java.util.Scanner;

public class MobilePhone {
    Scanner scanner = new Scanner(System.in);
    ArrayList<Contacts>contactsArrayList;

    //Constructor to initialize the Arraylist.
    public MobilePhone() {
        this.contactsArrayList = new ArrayList<>();
    }

    public boolean addContact() {
        System.out.print("Enter The Contact Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter The Contact Number: ");
        String number = scanner.nextLine();
        if(number.length()==10) {
            addContact(name, number);
            return true;
        } else {
            System.out.println("Number is not Valid..");
            return false;
        }

    }

    public void addContact(String ContactName,String ContactNumber) {
        Contacts contact = new Contacts(ContactName,ContactNumber);
        contactsArrayList.add(contact);
    }

    private int findContact(String contactName) {
        for(int i=0;i<contactsArrayList.size();i++) {
            Contacts contact = this.contactsArrayList.get(i);
            if(contact.getContactName().equalsIgnoreCase(contactName)) {
                return i;
            }
        }
        return -1;
    }

    public void findContact() {
        System.out.print("Enter the Contact Name: ");
        String contactName = scanner.nextLine();
        int indexOfContact = findContact(contactName);
        if(indexOfContact >=0) {
            System.out.println("========================================");
            System.out.println("Contact is Founded Successfully...");
            System.out.println("The Contact Name is: " + contactsArrayList.get(indexOfContact).getContactName());
            System.out.println("The Contact Number is: " + contactsArrayList.get(indexOfContact).getContactNumber());
            System.out.println("========================================");
        }
        else {
            System.out.println("========================================");
            System.out.println("The Contact Has not Been Founded....");
            System.out.println("========================================");
        }
    }

    private int findContact(Contacts contact) {
        return contactsArrayList.indexOf(contact);
    }


    public void printContacts(){
        System.out.println("You Have " + contactsArrayList.size() + " Contacts on Your Phone..");
        for (int i=0;i<contactsArrayList.size();i++) {
            System.out.println((i+1) + ". " + contactsArrayList.get(i));
        }
    }

    //Update Contact Function
    public boolean updateContact() {
        System.out.println("Enter the Contact you Want to Update: ");
        String contactName = scanner.nextLine();
        int indexOfContact= findContact(contactName);
        if(indexOfContact>=0) {
            System.out.println("Enter The Field You Want to Edit: ");
            System.out.println("Enter 1 To Change The Name: ");
            System.out.println("Enter 2 To Change The Number: ");
            int choice = scanner.nextInt();
            scanner.nextLine();
            if(choice ==1 ){
                updateContactName(indexOfContact);
            }
            if(choice == 2) {
                updateContactNumber(indexOfContact);
            }
            return true;
        }
        else {
            System.out.println("Sorry Contact Not Founded.");
            return false;
        }
    }

    private void updateContactName(int indexOfContact) {
       System.out.print("Enter The New Contact Name: ");
       String newContactName = scanner.nextLine();
//       if(findContact(newContactName) !=1 ) {
//
//       }
      contactsArrayList.get(indexOfContact).setContactName(newContactName);
    }

    private void updateContactNumber(int indexOfContact) {
        System.out.println("Enter The New Contact Number: ");
        String newContactNumber = scanner.nextLine();
        contactsArrayList.get(indexOfContact).setContactNumber(newContactNumber);
    }

    public boolean removeContact() {
        System.out.print("Enter The Contact Name to Remove: ");
        String contact = scanner.nextLine();
        int indexOfContact = findContact(contact);
        if(indexOfContact>=0) {
            contactsArrayList.remove(indexOfContact);
            System.out.println("Contact " + contact + " Removed Successfully..");
            return true;
        }
        else {
            System.out.println("Contact Not Founded. So Cannot be Removed..");
            return false;
        }
    }

}
