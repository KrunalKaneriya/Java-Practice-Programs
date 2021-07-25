package sample.PasswordList;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Iterator;

public class PasswordListData {
    private static PasswordListData instance = new PasswordListData();
    public ObservableList<PasswordList>passwordList = FXCollections.observableArrayList();
    private static String filename = "PasswordList.txt";

    public static PasswordListData getInstance() {
        return instance;
    }

    public void addPasswordList(PasswordList item) {
        passwordList.add(item);
    }

    public void deletePasswordList(PasswordList item) {
        passwordList.remove(item);
    }


    //Function to Write The Password Information to File
    public void writePasswordInfo() throws IOException{
        Path path = Paths.get(filename);
        BufferedWriter bw = Files.newBufferedWriter(path);
        try {
            Iterator<PasswordList>passwordListIterator = passwordList.iterator();
            while(passwordListIterator.hasNext()) {
                PasswordList item = passwordListIterator.next();
                bw.write(String.format("%s,%s,%s,%s",item.getPasswordName(),item.getPasswordUsername(),item.getPasswordValue(),item.getPasswordWebsite()));
                bw.newLine();
            }
        } finally {
            if(bw!=null) {
                bw.close();
            }
        }
    }

    //Function to read The Password Information From File
    public void loadPasswordInfo() throws IOException{
        passwordList = FXCollections.observableArrayList();
        Path path = Paths.get(filename);
        BufferedReader br = Files.newBufferedReader(path);
        String input;

        try {
            if(passwordList.isEmpty()) {
                while ((input = br.readLine()) != null) {
                    String[] passwordPieces = input.split(",");
                    String passwordName = passwordPieces[0];
                    String passwordUsername = passwordPieces[1];
                    String passwordValue = passwordPieces[2];
                    String passwordWebsite = passwordPieces[3];

                    PasswordList item = new PasswordList(passwordName, passwordUsername, passwordValue, passwordWebsite);
                    passwordList.add(item);
                }
            }
        } finally {
            if(br!=null) {
                br.close();
            }
        }

    }

    public ObservableList<PasswordList> getPasswordList() {
        return passwordList;
    }
}
