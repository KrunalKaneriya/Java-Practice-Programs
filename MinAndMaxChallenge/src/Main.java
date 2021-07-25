import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
	    int max=0;
	    int min=0;
        boolean first = true;
	    while(true) {
            System.out.println("Enter Number: ");
            boolean isInt = scanner.hasNextInt();

            if(isInt) {
                int number = scanner.nextInt();

                if(first) {
                    max = number;
                    min = number;
                    first = false;
                }
                if(number > max) {
                    max = number;
                }
                if(number<min) {
                    min = number;
                }

            }else {
                break;
            }
            scanner.nextLine();

        }
        System.out.println("Max Number is " + max + " Min Number is "+ min);
	    scanner.close();
    }
}
