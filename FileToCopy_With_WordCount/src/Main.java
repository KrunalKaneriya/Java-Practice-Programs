import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static int lineNumber = 1;
    public static Scanner scanner = new Scanner(System.in);
    private static ArrayList<String>words = new ArrayList<>();

    public static void main(String[] args) {
        try(BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("Sorted_words.txt"))) {
            for(int i=0;i< words.size();i++) {
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append(lineNumber++);
                    stringBuilder.append("  ");
                    stringBuilder.append(words.get(i));
                    bufferedWriter.write(stringBuilder + "\n");
                System.out.println(words.get(i));
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader("words.txt"))) {
            String input;
            while((input = bufferedReader.readLine())!=null) {
                if(!input.equals("")){
                    words.add(input);
                }

            }

        }catch (IOException e) {
            e.printStackTrace();
        }
    }
}