package model;

import org.json.JSONObject;
import persistence.Saveable;


// Represents a patient having a name, personal health number, diagnosis,
// cost of visit to the hospital (in dollars), and a rating (out of 10)
public class Patient implements Saveable {

    private String name;                        // patient's name
    private int personalHealthNumber;           // unique patient id
    private String diagnosis;                   // patient's diagnosis
    private double cost;                        // cost of visits to the hospital for a patient
    private double rating;                      // patient's hospital rating (a patient MUST give a hospital rating)

    /*
     * REQUIRES: name and diagnosis both have non-zero lengths
     * EFFECTS: name of patient is set to name; personal health number is a
     * positive integer, different from any other patient's personal health
     * number; diagnosis is the patient's diagnosis; Cost must be >= 0, cost
     * of visit is set to cost, rating is a number between 0 (lowest) and 10
     * (highest) that a patient has given to the hospital
     */
    public Patient(String name, int personalHealthNumber,
                   String diagnosis, double cost, double rating) {
        this.name = name;
        this.personalHealthNumber = personalHealthNumber;
        this.diagnosis = diagnosis;
        this.cost = cost;
        this.rating = rating;
    }

    // EFFECTS: returns name of patient
    public String getName() {
        return name;
    }

    // EFFECTS: returns personal health number of patient
    public int getPersonalHealthNumber() {
        return personalHealthNumber;
    }

    // EFFECTS: returns the diagnosis of patient
    public String getDiagnosis() {
        return diagnosis;
    }

    // EFFECTS: returns patient's cost of visit to the hospital
    public double getCost() {
        return cost;
    }

    // EFFECTS: returns patient's rating of the hospital
    public double getRating() {
        return rating;
    }

    //this method was made based on the JsonSerializationDemo project provided on edX
    @Override
    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        json.put("name", name);
        json.put("personal health number", personalHealthNumber);
        json.put("diagnosis", diagnosis);
        json.put("cost", cost);
        json.put("rating", rating);
        return json;
    }
}