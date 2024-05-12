
import java.util.InputMismatchException;
import java.util.Scanner;

// HEALTH ASSESSMENT CLASS & VARIABLES MARKED AS PRIVATE FOR ACCESS/MODIFICATION WITHIN THE CLASS:
class HealthAssessment {

    private double systolicBP;
    private double weight;
    private double heightInMeters;
    private double bloodGlucose;
    private double cholesterol;
    private double triglycerides;
    private double hdl;
    private double ldl;

    // HEALTH ASSESSMENT CONSTRUCTOR WITH INITIAL VALUES FOR ASSESSMENT:
    public HealthAssessment(double systolicBP, double weight, double heightInMeters, double bloodGlucose, double cholesterol, double triglycerides, double hdl, double ldl) {

        this.systolicBP = systolicBP;
        this.weight = weight;
        this.heightInMeters = heightInMeters;

        this.bloodGlucose = bloodGlucose;
        this.cholesterol = cholesterol;

        this.triglycerides = triglycerides;
        this.hdl = hdl;
        this.ldl = ldl;
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
    public String evaluateBMI() {

        double bmi = weight / (heightInMeters * heightInMeters);

        if (bmi < 18.5) return "BMI: Underweight. Please see a Professional for assistance.";
        if (bmi <= 24.9) return "BMI: Normal.";
        if (bmi < 30) return "BMI: Overweight. ";

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
}

public class IndividualHealthAssessmentProgram {

    private static Scanner UserInput = new Scanner(System.in);

    // PROMPTS THE USER FOR THEIR NAME:
    private static String promptUserForName() {

        System.out.println("Enter your name: ");
        return UserInput.nextLine();
    }

    private static double promptUserForDouble(String message) {
        double input = 0;
        boolean valid = false;

        while (!valid) {
            try {
                System.out.println(message);
                input = UserInput.nextDouble();
                valid = true;
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter valid number or numbers.");
                UserInput.next();
            }
        }

        return input;
    }

    public static void main(String[] args) {

        //PROMPTS USER TO ENTER DATA:
        String name = promptUserForName();
        double bp = promptUserForDouble("Enter Blood-Pressure (systolic): ");
        double weight = promptUserForDouble("Enter-Weight (in kg): ");
        double heightInMeters = promptUserForDouble("Enter-Height (in meters):");

        double glucose = promptUserForDouble("Enter-Blood-Glucose: ");
        double cholesterol = promptUserForDouble("Enter-Total-Cholesterol: ");
        double triglycerides = promptUserForDouble("Enter-Triglycerides: ");

        double hdl = promptUserForDouble("Enter-HDL: ");
        double ldl = promptUserForDouble("Enter-LDL: ");

        HealthAssessment HealthAssessment = new HealthAssessment(bp, weight, heightInMeters, glucose, cholesterol, triglycerides, hdl, ldl);

        System.out.println("\nHealth Assessment For Patient " + name + ":");
        System.out.println(HealthAssessment.evaluateBP());

        System.out.println(HealthAssessment.evaluateBMI());
        System.out.println(HealthAssessment.evaluateBloodGlucose());

        System.out.println(HealthAssessment.evaluateCholesterol());
        System.out.println(HealthAssessment.evaluateTriglycerides());

        System.out.println(HealthAssessment.evaluateHDL());
        System.out.println(HealthAssessment.evaluateLDL());
    }
}
