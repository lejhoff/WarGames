package no.ntnu.idatg2001.krigslek.ui.views;

import javafx.geometry.Insets;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import no.ntnu.idatg2001.krigslek.model.Army;
import no.ntnu.idatg2001.krigslek.model.Facade;

public class ArmyCreationDialog extends Dialog<Army> {

    public enum Mode {
        ENTER, CANCLE
    }

    private final Mode mode;

    private Army existingArmy = null;

    public ArmyCreationDialog() {
        super();
        this.mode = Mode.ENTER;
        createContent();
    }

    private void createContent() {

        // Components.

        TextField name = new TextField();
        name.setPromptText("Army name:");


        // Layout.

        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(20, 150, 10, 10));
        grid.add(new Label("Army name:"), 0, 0);
        grid.add(name, 1, 0);
        getDialogPane().setContent(grid);

        if (this.mode == Mode.ENTER) {
            getDialogPane().getButtonTypes().addAll(ButtonType.OK);
        } else {
            getDialogPane().getButtonTypes().addAll(ButtonType.OK, ButtonType.CANCEL);
        }

        // Set the title.
        setTitle("Create new army:");


        setResultConverter(
                (ButtonType button) -> {
                    Army result = null;
                    if (mode == Mode.ENTER) {
                        Facade.getInstance().setTempArmyName(name.getText());
                    } else if (mode == Mode.CANCLE) {
                        result = existingArmy;
                    }
                    return result;
                }
        );
    }
}
