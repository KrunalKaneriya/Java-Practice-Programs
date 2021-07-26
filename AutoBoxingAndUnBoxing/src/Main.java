import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        ArrayList<Integer>integerArraylist = new ArrayList<>();
	    for(int i=0;i<10;i++) {
            integerArraylist.add(Integer.valueOf(i));
        }

	    for(int i=0;i<10;i++) {
            System.out.println(i + " --> " + integerArraylist.get(i).intValue());
        }
    }

    Integer myValue =  56; //Integer.valueOf(56);
    int myintValue = myValue; //myValue.intValue();
}
