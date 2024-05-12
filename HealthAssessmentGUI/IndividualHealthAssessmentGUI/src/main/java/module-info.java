module com.example.individualhealthassessmentgui {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.xml.bind;


    opens com.example.individualhealthassessmentgui to javafx.fxml;
    exports com.example.individualhealthassessmentgui;
}