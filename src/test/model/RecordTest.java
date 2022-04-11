package model;

import exceptions.OutOfBoundsException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class RecordTest {

    private Record records;
    private Patient p1;
    private Patient p2;
    private Patient p3;
    private Patient p4;
    private Patient p5;
    private Patient p6;

    @BeforeEach
    void runBefore() {
        records = new Record();
        p1 = new Patient("Gordon Ramsay", 193517720, "The patient has been diagnosed with Hepatitis B", 49.99, 3);
        p2 = new Patient("Toni Kroos", 274196685,
                "The patient has been diagnosed with Japanese encephalitis virus", 99.99, 10);
        p3 = new Patient("Roger Federer", 443875421, "The patient has been diagnosed with COVID-19", 29.99, 8);
        p4 = new Patient("Jesse Pinkman", 825537192, "The patient is healthy", 14.99, 6);
        p5 = new Patient("Walter White", 626758001, "The patient has been diagnosed with type 1 diabetes", 0, 1);
    }

    @Test
    void testRecordConstructor() {
        assertEquals(0, records.size());
    }

    @Test
    public void testInsertAPatient() {
        records.insertPatient(p1);

        assertTrue(records.containsPatient(p1));
        assertEquals(1, records.size());
    }

    @Test
    public void testInsertMultiplePatients() {

        records.insertPatient(p1);
        records.insertPatient(p2);
        records.insertPatient(p4);
        records.insertPatient(p5);

        assertTrue(records.containsPatient(p1));
        assertTrue(records.containsPatient(p4));
        assertEquals(4, records.size());
    }

    @Test
    public void testInsertNoDuplicates() {
        records.insertPatient(p1);
        records.insertPatient(p1);
        records.insertPatient(p3);
        records.insertPatient(p3);

        assertTrue(records.containsPatient(p1));
        assertTrue(records.containsPatient(p3));
        assertEquals(2, records.size());
    }

    @Test
    public void testRemoveAPatient() {
        records.insertPatient(p1);
        records.removePatient(p1.getName());
        assertFalse(records.containsPatient(p1));
        assertEquals(0, records.size());

    }

    @Test
    public void testRemoveMultiplePatients() {

        records.insertPatient(p1);
        records.insertPatient(p2);
        records.insertPatient(p4);
        records.insertPatient(p5);

        records.removePatient(p1.getName());
        records.removePatient(p2.getName());
        records.removePatient(p4.getName());
        records.removePatient(p5.getName());

        assertFalse(records.containsPatient(p1));
        assertFalse(records.containsPatient(p2));
        assertFalse(records.containsPatient(p4));
        assertFalse(records.containsPatient(p5));

        assertEquals(0, records.size());
    }

    @Test
    public void testContainsName() {
        records.insertPatient(p1);
        records.insertPatient(p2);
        records.insertPatient(p4);
        records.insertPatient(p5);

        assertTrue(records.containsName("Gordon Ramsay"));
        assertFalse(records.containsName("Sameer Shankar"));
    }


    @Test
    public void testCostNone() {

        try {
            records.cost();
            assertEquals(0, records.cost());
        } catch(OutOfBoundsException s) {
            fail("OutOfBoundsException thrown!");
        }
    }

    @Test
    public void testCostSingle() {

        records.insertPatient(p1);

        try {
            records.cost();
            assertEquals(p1.getCost(), records.cost());
        } catch(OutOfBoundsException s) {
            fail("OutOfBoundsException thrown!");
        }
    }

    @Test
    public void testCostSingleException() {

        p6 = new Patient("xyz", 935177203, "Cancer", -3443,4);

        records.insertPatient(p6);
        try {
            records.cost();
            fail("OutOfBoundsException should have been thrown!");
        } catch(OutOfBoundsException s) {
            //expected
        }
    }

    @Test
    public void testCostMultiple() {

        records.insertPatient(p1);
        records.insertPatient(p2);
        records.insertPatient(p3);
        records.insertPatient(p4);
        records.insertPatient(p5);

        try {
            records.cost();
            assertEquals(p1.getCost() + p2.getCost() + p3.getCost() +
                    p4.getCost() + p5.getCost(), records.cost());
        } catch(OutOfBoundsException s) {
            fail("OutOfBoundsException thrown!");
        }
    }

    @Test
    public void testAverageRatingSingle() {

        records.insertPatient(p1);

        assertEquals(p1.getRating(), records.averageRating());
    }

    @Test
    public void testAverageRatingMultiple() {

        records.insertPatient(p1);
        records.insertPatient(p2);
        records.insertPatient(p3);
        records.insertPatient(p4);
        records.insertPatient(p5);

        assertEquals((p1.getRating() + p2.getRating() + p3.getRating() + p4.getRating() + p5.getRating()) / records.size(), records.averageRating());
    }
}