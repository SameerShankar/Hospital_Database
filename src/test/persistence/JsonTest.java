package persistence;

import static org.junit.jupiter.api.Assertions.assertEquals;
import model.Patient;

// this class was made based on the JsonSerializationDemo project provided on edX
public class JsonTest {
    protected void checkPatient(String name, int personalHealthNumber, String diagnosis,
                                double cost, double rating, Patient patient) {
        assertEquals(name, patient.getName());
        assertEquals(personalHealthNumber, patient.getPersonalHealthNumber());
        assertEquals(diagnosis, patient.getDiagnosis());
        assertEquals(cost, patient.getCost());
        assertEquals(rating, patient.getRating());
    }
}