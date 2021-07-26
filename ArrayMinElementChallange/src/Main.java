import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        int [] array = readIntegers(10);
        findMinElement(array);
    }

    //Function to read Count and store the values in array
    public static int[] readIntegers(int count) {
        int []temp = {484,5659,120,654546,96,53,2,-45,-120,45840}; //new Array Declared of User Specified Size
//        System.out.println("You Wanted To Enter " + count + " Elements");
//        for (int i=0;i<count;i++) {
//            int value = scanner.nextInt();
//            temp[i] = value;
//        }
        return temp;
    }

    public static void findMinElement(int []array) {
        int minElement=0;
        minElement = array[0];

        for(int i=0;i< array.length;i++) {
            if(array[i] < minElement) {
                minElement = array[i];
            }
        }

        System.out.println("The Minimum Element is " + minElement);
    }
}
