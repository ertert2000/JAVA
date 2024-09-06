module lib.project2 {
    requires javafx.controls;
    requires javafx.fxml;

    opens lib.project2 to javafx.fxml;
    exports lib.project2;
}
