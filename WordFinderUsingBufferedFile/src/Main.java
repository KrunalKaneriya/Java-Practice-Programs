import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static int wordFoundedCount=0;
    public static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {

        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader("words.txt"));
            String input;
            ArrayList<String>words = new ArrayList<>();
            while((input = bufferedReader.readLine())!=null) {
                String []separatedWords = input.split(" ");
                for(String singleWord :separatedWords) {
                    words.add(singleWord);
                }
            }
            System.out.println("The Total Words Are " + words.size());

            searchWord(words);


        }catch(IOException e) {
            e.printStackTrace();
        }


    }

    public static void searchWord(ArrayList<String>arrayList) {

        System.out.print("Enter The Word To Search in File: ");
        String wordToSearch = scanner.nextLine();
        System.out.println("The User Requested to Search Word: " + wordToSearch);
        for(int i=0;i< arrayList.size();i++) {
            if(arrayList.get(i).contains(wordToSearch)) {
                wordFoundedCount++;
            }
        }
        System.out.println("The Words That Matched to " + wordToSearch + " Are:" + wordFoundedCount);
    }
}
