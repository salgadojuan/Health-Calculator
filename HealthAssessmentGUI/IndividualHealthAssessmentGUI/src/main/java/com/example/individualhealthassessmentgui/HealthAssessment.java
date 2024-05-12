package com.example.individualhealthassessmentgui;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.File;


@XmlRootElement
class HealthAssessment {

    private double systolicBP;
    private double weight;
    private double heightInMeters;
    private double bloodGlucose;
    private double cholesterol;
    private double triglycerides;
    private double hdl;
    private double ldl;



    // Default constructor for JAXB
    public HealthAssessment() {}

    // HEALTH ASSESSMENT CONSTRUCTOR WITH INITIAL VALUES FOR ASSESSMENT:
    public HealthAssessment(double systolicBP, double weight, double heightInMeters, double bloodGlucose,
                            double cholesterol, double triglycerides, double hdl, double ldl) {
        this.systolicBP = systolicBP;
        this.weight = weight;
        this.heightInMeters = heightInMeters;
        this.bloodGlucose = bloodGlucose;
        this.cholesterol = cholesterol;
        this.triglycerides = triglycerides;
        this.hdl = hdl;
        this.ldl = ldl;
    }

    // Setters and Getters for Evaluation Methods
    public void setSystolicBP(double systolicBP) {
        this.systolicBP = systolicBP;
    }

    public double getSystolicBP() {
        return systolicBP;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getWeight() {
        return weight;
    }

    public void setHeightInMeters(double heightInMeters) {
        this.heightInMeters = heightInMeters;
    }

    public double getHeightInMeters() {
        return heightInMeters;
    }

    public void setBloodGlucose(double bloodGlucose) {
        this.bloodGlucose = bloodGlucose;
    }

    public double getBloodGlucose() {
        return bloodGlucose;
    }

    public void setCholesterol(double cholesterol) {
        this.cholesterol = cholesterol;
    }

    public double getCholesterol() {
        return cholesterol;
    }

    public void setTriglycerides(double triglycerides) {
        this.triglycerides = triglycerides;
    }

    public double getTriglycerides() {
        return triglycerides;
    }

    public void setHdl(double hdl) {
        this.hdl = hdl;
    }

    public double getHdl() {
        return hdl;
    }

    public void setLdl(double ldl) {
        this.ldl = ldl;
    }

    public double getLdl() {
        return ldl;
    }

    // METHOD THAT EVALUATES THE BLOOD PRESSURE THEN RETURNS BLOOD PRESSURE METRICS IN A STRING MESSAGE FOR THE USER:
    public String evaluateBP() {
        if (systolicBP >= 210) return "BP: Very severe! Please see a doctor Immediately.";
        if (systolicBP >= 180) return "BP: Severe. ";

        if (systolicBP >= 160) return "BP: Moderate. ";
        if (systolicBP >= 140) return "BP: Mild. ";

        if (systolicBP >= 90) return "BP: Normal. ";
        if (systolicBP >= 50 && systolicBP < 90) return "BP: Low.";

        return "BP: Extremely Low. Please see a doctor Immediately!";
    }

    // METHOD THAT EVALUATES & CALCULATES THE USERS BMI THEN RETURNS BMI METRICS IN A STRING MESSAGE FOR THE USER:
    public String evaluateBMI(double weight, double heightInMeters) {
        double bmi = weight / (heightInMeters * heightInMeters);
        if (bmi < 18.5) return "BMI: Underweight. Please see a Professional for assistance.";
        if (bmi <= 24.9) return "BMI: Normal.";
        if (bmi < 30) return "BMI: Overweight.";
        return "BMI: Obese. Please see a doctor for better weight management.";
    }


    // METHOD THAT EVALUATES THE BLOOD GLUCOSE THEN RETURNS BLOOD GLUCOSE METRICS IN A STRING MESSAGE FOR THE USER:
    public String evaluateBloodGlucose() {
        if (bloodGlucose >= 80 && bloodGlucose <= 120) return "Blood-Glucose is: Excellent. ";
        if (bloodGlucose > 120 && bloodGlucose < 150) return "Blood Glucose: Excellent. ";
        if (bloodGlucose >= 150 && bloodGlucose <= 180) return "Blood-Glucose is: Good. ";
        if (bloodGlucose > 180 && bloodGlucose < 210) return "Blood-Glucose is: Good. ";
        if (bloodGlucose >= 210 && bloodGlucose <= 240) return "Blood-Glucose is: Marginal. ";
        if (bloodGlucose > 240 && bloodGlucose < 270) return "Blood-Glucose is: Marginal. ";
        if (bloodGlucose >= 270 && bloodGlucose <= 310) return "Blood-Glucose is: Poor. Dangerous Please Manage Glucose levels.";
        if (bloodGlucose > 310 && bloodGlucose < 340) return "Blood-Glucose is: Poor. Dangerous Please Manage Glucose levels. ";
        return "Blood-Glucose is: Out of control! Please seek professional help Immediately. Insulin or Correction may be needed.";
    }

    // METHOD THAT EVALUATES CHOLESTEROL THEN RETURNS THE METRICS IN A STRING MESSAGE FOR THE USER:
    public String evaluateCholesterol() {
        return cholesterol < 200 ? "Total Cholesterol: Excellent." : "Total Cholesterol: High. Please see a doctor.";
    }

    // METHOD THAT EVALUATES TRIGLYCERIDE LEVELS THEN RETURNS THE METRICS IN A STRING MESSAGE FOR THE USER:
    public String evaluateTriglycerides() {
        return triglycerides < 250 ? "Triglycerides: Optimal." : "Triglycerides: High. Please see a doctor.";
    }

    // METHOD THAT EVALUATES HDL-LEVELS THEN RETURNS THE METRICS IN A STRING MESSAGE FOR THE USER:
    public String evaluateHDL() {
        return hdl > 40 ? "HDL (good for health): Optimal." : "HDL (good for health): Low. Please see a doctor.";
    }

    // METHOD THAT EVALUATES LDL-LEVELS THEN RETURNS THE METRICS IN A STRING MESSAGE FOR THE USER:
    public String evaluateLDL() {
        return ldl < 100 ? "LDL (bad for health): Optimal." : "LDL (bad for health): High. Please see a doctor.";
    }

    // JAXB XML Serialization
    public void saveToXML(File file) throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(HealthAssessment.class);
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        marshaller.marshal(this, file);
    }

    // JAXB XML Deserialization
    public static HealthAssessment loadFromXML(File file) throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(HealthAssessment.class);
        Unmarshaller unmarshaller = context.createUnmarshaller();
        return (HealthAssessment) unmarshaller.unmarshal(file);
    }
}
