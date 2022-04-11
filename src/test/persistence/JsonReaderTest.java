package persistence;

import model.Patient;
import model.Record;
import org.junit.jupiter.api.Test;


import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

// this class was made based on the JsonSerializationDemo project provided on edX
public class JsonReaderTest extends JsonTest {

    @Test
    void testReaderNonExistentFile() {
        JsonReader reader = new JsonReader("./data/noSuchFile.json");
        try {
            Record r = reader.read();
            fail("IOException expected");
        } catch (IOException e) {
            // pass
        }
    }

    @Test
    void testReaderEmptyRecord() {
        JsonReader reader = new JsonReader("./data/testReaderEmptyRecord.json");
        try {
            Record r = reader.read();
            assertEquals(0, r.numPatients());
        } catch (IOException e) {
            fail("Couldn't read from file");
        }
    }

    @Test
    void testReaderGeneralRecord() {
        JsonReader reader = new JsonReader("./data/testReaderGeneralRecord.json");
        try {
            Record r = reader.read();
            List<Patient> patients = r.getPatients();
            assertEquals(2, patients.size());
            checkPatient("Gordon Ramsay", 193517720,
                    "The patient has been diagnosed with Hepatitis B", 499.99, 3, patients.get(0));
            checkPatient("Walter White", 626758001,
                    "The patient has been diagnosed with type 1 diabetes", 0, 1, patients.get(1));
        } catch (IOException e) {
            fail("Couldn't read from file");
        }
    }
}
