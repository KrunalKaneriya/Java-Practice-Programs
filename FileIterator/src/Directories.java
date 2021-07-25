import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Directories {
    private String directoryName;
    private List<Files>files = new ArrayList<>();
    private Scanner scanner =  new Scanner(System.in);

    public Directories(String directoryName) {
        this.directoryName = directoryName;
    }

    public void addFile(String fileName) {
            Files filetoAdd = findFile(fileName);
            if(filetoAdd==null) {
                filetoAdd = new Files(fileName);
                this.files.add(filetoAdd);
//                System.out.println("File Added: " + fileName + " in folder: " + this.directoryName);
            }
            else {
                System.out.println("File Cannot Added in Folder: " + this.directoryName);
            }
    }

    public boolean renameFile(String fileName) {
        Files tempFile = findFile(fileName);
        if(tempFile!=null) {
            System.out.print("Enter The New Name: ");
            String newName = scanner.nextLine();
            System.out.println("The Name Will Be Renamed From " + fileName + " To " + newName);
            System.out.println("Do You Want to Rename it? Press Y For Yes and N for No");
            String choice = scanner.nextLine();
            choice = choice.toUpperCase();
            if(choice.contains("Y")) {
                tempFile.setFileName(newName);
                System.out.println("Name Changed..");
                return true;
            }

        }
        return false;
    }

    public Files findFile(String fileName) {
        for(Files eachFile:files) {
            if(eachFile.getFileName().equalsIgnoreCase(fileName)) {
                return eachFile;
            }
        }
        return null;
    }

    public String getDirectoryName() {
        return directoryName;
    }

    public void setDirectoryName(String directoryName) {
        this.directoryName = directoryName;
    }

    public List<Files> getFiles() {
        return files;
    }

    public void setFiles(List<Files> files) {
        this.files = files;
    }

    public void printFiles() {
            for(Files eachFile:this.files) {
                System.out.println("\t\t\tFile: " + eachFile);
        }
    }

}
