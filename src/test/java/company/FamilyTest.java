package company;

import company.humans.Man;
import company.humans.Woman;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FamilyTest {
    private final Human mother = new Woman();
    private final Human father= new Man();
    private final Family family=new Family(mother,father);
    private final Human child= new Human();
    @Test
    void testAddChild(){
        family.addChild(child);
        assertEquals(1, family.getChildren().size());
    }

    @Test
    void testDeleteChild(){
        family.addChild(child);
        family.deleteChild(0);
        assertEquals(0, family.getChildren().size());

    }
    @Test
    void testCountFamily(){
        family.addChild(child);
        assertEquals(3, family.countFamily());
    }
    @Test
    void fakeTestDeleteChild(){
        family.addChild(child);
        family.deleteChild(1);
        assertNotEquals(0,family.getChildren().size());
    }
}