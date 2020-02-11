package ziugs.meteo;


import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

public class GUIController implements Initializable {

    @FXML
    private Label label1;
    @FXML
    private Label label2;
    @FXML
    private Label label3;
    @FXML
    private Label label4;
    @FXML
    private Label label5;
    @FXML
    private Label label6;
    @FXML
    private Label label7;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        label1.textProperty().set(Downloader.pressure.get(0) + " hPa");
        label2.textProperty().set(Downloader.temperature.get(0) + " °C");
        label3.textProperty().set(Downloader.visibility.get(0) + " km");
        label4.textProperty().set(Downloader.weatherFenomenon.get(18));
        label5.textProperty().set((Math.round(Integer.parseInt(Downloader.cloudBase.get(18)) * 3.28084)) + " ft");
        label6.textProperty().set(Downloader.okta.get(18) + " okta");
        label7.textProperty().set(Downloader.updateTimeOnServer.get(18) + " local");

    }

    public static void putPressure() {
        for (int i = 4; i < Downloader.allVallues.size(); i += 33) {
            Downloader.allVallues.get(i);
            Downloader.pressure.add(Downloader.allVallues.get(i));
        }
    }


    public static void putTemperature() {
        for (int i = 1; i < Downloader.allVallues.size(); i += 33) {
            Downloader.allVallues.get(i);
            Downloader.temperature.add(Downloader.allVallues.get(i));

        }
    }

    public static void putVisibility() {
        for (int i = 20; i < Downloader.allVallues.size(); i += 33) {
            Downloader.allVallues.get(i);
            Downloader.visibility.add(Downloader.allVallues.get(i));

        }
    }

    public static void putWeatherFenomenon() {
        for (int i = 15; i < Downloader.allVallues.size(); i += 33) {
            Downloader.allVallues.get(i);
            Downloader.weatherFenomenon.add(Downloader.allVallues.get(i));

        }
    }

    public static void putCloudBase() {
        for (int i = 22; i < Downloader.allVallues.size(); i += 33) {
            Downloader.allVallues.get(i);
            Downloader.cloudBase.add(Downloader.allVallues.get(i));

        }
    }

    public static void putOkta() {
        for (int i = 23; i < Downloader.allVallues.size(); i += 33) {
            Downloader.allVallues.get(i);
            Downloader.okta.add(Downloader.allVallues.get(i));
        }
    }

    public static void putUpdateTimeOnServer() {
        for (int i = 0; i < Downloader.allVallues.size(); i += 33) {
            Downloader.allVallues.get(i);
            Downloader.updateTimeOnServer.add(Downloader.allVallues.get(i));
        }
    }

}
