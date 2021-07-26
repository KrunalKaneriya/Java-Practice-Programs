import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
	    MobilePhone mobilePhone = new MobilePhone();
	    mobilePhone.addContact("Krunal","9925809188");
	    mobilePhone.addContact("Khyati","8945464135");
		mobilePhone.addContact("Nanu","7459842360");
		mobilePhone.addContact("Mona","4589647890");
		mobilePhone.addContact("Deep","4565754511");
		mobilePhone.addContact("Jigar","8945464135");
		mobilePhone.addContact("Raju","9927419188");
		mobilePhone.addContact("Vikram","8945784235");
//	    mobilePhone.printContacts();

	    while(true) {
			int choice;
			System.out.print("Enter a Choice: ");
			if(scanner.hasNextInt()) {
				choice = scanner.nextInt();

				switch (choice) {
					case 1:
						printMenu();
						break;
					case 2:
						mobilePhone.printContacts();
						break;
					case 3:
						mobilePhone.addContact();
						break;
					case 4:
						mobilePhone.findContact();
						break;
					case 5:
						mobilePhone.updateContact();
						break;
					case 6:
						mobilePhone.removeContact();
						break;
					default:
						System.out.println("Select Appropriate Option.");
						break;
				}
			}
		}





    }

    public static void printMenu() {
		System.out.println("1. To Print The Menu.");
		System.out.println("2. To Print The Contacts.");
		System.out.println("3. To Add a Contact.");
		System.out.println("4. To Find a Contact.");
		System.out.println("5. To Rename Contact.");
		System.out.println("6. To Delete Contact.");
	}

}
