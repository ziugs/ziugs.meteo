package ziugs.meteo;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {

        Parent root = FXMLLoader.load(getClass().getResource("Login.fxml"));
        primaryStage.setTitle("10 minuti meteo andmed");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();

    }

    public static void main(String[] args) {
        Downloader downloader = new Downloader();
        downloader.doDownload();
        GUIController.putUpdateTimeOnServer();
        GUIController.putPressure();
        GUIController.putTemperature();
        GUIController.putVisibility();
        GUIController.putWeatherFenomenon();
        GUIController.putCloudBase();
        GUIController.putOkta();
        launch(args);

    }
}

