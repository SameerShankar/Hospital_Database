package ui;


import java.util.Scanner;

import exceptions.OutOfBoundsException;
import model.Record;
import model.Patient;

import persistence.JsonReader;
import persistence.JsonWriter;


import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.fail;

// HospitalApp Record application
public class HospitalApp {

    private static final String JSON_STORE = "./data/hospital.json";
    private Scanner input;
    private Record record;
    private JsonWriter jsonWriter;
    private JsonReader jsonReader;


    // This method was created based on the TellerApp project
    public HospitalApp() throws FileNotFoundException {
        input = new Scanner(System.in);
        record = new Record();
        jsonWriter = new JsonWriter(JSON_STORE);
        jsonReader = new JsonReader(JSON_STORE);
        runHospital();
    }

    // This method was created based on the TellerApp project and the JsonSerializationDemo project
    // MODIFIES: this
    // EFFECTS: processes user input
    private void runHospital() {
        boolean keepGoing = true;
        String command = null;

        init();

        while (keepGoing) {
            displayMenu();
            Scanner input = new Scanner(System.in);
            command = input.next();
            command = command.toLowerCase();

            if (command.equals("q")) {
                keepGoing = false;
            } else {
                processCommand(command);
            }
        }

        System.out.println("\nUser has ended the program");
    }

    // This method was created based on the TellerApp project
    // MODIFIES: this
    // EFFECTS: initializes Patients
    private void init() {
        record = new Record();
    }

    // This method was created based on the TellerApp project
    // EFFECTS: displays menu of options to user
    private void displayMenu() {
        System.out.println("\nSelect from the following:");
        System.out.println("\ta -> add a Patient");
        System.out.println("\tr -> remove a Patient");
        System.out.println("\tc -> get the total cost for all patients");
        System.out.println("\tg -> get the average rating of the hospital from all patients");
        System.out.println("\tp -> print patient");
        System.out.println("\ts -> save hospital to file");
        System.out.println("\tl -> load hospital from file");
        System.out.println("\tq -> quit");
    }

    // This method was created based on the TellerApp project
    // MODIFIES: this
    // EFFECTS: processes user command
    private void processCommand(String command) {
        if (command.equals("a")) {
            doAddPatient();
        } else if (command.equals("r")) {
            doRemovePatient();
        } else if (command.equals("c")) {
            getTotalCost();
        } else if (command.equals("g")) {
            getAverageRating();
        } else if (command.equals("p")) {
            printPatients();
        } else if (command.equals("s")) {
            saveHospital();
        } else if (command.equals("l")) {
            loadHospital();
        } else {
            System.out.println("Selection not valid...");
        }
    }

    //MODIFIES: this
    //EFFECTS: adds a patient to Record
    private void doAddPatient() {

        Scanner input = new Scanner(System.in);
        Scanner input2 = new Scanner(System.in);

        System.out.println("Enter the patient's name: ");
        String name = input.nextLine();

        System.out.println("Enter the patient's personal health number: ");
        int personalHealthNumber = input.nextInt();
        while (personalHealthNumber <= 0) {
//            System.out.println("Error: The patient's personal health number must be positive");
            personalHealthNumber = input.nextInt();
        }

        System.out.println("Enter the patient's diagnosis: ");
        String diagnosis = input2.nextLine();

        System.out.println("Enter the patient's cost of visits: ");
        double cost = input.nextDouble();
        while (cost < 0) {
//            System.out.println("Error: The patient's cost of visits must be non-negative");
            cost = input.nextDouble();
        }

        System.out.println("Enter patient's rating: ");
        double rating = input2.nextDouble();
        while (rating < 0 || rating > 10) {
//            System.out.println("Error: The patient's rating must be between 0 and 10. Re-enter the patient's rating");
            rating = input2.nextDouble();
        }
        record.insertPatient(new Patient(name, personalHealthNumber, diagnosis, cost, rating));
    }

    //MODIFIES: this
    //EFFECTS: removes a patient from Record
    private void doRemovePatient() {

        Scanner input = new Scanner(System.in);

        System.out.println("Enter the name of the patient whose record you wish to remove: ");
        String name = input.nextLine();

        if (record.containsName(name)) {
            System.out.println(name + "'s record has been removed");
            record.removePatient(name);
        } else {
            System.out.println("A record with that patient's name does not exist");
        }
    }

    //MODIFIES: this
    //EFFECTS: gets the total cost to all patients in Record
    private void getTotalCost() {
        try {
            record.cost();
            System.out.println("The total cost for the patients is " + record.cost());
        } catch (OutOfBoundsException s) {
            fail("OutOfBoundsException should have been thrown!");
        }
    }

    //MODIFIES: this
    //EFFECTS: gets the average rating of the hospital based on all patients in Record
    private void getAverageRating() {
        double averageRating = record.averageRating();
        System.out.println(averageRating);
    }

    // EFFECTS: prints all the thingies in hospital to the console
    private void printPatients() {
        List<Patient> patients = record.getPatients();

        for (Patient p: patients) {
            System.out.println("Name: " + p.getName() + "\n" + "Personal Health Number: " + p.getPersonalHealthNumber()
                    + "\n" + "Diagnosis: The patient has " + p.getDiagnosis() + "\n" + "Cost: " + p.getCost() + "\n"
                    + "Rating: " + p.getRating() + "\n");
        }
    }

    // EFFECTS: saves the hospital to file
    private void saveHospital() {
        try {
            jsonWriter.open();
            jsonWriter.write(record);
            jsonWriter.close();
            System.out.println("Saved to " + JSON_STORE);
        } catch (FileNotFoundException e) {
            System.out.println("Unable to write to file: " + JSON_STORE);
        }
    }

    // MODIFIES: this
    // EFFECTS: loads hospital from file
    private void loadHospital() {
        try {
            record = jsonReader.read();
            System.out.println("Loaded from " + JSON_STORE);
        } catch (IOException e) {
            System.out.println("Unable to read from file: " + JSON_STORE);
        }
    }
}