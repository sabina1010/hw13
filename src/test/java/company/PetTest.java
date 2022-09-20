package company;

import company.abstracts.Pet;
import company.pets.DomesticCat;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class PetTest {
    private Pet cat;

    @BeforeEach
    void init() {
        cat = new DomesticCat("Charlie", 2, 1, Set.of("eating", "sleeping"));

    }

    @Test
    void testPetEquality() {
        Set<String> habits = new HashSet<>(Set.of("eating", "sleeping"));
        Pet cat2 = new DomesticCat( "Charlie", 2, 1, habits);
        assertEquals(cat, cat2);
    }

    @Test
    void testPetNonEquality(){
        Set<String> habits = new HashSet<>(Set.of("sleeping", "eating"));
        Pet cat2 = new DomesticCat ("Charlie", 1, 1,habits);
        assertNotEquals(cat, cat2);
    }

}