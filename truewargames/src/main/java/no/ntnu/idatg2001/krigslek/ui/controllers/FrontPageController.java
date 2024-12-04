package no.ntnu.idatg2001.krigslek.ui.controllers;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import no.ntnu.idatg2001.krigslek.model.Army;
import no.ntnu.idatg2001.krigslek.ui.views.ArmyCreationDialog;
import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.Optional;
import java.util.ResourceBundle;

/**
 * The type Front page controller.
 */
public class FrontPageController implements Initializable {

    @FXML
    private void onCreateArmyButtonPress(ActionEvent event) throws IOException {
        ArmyCreationDialog tnDialog = new ArmyCreationDialog();

        Optional<Army> result = tnDialog.showAndWait();

        Parent armyCreationParent = (Parent)FXMLLoader.load((URL)
                Objects.requireNonNull(this.getClass().getClassLoader().getResource("fxml-files/army_creation_page.fxml")));
        Scene armyCreationScene = new Scene(armyCreationParent);
        Stage appStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        appStage.setScene(armyCreationScene);
        appStage.show();
    }

    @FXML
    private void onSimulationPageButtonPress(ActionEvent event) throws IOException {
        Parent simulationPageParent = (Parent)FXMLLoader.load((URL)
                Objects.requireNonNull(this.getClass().getClassLoader().getResource("fxml-files/simulation_page.fxml")));
        Scene simulationPage = new Scene(simulationPageParent);
        Stage appStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        appStage.setScene(simulationPage);
        appStage.show();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
