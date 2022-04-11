package persistence;

import model.Patient;
import model.Record;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

// this class was made based on the JsonSerializationDemo project provided on edX
public class JsonWriterTest extends JsonTest {

    @Test
    void testWriterInvalidFile() {
        try {
            Record r = new Record();
            JsonWriter writer = new JsonWriter("./data/my\0illegal:fileName.json");
            writer.open();
            fail("IOException was expected");
        } catch (IOException e) {
            // pass
        }
    }

    @Test
    void testWriterEmptyWorkroom() {
        try {
            Record r = new Record();
            JsonWriter writer = new JsonWriter("./data/testWriterEmptyWorkroom.json");
            writer.open();
            writer.write(r);
            writer.close();

            JsonReader reader = new JsonReader("./data/testWriterEmptyWorkroom.json");
            r = reader.read();
            assertEquals(0, r.numPatients());
        } catch (IOException e) {
            fail("Exception should not have been thrown");
        }
    }

    @Test
    void testWriterGeneralWorkroom() {
        try {
            Record r = new Record();
            r.insertPatient(new Patient("Gordon Ramsay",193517720,
                    "The patient has been diagnosed with Hepatitis B", 499.99, 3));
            r.insertPatient(new Patient("Walter White", 626758001,
                    "The patient has been diagnosed with type 1 diabetes", 0, 1));
            JsonWriter writer = new JsonWriter("./data/testWriterGeneralWorkroom.json");
            writer.open();
            writer.write(r);
            writer.close();

            JsonReader reader = new JsonReader("./data/testWriterGeneralWorkroom.json");
            r = reader.read();
            List<Patient> patients = r.getPatients();
            assertEquals(2, patients.size());
            checkPatient("Gordon Ramsay",193517720,
                    "The patient has been diagnosed with Hepatitis B", 499.99, 3, patients.get(0));
            checkPatient("Walter White", 626758001,
                    "The patient has been diagnosed with type 1 diabetes", 0, 1, patients.get(1));

        } catch (IOException e) {
            fail("Exception should not have been thrown");
        }
    }
}


