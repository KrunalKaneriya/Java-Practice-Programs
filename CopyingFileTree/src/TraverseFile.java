import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

public class TraverseFile extends SimpleFileVisitor<Path>{

    @Override
    public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
        System.out.println("Accessing The Directory: " + dir.toAbsolutePath());
        return FileVisitResult.CONTINUE;
    }

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {

        System.out.println("Reading The File: " + file.toAbsolutePath());
        BufferedReader bufferedReader = new BufferedReader(new FileReader(file.toString()));
        String input;
        while((input = bufferedReader.readLine())!=null) {
            System.out.println("Reading The Line: " + input + " From File " + file.toAbsolutePath());
        }
        return FileVisitResult.CONTINUE;
    }

    @Override
    public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException {
        System.out.println("Error Occurred in " + file.toAbsolutePath() + " " + exc.getMessage());
        return FileVisitResult.CONTINUE;
    }
}
