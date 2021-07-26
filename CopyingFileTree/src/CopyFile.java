import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

public class CopyFile extends SimpleFileVisitor<Path> {
    private Path sourceRoot;
    private Path targetRoot;

    public CopyFile(Path sourceRoot, Path targetRoot) {
        this.sourceRoot = sourceRoot;
        this.targetRoot = targetRoot;
    }

    @Override
    public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
        System.out.println("Now visiting" + dir);
        Path relativizedPath = sourceRoot.relativize(dir);
        System.out.println("The Relativized Directory Path is: " + relativizedPath.normalize() + " && " + relativizedPath.normalize().toAbsolutePath());
        Path copyDir = targetRoot.resolve(relativizedPath);
        System.out.println("The Resolved Directory Path is: " + copyDir);
        try {
            Files.copy(dir,copyDir, StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            e.getMessage();
        }
        return FileVisitResult.CONTINUE;
    }

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        Path relativizedPath = sourceRoot.relativize(file);
        System.out.println("The Relativized File Path is: " + relativizedPath);
        Path copyDir = targetRoot.resolve(relativizedPath);
        System.out.println("The Resolved File Path is: " + copyDir);
        try {
            Files.copy(file,copyDir,StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            e.getMessage();
        }
        return FileVisitResult.CONTINUE;
    }

}
