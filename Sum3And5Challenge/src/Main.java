public class Main {

    public static void main(String[] args) {
        int count = 0;
        int sum = 0;
        for (int i = 0; i <= 1000; i++) {
            if ((i % 3 == 0) && (i % 5 == 0)) {
                System.out.println(i);
                sum += i;
                count++;
            }
            if (count > 10) {
                break;
            }
        }
        System.out.println("Sum is " + sum);
    }
}