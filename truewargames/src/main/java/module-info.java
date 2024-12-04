module no.ntnu.idatg2001.krigslek {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.logging;

    // open model to everyone in to be able to run tests from Maven
    opens no.ntnu.idatg2001.krigslek.model to javafx.base;
    opens no.ntnu.idatg2001.krigslek to javafx.fxml;
   // opens no.ntnu.idatg2001.krigslek.model to javafx.fxml;
    opens no.ntnu.idatg2001.krigslek.ui.views to javafx.fxml;
    opens no.ntnu.idatg2001.krigslek.ui.controllers to javafx.fxml;

    exports no.ntnu.idatg2001.krigslek.ui.controllers;
    exports no.ntnu.idatg2001.krigslek.ui.views;
    opens no.ntnu.idatg2001.krigslek.model.Units to javafx.base;
}