import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	    Player krunal = new Player("Krunal",100,"Knife");
        System.out.println(krunal);
        saveObject(krunal);

        krunal.setHealth(50);
        saveObject(krunal);
        loadObject(krunal);
        System.out.println(krunal);
    }

    public static ArrayList<String> readValues() {
        ArrayList<String> values = new ArrayList<String>();

        Scanner scanner = new Scanner(System.in);
        boolean quit = false;
        int index = 0;
        System.out.println("Choose\n" +
                "1 to enter a string\n" +
                "0 to quit");

        while (!quit) {
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 0:
                    quit = true;
                    break;
                case 1:
                    System.out.print("Enter a string: ");
                    String stringInput = scanner.nextLine();
                    values.add(index, stringInput);
                    index++;
                    break;
            }
        }
        return values;
    }

    public static void saveObject(ISaveable object) {
        for(int i=0;i<object.writeValues().size();i++) {
            System.out.println("Saving " + object.writeValues().get(i) + " To Storage Device");
        }
    }

    public static void loadObject(ISaveable object) {
        ArrayList<String>values = readValues();
        object.readValues(values);

    }
}
