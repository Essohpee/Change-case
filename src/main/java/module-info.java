module com.essohpee.changecasefin {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires java.datatransfer;

    opens com.essohpee.changecasefin to javafx.fxml;
    exports com.essohpee.changecasefin;
}