package no.ntnu.idatg2001.krigslek.ui.controllers;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import no.ntnu.idatg2001.krigslek.model.*;
import no.ntnu.idatg2001.krigslek.model.Units.Unit;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

/**
 * The type Army creation controller.
 */
public class ArmyCreationController implements Initializable {
    @FXML
    private Label armyName;
    @FXML
    private TableView<Unit> tableView;
    @FXML
    TableColumn<Unit,String> typeColumn;
    @FXML
    TableColumn<Unit,String> nameColumn;
    @FXML
    TableColumn<Unit,Integer> healthColumn;
    @FXML
    TableColumn<Unit,Integer> attackColumn;
    @FXML
    TableColumn<Unit,Integer> defenceColumn;
    @FXML
    private TextField infantryNumber;
    @FXML
    private TextField rangedNumber;
    @FXML
    private TextField cavalryNumber;
    @FXML
    private TextField commanderNumber;
    @FXML
    private TextField infantryName;
    @FXML
    private TextField rangedName;
    @FXML
    private TextField cavalryName;
    @FXML
    private TextField commanderName;
    @FXML
    private TextField infantryHealth;
    @FXML
    private TextField rangedHealth;
    @FXML
    private TextField cavalryHealth;
    @FXML
    private TextField commanderHealth;

    private ArmyFileHandler fileHandler;
    private UnitFactory unitFactory;
    private Army draftList;
    private ObservableList<Unit> draftObservableList;

    @FXML
    private void onBackButtonPress(ActionEvent event) throws IOException {
        Parent armyCreationParent = (Parent) FXMLLoader.load((URL)
                Objects.requireNonNull(this.getClass().getClassLoader().getResource("fxml-files/front_page.fxml")));
        Scene frontPageScene = new Scene(armyCreationParent);
        Stage appStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        appStage.setScene(frontPageScene);
        appStage.show();
    }

    @FXML
    private void onAddInfantryUnitsButtonClick(ActionEvent event) {
        String name = infantryName.getText();
        int health = Integer.parseInt(infantryHealth.getText());
        int numberOfUnits = Integer.parseInt(infantryNumber.getText());

        if (draftList == null) {
            draftList = new Army(armyName.getText());
            draftList.addAll(unitFactory.createManyUnits("Infantry", name, health, numberOfUnits));
            for (Unit unit : draftList.getInfantryUnit()) {
                draftObservableList = FXCollections.observableList(draftList.getAllUnits());
                tableView.setItems(draftObservableList);
            }
                infantryNumber.clear();
                infantryHealth.clear();
                infantryName.clear();

        } else {
            draftList.addAll(unitFactory.createManyUnits("Infantry", name, health, numberOfUnits));
            for (Unit unit : draftList.getInfantryUnit()) {
                draftObservableList = FXCollections.observableList(draftList.getAllUnits());
                tableView.setItems(draftObservableList);
            }
        }
        infantryNumber.clear();
        infantryHealth.clear();
        infantryName.clear();
    }

    @FXML
    private void onAddRangedUnitsButtonClick() {
        String name = rangedName.getText();
        int health = Integer.parseInt(rangedHealth.getText());
        int numberOfUnits = Integer.parseInt(rangedNumber.getText());

        if (draftList == null) {
            draftList = new Army(armyName.getText());
            draftList.addAll(unitFactory.createManyUnits("Ranged", name, health, numberOfUnits));
            for (Unit unit : draftList.getRangedUnit()) {
                draftObservableList = FXCollections.observableList(draftList.getAllUnits());
                tableView.setItems(draftObservableList);
            }
            rangedNumber.clear();
            rangedHealth.clear();
            rangedName.clear();

        } else {
            draftList.addAll(unitFactory.createManyUnits("Ranged", name, health, numberOfUnits));
            for (Unit unit : draftList.getRangedUnit()) {
                draftObservableList = FXCollections.observableList(draftList.getAllUnits());
                tableView.setItems(draftObservableList);
            }
        }
        rangedNumber.clear();
        rangedHealth.clear();
        rangedName.clear();
    }

    @FXML
    private void onAddCavalryUnitButtonClick() {
        String name = cavalryName.getText();
        int health = Integer.parseInt(cavalryHealth.getText());
        int numberOfUnits = Integer.parseInt(cavalryNumber.getText());

        if (draftList == null) {
            draftList = new Army(armyName.getText());
            draftList.addAll(unitFactory.createManyUnits("Cavalry", name, health, numberOfUnits));
            for (Unit unit: draftList.getCavalryUnit()) {
                draftObservableList = FXCollections.observableList(draftList.getAllUnits());
                tableView.setItems(draftObservableList);
            }
            cavalryNumber.clear();
            cavalryHealth.clear();
            cavalryName.clear();

        } else {
            draftList.addAll(unitFactory.createManyUnits("Cavalry", name, health, numberOfUnits));
            for (Unit unit : draftList.getCavalryUnit()) {
                draftObservableList = FXCollections.observableList(draftList.getAllUnits());
                tableView.setItems(draftObservableList);
            }
        }
        cavalryNumber.clear();
        cavalryHealth.clear();
        cavalryName.clear();
    }

    @FXML
    private void onAddCommanderUnitButtonClick() {
        String name = commanderName.getText();
        int health = Integer.parseInt(commanderHealth.getText());
        int numberOfUnits = Integer.parseInt(commanderNumber.getText());

        if (draftList == null) {
            draftList = new Army(armyName.getText());
            draftList.addAll(unitFactory.createManyUnits("Commander", name, health, numberOfUnits));
            for (Unit unit : draftList.getCommanderUnit()) {
                draftObservableList = FXCollections.observableList(draftList.getAllUnits());
                tableView.setItems(draftObservableList);
            }
            commanderNumber.clear();
            commanderHealth.clear();
            commanderName.clear();

        } else {
            draftList.addAll(unitFactory.createManyUnits("Commander", name, health, numberOfUnits));
            for (Unit unit : draftList.getCommanderUnit()) {
                draftObservableList = FXCollections.observableList(draftList.getAllUnits());
                tableView.setItems(draftObservableList);
            }
        }
        commanderNumber.clear();
        commanderHealth.clear();
        commanderName.clear();
    }

    @FXML
    private void onCreateArmyButtonClick() throws FileNotFoundException {
        if (draftList == null) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Information");
            alert.setHeaderText("You cannot create an army without any unis.");
            alert.setContentText("Please add at least on unit.");
            alert.showAndWait();
        } else {
            fileHandler.saveArmy(draftList);
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Army Saved");
            alert.setHeaderText(null);
            alert.setContentText("The army has been saved with the file name: " + Facade.getInstance().getTempArmyName() + ".csv");
            alert.showAndWait();
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Facade.resetArmy();
        Facade.getInstance().createArmy(Facade.getInstance().getTempArmyName(), draftObservableList);
        unitFactory = Facade.getInstance().getUnitFactory();
        fileHandler = Facade.getInstance().getFileHandler();
        TableView<Unit> tableView = new TableView();
        tableView.setEditable(true);
        typeColumn.setCellValueFactory(new PropertyValueFactory<>("type"));
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        healthColumn.setCellValueFactory(new PropertyValueFactory<>("health"));
        attackColumn.setCellValueFactory(new PropertyValueFactory<>("attack"));
        defenceColumn.setCellValueFactory(new PropertyValueFactory<>("armor"));
        armyName.setText(Facade.getInstance().getArmy().getName());
        tableView.setItems(draftObservableList);
    }
}
