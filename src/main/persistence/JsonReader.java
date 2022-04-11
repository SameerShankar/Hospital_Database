package persistence;

import model.Patient;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

import model.Record;
import org.json.*;

// this method was made based on the JsonSerializationDemo project provided on edX
// Represents a reader that reads record from JSON data stored in file
public class JsonReader {
    private String source;

    // EFFECTS: constructs reader to read from source file
    public JsonReader(String source) {
        this.source = source;
    }

    // EFFECTS: reads record from file and returns it;
    // throws IOException if an error occurs reading data from file
    public Record read() throws IOException {
        String jsonData = readFile(source);
        JSONObject jsonObject = new JSONObject(jsonData);
        return parseRecord(jsonObject);
    }

    // EFFECTS: reads source file as string and returns it
    private String readFile(String source) throws IOException {
        StringBuilder contentBuilder = new StringBuilder();

        try (Stream<String> stream = Files.lines(Paths.get(source), StandardCharsets.UTF_8)) {
            stream.forEach(s -> contentBuilder.append(s));
        }

        return contentBuilder.toString();
    }

    // EFFECTS: parses record from JSON object and returns it
    private Record parseRecord(JSONObject jsonObject) {
        Record r = new Record();
        addPatients(r, jsonObject);
        return r;
    }

    // MODIFIES: h
    // EFFECTS: parses patients from JSON object and adds them to record
    private void addPatients(Record r, JSONObject jsonObject) {
        JSONArray jsonArray = jsonObject.getJSONArray("patients");
        for (Object json : jsonArray) {
            JSONObject nextPatient = (JSONObject) json;
            addPatient(r, nextPatient);
        }
    }

    // MODIFIES: h
    // EFFECTS: parses patient from JSON object and adds it to record
    private void addPatient(Record r, JSONObject jsonObject) {
        String name = jsonObject.getString("name");
        int personalHealthNumber = jsonObject.getInt("personal health number");
        String diagnosis = jsonObject.getString("diagnosis");
        int cost = jsonObject.getInt("cost");
        int rating = jsonObject.getInt("rating");
        Patient patient = new Patient(name, personalHealthNumber, diagnosis, cost, rating);
        r.insertPatient(patient);
    }
}
