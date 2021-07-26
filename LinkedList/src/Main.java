import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        LinkedList<String>placestoVisit = new LinkedList<>();
        sortList(placestoVisit,"Surat");
        sortList(placestoVisit,"Rajkot");
        sortList(placestoVisit,"Amreli");
        sortList(placestoVisit,"Bhavnagar");
        sortList(placestoVisit,"Kamrej");
        sortList(placestoVisit,"Botad");
        sortList(placestoVisit,"Ahmedabad");
        sortList(placestoVisit,"Baroda");
        sortList(placestoVisit,"Navsari");
        sortList(placestoVisit,"Kolki");
        visit(placestoVisit);

    }

    public static void printlist(LinkedList<String>list) {
        Iterator<String>i = list.iterator();
        while(i.hasNext()) {
            System.out.println(i.next());
        }
        System.out.println("======================================================= "   );
    }

    private static boolean sortList(LinkedList<String>list,String newCity) {
        ListIterator<String>listIterator = list.listIterator();

        while(listIterator.hasNext()) {
            int comparison = listIterator.next().compareTo(newCity);

            if(comparison == 0) {
                System.out.println("City " + newCity + " is Already Added in List.");
                return false;
            }
            else if(comparison > 0) {
                listIterator.previous();
                listIterator.add(newCity);
                return true;
            }
            else if(comparison < 0 ) {
                //The List is in The Order it is Added. We Don't Need to Do Anything
            }
        }
        listIterator.add(newCity);
        return true;
    }

    private static void visit(LinkedList cities) {
        Scanner scanner = new Scanner(System.in);
        boolean quit = false;
        boolean goingForward = true;
        ListIterator<String>listIterator = cities.listIterator();

        if(cities.isEmpty()) {
            return;
        }
        else {
            System.out.println("Now Visiting " + listIterator.next());
            printMenu();
        }

        while(!quit) {
            int action = scanner.nextInt();
            scanner.nextLine();

            switch (action) {
                case 0:
                    System.out.println("Vacation Over");
                    quit = true;
                    break;
                case 1:
                    if(!goingForward) {
                        if(listIterator.hasNext()) {
                            listIterator.next();
                            goingForward=true;
                        }
                    }
                    if(listIterator.hasNext()) {
                        System.out.println("Now Visiting " + listIterator.next());
                    } else {
                        System.out.println("Reached The End of The List..");
                        goingForward =false;
                    }
                    break;
                case 2:
                    if(goingForward) {
                        if(listIterator.hasPrevious()) {
                            listIterator.previous();
                            goingForward  = false;
                        }
                    }
                    if(listIterator.hasPrevious()) {
                        System.out.println("Now Visiting " + listIterator.previous());
                    } else {
                        System.out.println("Reached The Start of The List..");
                        goingForward = true;
                    }
                    break;
                case 3:
                    printMenu();
                    break;

            }
        }
    }

    private static void printMenu() {
        System.out.println("Available Options:\npress ");
        System.out.println("0 - To Quit\n" +
                "1 = Go to next city\n" +
                "2 = Go to previous city\n" +
                "3 = Print The Menu Options.");
    }
}
