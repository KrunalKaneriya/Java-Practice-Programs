package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;
import javafx.stage.FileChooser;

import java.io.*;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.StandardCharsets;
import java.nio.file.FileStore;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.attribute.FileAttribute;
import java.util.Optional;
import java.util.Scanner;

import static java.lang.System.exit;

public class Controller {
    @FXML
    private TextArea notesTextArea;
    @FXML
    private MenuItem openFile;
    @FXML
    private MenuItem saveFile;
    @FXML
    private MenuItem quit;

    private Path defaultPath = FileSystems.getDefault().getPath("C:\\Users" + File.separator + System.getProperty("user.name") + File.separator + "Desktop");
    private File fileToLoad;

    @FXML
    public File chooseFile() {
        FileChooser chooser = new FileChooser();
        chooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Text Files (*.txt)", "*.txt"));
        chooser.setInitialDirectory(defaultPath.toFile());

        fileToLoad = chooser.showOpenDialog(null);

        if (fileToLoad != null) {
            loadFileToTextArea(fileToLoad);
            return fileToLoad;
        }
        return null;
    }

    public void loadFileToTextArea(File fileToLoad) {
        notesTextArea.setWrapText(true);
        int lineCount = 0;
        try {
            FileReader reader = new FileReader(fileToLoad);
            String tempText;
            BufferedReader bufferedReader = new BufferedReader(reader);
            while ((tempText = bufferedReader.readLine()) != null) {
                if (notesTextArea.getCaretPosition() == 0) {

                }
                notesTextArea.appendText(tempText);
                notesTextArea.appendText("\n");
                lineCount++;
            }

        } catch (IOException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setContentText("Error Loading The File..");

        }

    }

    @FXML
    public void saveFile() throws IOException {

        if (fileToLoad != null) {
            try (FileOutputStream outputStream = new FileOutputStream(fileToLoad);FileChannel fileChannel = outputStream.getChannel()) {
                System.out.println(fileToLoad.getAbsolutePath());
                byte[] notesText = notesTextArea.getText().getBytes(StandardCharsets.UTF_8);
                ByteBuffer buffer = ByteBuffer.wrap(notesText);
                fileChannel.write(buffer);
                buffer.flip();
            }
        }

        if(fileToLoad == null) {
           FileChooser chooser = new FileChooser();
           chooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Text File (.txt)","*.txt"));
           chooser.setInitialDirectory(defaultPath.toFile());
           File fileSave = chooser.showSaveDialog(null);
           chooser.setInitialFileName("Text File");
            System.out.println(fileSave.getAbsolutePath());
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileSave))) {
                writer.write(notesTextArea.getText());
            }
        }
    }

    public void quitWindow() {
        exit(0);
    }
}
