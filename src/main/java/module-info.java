module org.example.studentchart {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.base;


    opens org.example.studentchart to javafx.fxml;
    exports org.example.studentchart;
}