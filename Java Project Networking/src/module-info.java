module myjfx {
    requires javafx.fxml;
    requires javafx.controls;
    requires javafx.graphics;
    requires javafx.base;
    opens sample to javafx.graphics, javafx.fxml, javafx.base;
}