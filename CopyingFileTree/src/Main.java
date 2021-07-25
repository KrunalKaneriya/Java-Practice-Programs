import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;

public class Main{
    public static void main(String[] args) {

        Path sourceRoot = FileSystems.getDefault().getPath("MainTree" + File.separator + "Dir3");
        Path targetRoot = FileSystems.getDefault().getPath("MainTree"+File.separator+"AllDirCopies"+File.separator + "Dir3Copy");
        try {
            Files.walkFileTree(sourceRoot,new CopyFile(sourceRoot,targetRoot));
        } catch (IOException e) {
            e.getMessage();
        }
    }
}