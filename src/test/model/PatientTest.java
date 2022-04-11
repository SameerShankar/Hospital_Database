package model;

import exceptions.OutOfBoundsException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PatientTest {

    private Patient testPatient;
    private Patient testPatient2;

    @BeforeEach
    void runBefore() {
        testPatient = new Patient("Gordon Ramsay",193517720,
                "The patient has been diagnosed with Hepatitis B", 499.99, 3);

        testPatient2 = new Patient("Walter White", 626758001,
                "The patient has been diagnosed with type 1 diabetes", 0, 1);

    }

    @Test
    void testPatientConstructor() {
        assertEquals("Gordon Ramsay", testPatient.getName());
        assertEquals(193517720, testPatient.getPersonalHealthNumber());
        assertEquals("The patient has been diagnosed with Hepatitis B", testPatient.getDiagnosis());
        assertEquals(499.99, testPatient.getCost());
        assertEquals(3, testPatient.getRating());
    }
}

