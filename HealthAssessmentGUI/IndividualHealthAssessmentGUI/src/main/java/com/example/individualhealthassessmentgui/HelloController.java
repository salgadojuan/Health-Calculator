package com.example.individualhealthassessmentgui;

import javafx.fxml.FXML;
import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.scene.control.Alert;

import javax.xml.bind.JAXBException;
import java.io.File;
import javafx.scene.control.Alert;


public class HelloController {

    @FXML
    private TextField BMI_ResultsDisplayTextBox;

    @FXML
    private Label BMI_ResultsLabel;

    @FXML
    private TextField BPResulltsDisplayTextBox;

    @FXML
    private Label CalculateBMI_Label;

    @FXML
    private Label HDL_Label;
    @FXML
    private TextField enterWeightTextBox;

    @FXML
    private TextField enterHeightTextBox;

    @FXML
    private TextField HDL_ResultsDisplayTextBox;

    @FXML
    private Label LDL_Label;

    @FXML
    private TextField LDL_ResultsDisplayTextBox;

    @FXML
    private TextField bloodGlucoseResultsDisplaysTextBox;

    @FXML
    private Label bpLabel;

    @FXML
    private Button calculateBMIButton;

    @FXML
    private Label cholesterolLabel;

    @FXML
    private TextField cholesterolResultsDisplayTextBox;

    @FXML
    private Button enterBPButton;

    @FXML
    private TextField enterBPTextBox;

    @FXML
    private TextField enterBloodGlucoseTextBox;

    @FXML
    private Button enterCholesterolButton;

    @FXML
    private TextField enterCholesterolTextBox;

    @FXML
    private Button enterGlucoseButton;

    @FXML
    private Button enterHDLButton;

    @FXML
    private TextField enterHDLTextBox;

    @FXML
    private Button enterLDLButton;

    @FXML
    private TextField enterLDLTextBox;

    @FXML
    private Label enterNameLabel;

    @FXML
    private Button enterTriglyceridesButton;

    @FXML
    private TextField enterTriglyceridesTextBox;

    @FXML
    private Button exitButton;

    @FXML
    private Label glucoseLabel;

    @FXML
    private Button loadReportToFileButton;

    @FXML
    private Label mainHealthAssessmentLabel;

    @FXML
    private TextField promptUserForNameTextBox;

    @FXML
    private Button resetButton;

    @FXML
    private Label resultsBPLabel;

    @FXML
    private Label resultsCholesterolLabel;

    @FXML
    private Label resultsGlucoseLabel;

    @FXML
    private Label resultsHDL_Label;

    @FXML
    private Label resultsLDL_Label;

    @FXML
    private Label resultsTriglyceridesLabel;

    @FXML
    private Button savePromptUserForNameButton;

    @FXML
    private Button saveReportToFileButton;

    @FXML
    private Label triglyceridesLabel;

    @FXML
    private TextField triglyceridesResultsDisplayTextBox;

    @FXML
    private TextField enterFileNameTextBox; //new


    @FXML
    private void initialize() {
        // Initialization logic here, if needed.
    }

    @FXML
    private void handleSaveNameAction(ActionEvent event) {
        if (promptUserForNameTextBox.getText().isEmpty()) {
            showDialog("Please enter a name.");
            return;
        }
        String userName = promptUserForNameTextBox.getText();

    }

    @FXML
    private void handleCalculateBMIAction(ActionEvent event) {
        double weight = 0;
        double height = 0;
        try {
            weight = Double.parseDouble(enterWeightTextBox.getText());
            height = Double.parseDouble(enterHeightTextBox.getText());
        } catch (NumberFormatException e) {
            showDialog("Invalid input. Please enter valid numbers for weight and height.");
            return;
        }

        HealthAssessment assessment = new HealthAssessment();
        String bmiResult = assessment.evaluateBMI(weight, height);
        BMI_ResultsDisplayTextBox.setText(bmiResult);
    }

