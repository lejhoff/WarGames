package no.ntnu.idatg2001.krigslek.ui.views;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;

public class MainWindowApp extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
      //  FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("fxml-files/simulation_page.fxml"));
        //Parent root = fxmlLoader.load();
        Parent root = (Parent)FXMLLoader.load((URL) Objects.requireNonNull(this.getClass().getClassLoader().getResource("fxml-files/front_page.fxml")));
        Scene scene = new Scene(root);

        primaryStage.setScene(scene);
        primaryStage.show();

    }
}
