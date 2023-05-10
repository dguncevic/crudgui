module com.mynotepad.dz {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;

    opens com.mynotepad.dz to javafx.fxml;
    exports com.mynotepad.dz;
}
