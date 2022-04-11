package persistence;

import org.json.JSONObject;

// this interface was made based on the JsonSerializationDemo project provided on edX
public interface Saveable {
// EFFECTS: returns this as JSON object
    JSONObject toJson();
}



