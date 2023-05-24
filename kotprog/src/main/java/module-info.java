module com.kotprog.kotprog {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.kotprog.kotprog to javafx.fxml;
    exports com.kotprog.kotprog;
    exports com.kotprog.kotprog.osztalyaim;
    opens com.kotprog.kotprog.osztalyaim to javafx.fxml;
    exports com.kotprog.kotprog.szintek;
    opens com.kotprog.kotprog.szintek to javafx.fxml;
    exports com.kotprog.kotprog.vege;
    opens com.kotprog.kotprog.vege to javafx.fxml;
    exports com.kotprog.kotprog.controlok;
    opens com.kotprog.kotprog.controlok to javafx.fxml;
}