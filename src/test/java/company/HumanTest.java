package company;

import company.humans.Woman;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HumanTest {
    private Human sabi;

    @BeforeEach
    void init() {
        sabi = new Woman("Sabina", "Ahmadova", 2005);
    }

    @Test
    void testHumanEquality() {
        Human sabi2 = new Woman("Sabina", "Ahmadova", 2005);
        assertEquals(sabi, sabi2);
    }

    @Test
    void testHumanNonEquality(){
        Human sabi2 = new Woman("Sabina", "Ahmadova", 2000);
        assertNotEquals(sabi, sabi2);
    }
}