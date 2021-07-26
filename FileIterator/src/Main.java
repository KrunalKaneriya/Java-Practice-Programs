import java.io.File;
import java.nio.file.Files;
import java.util.*;

/*
Create a program to replicate the functions of File manager
Now firstly we need to create a class Folder and other class Files
now the Folder class has only folder name and it will be the root and in the folder we have
to add functionality to create files and now Files can be created by only Name afterwards
we will create functionality to create new files on demand.

The final Program output will be like the list of folders and in the folder we can go via some
selection and in the folder we can see the Files names and to increase the functionality create
files on user selection and add subdirectories to folders
 */
public class Main {

    public static void main(String[] args) {


        Directories dir1 = new Directories("Downloads");
        dir1.addFile("File1.txt");
        dir1.addFile("File2.txt");
        dir1.addFile("File3.txt");
//        dir1.printFiles();


        Directories softwares = new Directories("Softwares");
        softwares.addFile("File1.exe");
        softwares.addFile("File2.exe");
        softwares.addFile("File3.exe");


        Directories images = new Directories("Images");
        images.addFile("Img1.jpg");
        images.addFile("Img2.jpg");
        images.addFile("Img3.jpg");

        FilesAndFolders.getInstance().addDirectory(dir1);
        FilesAndFolders.getInstance().addDirectory(softwares);
        FilesAndFolders.getInstance().addDirectory(images);
//        FilesAndFolders.getInstance().printDirectories(FilesAndFolders.getInstance().findDirectory("Softwares"));

        FilesAndFolders.getInstance().start();
    }
}
