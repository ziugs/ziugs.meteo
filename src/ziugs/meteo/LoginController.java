package ziugs.meteo;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class LoginController implements Initializable {

    @FXML
    private javafx.scene.control.TextField LoginUser;
    @FXML
    private PasswordField LoginPassword;
    @FXML
    private javafx.scene.control.Button LoginButton;
    @FXML
    private Label WrongLoginOrPassLabel;

    static String log;
    static String pass;


    public void Login(javafx.event.ActionEvent event) throws IOException {
        if (LoginUser.getText().equals("ppalennusalk") && LoginPassword.getText().equals("***")) {
            log = "ppalennusalk";
            pass = "***";
            Stage loginStage = new Stage();
            Parent root = FXMLLoader.load(getClass().getResource("TabPane.fxml"));
            loginStage.setTitle("10 minuti meteo andmed");
            loginStage.setScene(new Scene(root));
            loginStage.show();
        }
        if (!LoginUser.getText().equals("ppalennusalk")) {
            WrongLoginOrPassLabel.setText("Vale kasutaja");

        }
        if (!LoginPassword.getText().equals("***")) {
            WrongLoginOrPassLabel.setText("Vale parool");
        }
        if (!LoginUser.getText().equals("ppalennusalk") && !LoginPassword.getText().equals("***")) {
            WrongLoginOrPassLabel.setText("Vale kasutaja ja parool");
        }


    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {


    }


}
