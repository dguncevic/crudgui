package com.mynotepad.dz;

import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import com.mynotepad.dz.*;
import javafx.application.Platform;

import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.DialogPane;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author dguncevic
 */
public class MainController implements Initializable {

    @FXML
    private ListView<User> listView;
    @FXML
    private Button addButton;
    @FXML
    private Button editUser;
    @FXML
    private Button deleteUser;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO

        listView.setOnMouseClicked((event) -> {
            if (event.getClickCount() == 2) {
                User temp = listView.getSelectionModel().getSelectedItem();
                editClicked(event);
            }
        });
    }

    @FXML
    private void addClicked(MouseEvent event) {

        try {
            FXMLLoader loader = new FXMLLoader(App.class.getResource("user.fxml"));
            DialogPane dp = loader.load();

            UserController uc = loader.getController();

            Dialog<ButtonType> dialog = new Dialog<>();
            dialog.setDialogPane(dp);
            Optional<ButtonType> addButton = dialog.showAndWait();

            if (addButton.get() == ButtonType.OK) {
                User temp = uc.getUser();

                if (temp.getIme() != null && temp.getPrezime() != null) {
                    System.out.println(temp.toString());
                    listView.getItems().add(temp);
                } else {
                    User.counter--;
                }

            } else {
                User.counter--;
            }

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    @FXML
    private void editClicked(MouseEvent event) {
        User temp = listView.getSelectionModel().getSelectedItem();
        FXMLLoader loader = new FXMLLoader(App.class.getResource("user.fxml"));
        try {
            DialogPane dp = loader.load();
            Dialog<ButtonType> dialog = new Dialog<>();
            dialog.setDialogPane(dp);
            UserController uc = loader.getController();
            uc.setUser(temp);

            Optional<ButtonType> editButton = dialog.showAndWait();
            if (editButton.get() == ButtonType.OK) {

                User modified = uc.getUser();
                listView.getItems().remove(listView.getSelectionModel().getSelectedIndex());
                listView.getItems().add(modified);
                User.counter--;
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    @FXML
    private void deleteClicked(MouseEvent event) {
        Platform.runLater(() -> {
            listView.getItems().remove(listView.getSelectionModel().getSelectedIndex());
//        listView.refresh();
        });

    }

}
