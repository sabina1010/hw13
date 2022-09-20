package company;

import company.dao.FamilyDao;
import company.dao.impl.CollectionFamilyDao;
import company.humans.Man;
import company.humans.Woman;
import company.dao.FamilyService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FamilyServiceTest {

    private FamilyService familyService;


    @BeforeEach
    public void init(){
        Human mother = new Woman();
        Human father= new Man();
        Family family=new Family(mother,father);
        Human child= new Human();
        familyService = new FamilyService(new CollectionFamilyDao());
        familyService.createNewFamily(family.getMother(), family.getFather());
        familyService.adoptChild(family, child);
    }

    @Test
    public void testGetFamiliesBiggerThan(){
        System.out.println(familyService.getAllFamilies().size());
        int expected = familyService.getFamiliesBiggerThan(2).size();
        assertEquals(expected, 1);
    }
    @Test
    public void testGetFamiliesLessThan(){
        int expected = familyService.getFamiliesLessThan(4).size();
        assertEquals(expected, 2);
    }
    @Test
    public void testCountFamiliesWithMemberNumber(){
        int expected = familyService.countFamiliesWithMemberNumber(3);
        assertEquals(expected, 1);
    }

    @Test
    public void testFamilyCount(){
        int expected = familyService.count();
        assertEquals(expected, 2);
    }
    @Test
    public void createNewFamily(){
        Human mother = new Woman();
        Human father= new Man();
        Family family=new Family(mother,father);
        familyService.createNewFamily(family.getMother(), family.getMother());
        int expected = familyService.count();
        assertEquals(expected, 3);
    }
    @Test
    public void deleteFamilyByIndex(){
        familyService.deleteFamilyByIndex(0);
        int expected = familyService.count();
        assertEquals(expected, 1);
    }
}
