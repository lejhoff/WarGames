package no.ntnu.idatg2001.krigslek.ui.controllers;

import javafx.application.Platform;
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
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import no.ntnu.idatg2001.krigslek.model.Army;
import no.ntnu.idatg2001.krigslek.model.ArmyFileHandler;
import no.ntnu.idatg2001.krigslek.model.Facade;
import no.ntnu.idatg2001.krigslek.model.Units.Unit;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class MainWindowAppController implements Initializable {

    @FXML
    private AnchorPane simulationPage;
    @FXML
    private TextField armyName;
    @FXML
    private TextField armyPath;
    @FXML
    private TextField totalUnits;
    @FXML
    private TextField totalInfantryUnits;
    @FXML
    private TextField totalRangedUnits;
    @FXML
    private TextField totalCavalryUnits;
    @FXML
    private TextField totalCommanderUnits;
    @FXML
    private Label winnerField;
    @FXML
    private TableView<Unit> armyOneTableView;
    @FXML
    private TableView<Unit> armyTwoTableView;
    @FXML
    private TableColumn<Unit, String> armyOneTypeColumn;
    @FXML
    private TableColumn<Unit, String> armyTwoTypeColumn;
    @FXML
    private TableColumn<Unit, String> armyOneNameColumn;
    @FXML
    private TableColumn<Unit, String> armyTwoNameColumn;
    @FXML
    private TableColumn<Unit, Integer> armyOneHealthColumn;
    @FXML
    private TableColumn<Unit, String> armyTwoHealthColumn;
    @FXML
    private TableColumn<Unit, Integer> armyOneAttackColumn;
    @FXML
    private TableColumn<Unit, String> armyTwoAttackColumn;
    @FXML
    private TableColumn<Unit, Integer> armyOneDefenceColumn;
    @FXML
    private TableColumn<Unit, String> armyTwoDefenceColumn;
    private ObservableList<Unit> armyOneObservableList;
    private ObservableList<Unit> armyTwoObservableList;
    private ArmyFileHandler fileHandler;
    private File selected1;
    private Army armyOne;
    private File selected2;
    private Army armyTwo;
    private int selectedTerrain;

    @FXML
    private void onBackButtonPress(ActionEvent event) throws IOException {
        Parent simulationPageParent = (Parent) FXMLLoader.load((URL)
                Objects.requireNonNull(this.getClass().getClassLoader().getResource("fxml-files/front_page.fxml")));
        Scene frontPageScene = new Scene(simulationPageParent);
        Stage appStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        appStage.setScene(frontPageScene);
        appStage.show();
    }

    @FXML
    private void onLoadArmyOneButtonPress(ActionEvent event) throws IOException {
        File saveDir = new File(System.getProperty("user.home"), ".warGames/savedArmies");
        if (!saveDir.exists()) {
            saveDir.mkdirs();
        }
        Stage stage = (Stage) simulationPage.getScene().getWindow();
        FileChooser file_chooser = new FileChooser();
        file_chooser.setTitle("Open File");
        file_chooser.setInitialDirectory(saveDir);
        selected1 = file_chooser.showOpenDialog(stage);

        if (Facade.getInstance().armyOneExists(fileHandler.loadArmy(selected1))) {
            armyOne = Facade.getInstance().getArmyOne();
            armyName.setText(Facade.getInstance().getArmyOne().getName());
            armyPath.setText(saveDir.getPath() + "/" + armyOne.getName() + ".csv");
            totalUnits.setText(Integer.toString(armyOne.getAllUnits().size()));
            totalInfantryUnits.setText(Integer.toString(armyOne.getInfantryUnit().size()));
            totalRangedUnits.setText(Integer.toString(armyOne.getRangedUnit().size()));
            totalCavalryUnits.setText(Integer.toString(armyOne.getCavalryUnit().size()));
            totalCommanderUnits.setText(Integer.toString(armyOne.getCommanderUnit().size()));

            for (Unit unit : Facade.getInstance().getArmyOne().getAllUnits()) {
                armyOneObservableList = FXCollections.observableList(Facade.getInstance().getArmyOne().getAllUnits());
                armyOneTableView.setItems(armyOneObservableList);
            }
        }
    }

    @FXML
    private void onLoadArmyTwoButtonPress(ActionEvent event) throws IOException{
        File saveDir = new File(System.getProperty("user.home"), ".warGames/savedArmies");
        if (!saveDir.exists()) {
            saveDir.mkdirs();
        }
        Stage stage = (Stage) simulationPage.getScene().getWindow();
        FileChooser file_chooser = new FileChooser();
        file_chooser.setTitle("Open File");
        file_chooser.setInitialDirectory(saveDir);
        selected2 = file_chooser.showOpenDialog(stage);

        if (Facade.getInstance().armyTwoExists(fileHandler.loadArmy(selected2))) {
            armyTwo = Facade.getInstance().getArmyTwo();
            armyName.setText(armyTwo.getName());
            armyPath.setText(saveDir.getPath() + "/" + armyTwo.getName() + ".csv");
            totalUnits.setText(Integer.toString(armyTwo.getAllUnits().size()));
            totalInfantryUnits.setText(Integer.toString(armyTwo.getInfantryUnit().size()));
            totalRangedUnits.setText(Integer.toString(armyTwo.getRangedUnit().size()));
            totalCavalryUnits.setText(Integer.toString(armyTwo.getCavalryUnit().size()));
            totalCommanderUnits.setText(Integer.toString(armyTwo.getCommanderUnit().size()));

            for (Unit unit : Facade.getInstance().getArmyTwo().getAllUnits()) {
                armyTwoObservableList = FXCollections.observableList(Facade.getInstance().getArmyTwo().getAllUnits());
                armyTwoTableView.setItems(armyTwoObservableList);
            }
        }
    }

    @FXML
    private void onCloseButtonPress() {
        Platform.exit();
    }

    @FXML
    private void onArmyOneButtonPress() {
        File saveDir = new File(System.getProperty("user.home"), ".warGames/savedArmies");
        if (armyOne != null) {
            armyName.setText(Facade.getInstance().getArmyOne().getName());
            armyPath.setText(saveDir.getPath() + "/" + armyOne.getName() + ".csv");
            totalUnits.setText(Integer.toString(armyOne.getAllUnits().size()));
            totalInfantryUnits.setText(Integer.toString(armyOne.getInfantryUnit().size()));
            totalRangedUnits.setText(Integer.toString(armyOne.getRangedUnit().size()));
            totalCavalryUnits.setText(Integer.toString(armyOne.getCavalryUnit().size()));
            totalCommanderUnits.setText(Integer.toString(armyOne.getCommanderUnit().size()));
        }
    }

    @FXML
    private void onArmyTwoButtonPress() {
        File saveDir = new File(System.getProperty("user.home"), ".warGames/savedArmies");
        if (armyTwo != null) {
            armyName.setText(armyTwo.getName());
            armyPath.setText(saveDir.getPath() + "/" + armyTwo.getName() + ".csv");
            totalUnits.setText(Integer.toString(armyTwo.getAllUnits().size()));
            totalInfantryUnits.setText(Integer.toString(armyTwo.getInfantryUnit().size()));
            totalRangedUnits.setText(Integer.toString(armyTwo.getRangedUnit().size()));
            totalCavalryUnits.setText(Integer.toString(armyTwo.getCavalryUnit().size()));
            totalCommanderUnits.setText(Integer.toString(armyTwo.getCommanderUnit().size()));
        }
    }

    @FXML
    private void onPlainsButtonClick() {
        this.selectedTerrain = 1;
    }

    @FXML
    private void onForrestButtonClick() {
        this.selectedTerrain = 2;
    }

    @FXML
    private void onHillsButtonClick() {
        this.selectedTerrain = 3;
    }
    @FXML
    private void onStartSimulationButtonPress() {
        if ((Facade.getInstance().getArmyOne().getAllUnits().size() == 0) ||
                (Facade.getInstance().getArmyTwo().getAllUnits().size() == 0)) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Information");
            alert.setHeaderText("You must load two teams before you can run the simulation.");
            alert.setContentText("Please make sure you have loaded both army one and army two "+ "\n"
            + "and that both armies contains at least one unit.");
            alert.showAndWait();
        } else {
            String winner = Facade.getInstance().runSimulation(selectedTerrain);
            for (Unit unit : armyOne.getAllUnits()) {
                armyOneObservableList = FXCollections.observableList(armyOne.getAllUnits());
                armyOneTableView.setItems(armyOneObservableList);
            }
            for (Unit unit : armyTwo.getAllUnits()) {
                armyTwoObservableList = FXCollections.observableList(armyTwo.getAllUnits());
                armyTwoTableView.setItems(armyTwoObservableList);
            }
            winnerField.setText(winner + " wins!");
            onArmyOneButtonPress();
            armyOneTableView.refresh();
            armyTwoTableView.refresh();
        }
    }

    @FXML
    private void onResetSimulationButtonPress() {
        winnerField.setText("");
        armyOneTableView.getItems().clear();
        armyTwoTableView.getItems().clear();
        if (Facade.getInstance().armyOneExists(fileHandler.loadArmy(selected1))) {
            armyOne = Facade.getInstance().getArmyOne();
            for (Unit unit : armyOne.getAllUnits()) {
                armyOneObservableList = FXCollections.observableList(armyOne.getAllUnits());
                armyOneTableView.setItems(armyOneObservableList);
            }
        }

        if (Facade.getInstance().armyTwoExists(fileHandler.loadArmy(selected2))) {
            armyTwo = Facade.getInstance().getArmyTwo();
            for (Unit unit : armyTwo.getAllUnits()) {
                armyTwoObservableList = FXCollections.observableList(armyTwo.getAllUnits());
                armyTwoTableView.setItems(armyTwoObservableList);
                //armyTwoTableView.refresh();
            }
        }
        onArmyOneButtonPress();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        fileHandler = Facade.getInstance().getFileHandler();
        //armyOne = Facade.getInstance().getArmyOne();
        //armyTwo = Facade.getInstance().getArmyTwo();
        TableView<Unit> armyOneTableView = new TableView<>();
        armyOneTableView.setEditable(true);
        armyOneTypeColumn.setCellValueFactory(new PropertyValueFactory<>("type"));
        armyOneNameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        armyOneHealthColumn.setCellValueFactory(new PropertyValueFactory<>("health"));
        armyOneAttackColumn.setCellValueFactory(new PropertyValueFactory<>("attack"));
        armyOneDefenceColumn.setCellValueFactory(new PropertyValueFactory<>("armor"));
        armyOneTableView.setItems(armyOneObservableList);

        TableView<Unit> armyTwoTableView = new TableView<>();
        armyTwoTableView.setEditable(true);
        armyTwoTypeColumn.setCellValueFactory(new PropertyValueFactory<>("type"));
        armyTwoNameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        armyTwoHealthColumn.setCellValueFactory(new PropertyValueFactory<>("health"));
        armyTwoAttackColumn.setCellValueFactory(new PropertyValueFactory<>("attack"));
        armyTwoDefenceColumn.setCellValueFactory(new PropertyValueFactory<>("armor"));
        armyTwoTableView.setItems(armyTwoObservableList);
    }
}
