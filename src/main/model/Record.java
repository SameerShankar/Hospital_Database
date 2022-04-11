package model;

import exceptions.OutOfBoundsException;
import org.json.JSONArray;
import org.json.JSONObject;
import persistence.Saveable;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;


// Represents a record of patients (a list of patients)
public class Record implements Saveable {

    private List<Patient> patients;             // list of patients

    /*
     * EFFECTS: creates an empty list of patients
     */
    public Record() {
        patients = new LinkedList<>();
    }

    // MODIFIES: this
    // EFFECTS: Patient p is added to the set if
    // they are not already in the Record
    public void insertPatient(Patient p) {
        if (!containsPatient(p)) {
            patients.add(p);
        }
    }

    // MODIFIES: this
    // EFFECTS: removes a patient from the Record
    public void removePatient(String s) {
        for (int i = 0; i < patients.size(); i++) {
            if (s.equals(patients.get(i).getName())) {
                patients.remove(patients.get(i));
            }
        }
    }

    // EFFECTS: Returns true if Patient p is in the Record
    // and false otherwise
    public boolean containsPatient(Patient p) {
        return patients.contains(p);
    }

    // EFFECTS: Returns the number of patient(s) in Record (size of Record)
    public int size() {
        return patients.size();
    }

    // EFFECTS: Returns the sum of cost of visits for each patient
    public double cost() throws OutOfBoundsException {
        double sumVisit = 0;
        for (int i = 0; i < patients.size(); i++) {
            sumVisit = sumVisit + patients.get(i).getCost();
        }
        if (sumVisit < 0) {
            throw new OutOfBoundsException();
        }
        return sumVisit;
    }

    // EFFECTS: Returns the average rating of the hospital given by all patients in Record
    public double averageRating() {
        double sumRating = 0;
        for (int i = 0; i < patients.size(); i++) {
            sumRating = sumRating + patients.get(i).getRating();
        }

        double averageRating;
        averageRating = (sumRating / patients.size());
        return averageRating;
    }

    //EFFECTS: Returns true if record contains a given name name, false otherwise
    public boolean containsName(String name) {
        for (int i = 0; i < patients.size(); i++) {
            if (name.equals(patients.get(i).getName())) {
                return true;
            }
        }
        return false;
    }

    // EFFECTS: returns an unmodifiable list of patients in this hospital
    public List<Patient> getPatients() {
        return Collections.unmodifiableList(patients);
    }

    // EFFECTS: returns number of patients in this hospital
    public int numPatients() {
        return patients.size();
    }

    @Override
    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        json.put("patients", patientsToJson());
        return json;
    }

    // EFFECTS: returns patients in this hospital as a JSON array
    private JSONArray patientsToJson() {
        JSONArray jsonArray = new JSONArray();

        for (Patient p : patients) {
            jsonArray.put(p.toJson());
        }

        return jsonArray;
    }
}