    @FXML
    private void handleEnterBPAction(ActionEvent event) {
        HealthAssessment healthAssessment = new HealthAssessment();

        if (enterBPTextBox.getText().isEmpty()) {
            showDialog("Please enter a valid BP value.");
            return;
        }

        try {
            double bp = Double.parseDouble(enterBPTextBox.getText());
            healthAssessment.setSystolicBP(bp);
            String bpEvaluation = healthAssessment.evaluateBP();
            BPResulltsDisplayTextBox.setText(bpEvaluation);

            if (bp >= 210 || (bp >= 50 && bp < 90)) {
                BPResulltsDisplayTextBox.appendText("\nYou should see a doctor immediately.");
            }

        } catch (NumberFormatException e) {
            showDialog("Invalid input. Please enter a valid BP value.");
        }
    }

    @FXML
    private void handleEnterCholesterolAction(ActionEvent event) {
        HealthAssessment healthAssessment = new HealthAssessment();

        try {
            double cholesterol = Double.parseDouble(enterCholesterolTextBox.getText());
            healthAssessment.setCholesterol(cholesterol);
            String cholesterolEvaluation = healthAssessment.evaluateCholesterol();
            cholesterolResultsDisplayTextBox.setText(cholesterolEvaluation);

            if (cholesterol >= 200) {
                cholesterolResultsDisplayTextBox.appendText("\nPlease consider consulting a health professional.");
            }

        } catch (NumberFormatException e) {
            showDialog("Invalid input. Please enter a valid cholesterol value.");
        }
    }

    @FXML
    private void handleEnterGlucoseAction(ActionEvent event) {
        double glucose = 0;
        try {
            glucose = Double.parseDouble(enterBloodGlucoseTextBox.getText());
        } catch (NumberFormatException e) {
            showDialog("Invalid input. Please enter a valid glucose value.");
            return;
        }

        HealthAssessment healthAssessment = new HealthAssessment();
        healthAssessment.setBloodGlucose(glucose); // Assuming there's a setter for bloodGlucose in HealthAssessment POJO
        String glucoseEvaluation = healthAssessment.evaluateBloodGlucose();
        bloodGlucoseResultsDisplaysTextBox.setText(glucoseEvaluation); // Display the glucose evaluation message
    }

    @FXML
    private void handleEnterHDLAction(ActionEvent event) {
        double hdl = 0;
        try {
            hdl = Double.parseDouble(enterHDLTextBox.getText());
        } catch (NumberFormatException e) {
            showDialog("Invalid input. Please enter a valid HDL value.");
            return;
        }

        HealthAssessment healthAssessment = new HealthAssessment();
        healthAssessment.setHdl(hdl);
        String hdlEvaluation = healthAssessment.evaluateHDL();
        HDL_ResultsDisplayTextBox.setText(hdlEvaluation);
    }


    @FXML
    private void handleEnterLDLAction(ActionEvent event) {
        double ldl = 0;
        try {
            ldl = Double.parseDouble(enterLDLTextBox.getText());
        } catch (NumberFormatException e) {
            showDialog("Invalid input. Please enter a valid LDL value.");
            return;
        }

        HealthAssessment healthAssessment = new HealthAssessment();
        healthAssessment.setLdl(ldl);
        String ldlEvaluation = healthAssessment.evaluateLDL();
        LDL_ResultsDisplayTextBox.setText(ldlEvaluation);
    }

    @FXML
    private void handleEnterTriglyceridesAction(ActionEvent event) {
        double triglycerides = 0;
        try {
            triglycerides = Double.parseDouble(enterTriglyceridesTextBox.getText());
        } catch (NumberFormatException e) {
            showDialog("Invalid input. Please enter a valid triglycerides value.");
            return;
        }

        HealthAssessment healthAssessment = new HealthAssessment();
        healthAssessment.setTriglycerides(triglycerides);
        String triglyceridesEvaluation = healthAssessment.evaluateTriglycerides();
        triglyceridesResultsDisplayTextBox.setText(triglyceridesEvaluation);
    }

    @FXML
    private void handleExitAction(ActionEvent event) {
        // Close the JavaFX application
        System.exit(0);
    }

