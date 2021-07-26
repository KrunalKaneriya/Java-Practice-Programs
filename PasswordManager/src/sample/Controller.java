package sample;

import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TextField;
import sample.PasswordList.PasswordList;
import sample.PasswordList.PasswordListData;

import java.util.ArrayList;
import java.util.List;

public class Controller {
    @FXML
    ListView<PasswordList>passwordListListView;
    @FXML
    TextField passwordFieldName;
    @FXML
    TextField passwordFieldPassword;
    @FXML
    TextField passwordFieldWebsite;
    @FXML
    TextField passwordFieldUsername;

    public void initialize() {

        passwordListListView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<PasswordList>() {
            @Override
            public void changed(ObservableValue<? extends PasswordList> observableValue, PasswordList oldValue, PasswordList newValue) {
                if(newValue!=null) {
                    PasswordList passwordListValue = passwordListListView.getSelectionModel().getSelectedItem();
                    passwordFieldName.setText(passwordListValue.getPasswordName());
                    passwordFieldPassword.setText(passwordListValue.getPasswordValue());
                    passwordFieldWebsite.setText(passwordListValue.getPasswordWebsite());
                    passwordFieldUsername.setText(passwordListValue.getPasswordUsername());
                }
            }
        });

        passwordListListView.setItems(PasswordListData.getInstance().getPasswordList());
        passwordListListView.getSelectionModel().selectFirst();
        passwordListListView.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);


    }

    @FXML
    public void handleExit() {
        Platform.exit();
    }
}
