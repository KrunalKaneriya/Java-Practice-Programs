public class Main {

    public static void main(String[] args) {
        System.out.println(sumDigits(125));
    }

    public static int sumDigits(int number) {
        int answer=0;
        if(number<10){
            return -1;
        }
        while(number>0) {
            //Extract the least significant digit
            int digit;
            digit = number%10;
            System.out.println(digit);
            answer += digit;

            number/=10;
            System.out.println(number);

        }
        return answer;
    }
}