    @FXML
    private void handleLoadReportAction(ActionEvent event) {
        // The text box should contain the file name
        String fileName = enterFileNameTextBox.getText();
        if (fileName.isEmpty()) {
            showDialog("Please enter a file name.");
            return;
        }

        // Load from XML
        File file = new File(fileName + "C:\\Users\\Veteran\\IdeaProjects\\IndividualHealthAssessmentGUI\\src\\main\\java\\com\\example\\individualhealthassessmentgui\\txt.xml");
        try {
            HealthAssessment loadedAssessment = HealthAssessment.loadFromXML(file);

            // Update UI fields with loaded data
            BPResulltsDisplayTextBox.setText(String.valueOf(loadedAssessment.getSystolicBP()));
            enterWeightTextBox.setText(String.valueOf(loadedAssessment.getWeight()));
            enterHeightTextBox.setText(String.valueOf(loadedAssessment.getHeightInMeters()));
            enterBloodGlucoseTextBox.setText(String.valueOf(loadedAssessment.getBloodGlucose()));
            enterCholesterolTextBox.setText(String.valueOf(loadedAssessment.getCholesterol()));
            enterHDLTextBox.setText(String.valueOf(loadedAssessment.getHdl()));
            enterLDLTextBox.setText(String.valueOf(loadedAssessment.getLdl()));
            enterTriglyceridesTextBox.setText(String.valueOf(loadedAssessment.getTriglycerides()));

            // If you have evaluation results stored in XML, you can also load them here.

        } catch (JAXBException e) {
            showDialog("An error occurred while loading the report.");
        }
    }

    @FXML
    private void handleResetAction(ActionEvent event) {
        //CLEARS ALL TEXT-BOXES AND RESULTS IN GUI THAT USERS ENTER:
        enterHDLTextBox.clear();
        enterLDLTextBox.clear();
        enterTriglyceridesTextBox.clear();
        enterBloodGlucoseTextBox.clear();
        enterWeightTextBox.clear();
        enterHeightTextBox.clear();
        enterBPTextBox.clear();
        enterCholesterolTextBox.clear();
        promptUserForNameTextBox.clear();
        enterFileNameTextBox.clear();

        HDL_ResultsDisplayTextBox.clear();
        LDL_ResultsDisplayTextBox.clear();
        triglyceridesResultsDisplayTextBox.clear();
        bloodGlucoseResultsDisplaysTextBox.clear();
        BMI_ResultsDisplayTextBox.clear();
        BPResulltsDisplayTextBox.clear();
        cholesterolResultsDisplayTextBox.clear();

    }

    @FXML
    private void handleSaveReportAction(ActionEvent event) {
        try {
            HealthAssessment healthAssessment = new HealthAssessment();

            // Populate the HealthAssessment object with the data from the UI
            healthAssessment.setWeight(Double.parseDouble(enterWeightTextBox.getText()));
            healthAssessment.setHeightInMeters(Double.parseDouble(enterHeightTextBox.getText()));
            healthAssessment.setSystolicBP(Double.parseDouble(enterBPTextBox.getText()));
            healthAssessment.setBloodGlucose(Double.parseDouble(enterBloodGlucoseTextBox.getText()));
            healthAssessment.setCholesterol(Double.parseDouble(enterCholesterolTextBox.getText()));
            healthAssessment.setHdl(Double.parseDouble(enterHDLTextBox.getText()));
            healthAssessment.setLdl(Double.parseDouble(enterLDLTextBox.getText()));
            healthAssessment.setTriglycerides(Double.parseDouble(enterTriglyceridesTextBox.getText()));

            // Save to XML
            File file = new File("C:\\Users\\Veteran\\IdeaProjects\\IndividualHealthAssessmentGUI\\src\\main\\java\\com\\example\\individualhealthassessmentgui\\txt.xml");
            healthAssessment.saveToXML(file);

            showDialog("Health assessment report has been saved.");

        } catch (NumberFormatException e) {
            showDialog("Invalid input. Make sure to fill all fields with valid numbers.");
        } catch (JAXBException e) {
            showDialog("An error occurred while saving the health assessment report: " + e.getMessage());
        }
    }


    private void showDialog(String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
