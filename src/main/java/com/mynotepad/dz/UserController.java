package com.mynotepad.dz;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import com.mynotepad.dz.*;
import javafx.event.ActionEvent;
import javafx.scene.control.DatePicker;

import javafx.scene.control.DialogPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author 19par
 */
public class UserController implements Initializable {
     //prosiriti usera za email i telefon, telefon samo brojevi
    //event.getCode().isDigitKey() provjera za zadacu za broj telefona
   //napravit cemo drugu listu

    @FXML
    private DialogPane dp;
    @FXML
    private TextField txtIme;
    @FXML
    private TextField txtPrezime;
    @FXML
    private TextField txtAdresa;
    @FXML
    private TextField txtUid;
    @FXML
    private DatePicker datePicker;

    private User user = new User();

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        txtUid.setText("" + user.getUid());

    }

    public void setUser(User user) {
        this.user = user;
        txtUid.setText("" + user.getUid());
        txtIme.setText(user.getIme());
        txtPrezime.setText(user.getPrezime());
        txtAdresa.setText(user.getAdresa());
        datePicker.setValue(user.getDatumRodjenja());

    }

    public User getUser() {
        return user;
    }

    @FXML
    private void imeTyped(KeyEvent event) {
        user.setIme(txtIme.getText());

    }

    @FXML
    private void prezimeTyped(KeyEvent event) {
        user.setPrezime(txtPrezime.getText());
    }

    @FXML
    private void adresaTyped(KeyEvent event) {
        user.setAdresa(txtAdresa.getText());
    }

    @FXML
    private void datumClicked(ActionEvent event) {
        user.setDatumRodjenja(datePicker.getValue());
    }
}
