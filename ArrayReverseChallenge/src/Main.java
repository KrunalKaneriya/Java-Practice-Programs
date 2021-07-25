import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        int[] temp = {5,4,3,2,1,8,7};
        reverse(temp);
    }
    public static void reverse(int []array) {
        int max_length = array.length-1;
        int half_length = max_length/2;
        for(int i=0;i<half_length;i++) {
            int temp = array[i];
            array[i] = array[max_length-i];
            array[max_length-i] = temp;
        }
        System.out.println(Arrays.toString(array));
    }
}
