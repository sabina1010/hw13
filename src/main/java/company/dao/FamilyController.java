package company.dao;

import company.Family;
import company.Human;
import company.abstracts.Pet;
import company.exception.FamilyOverFlowException;

import java.util.List;

public class FamilyController {
    private int MAX_FAMILY_SIZE = 5;
    private FamilyService familyService;
    public FamilyController(FamilyService familyService){
        this.familyService = familyService;
    }
    public List<Family> getAllFamilies(){
        return familyService.getAllFamilies();
    }
    public void displayAllFamilies(){
        familyService.displayAllFamilies();
    }
    public List<Family> getFamiliesBiggerThan(int count){
        return familyService.getFamiliesBiggerThan(count);
    }
    public List<Family> getFamiliesLessThan(int count){
        return familyService.getFamiliesLessThan(count);
    }

    public int countFamiliesWithMemberNumber(int number){
        return familyService.countFamiliesWithMemberNumber(number);
    }
    public Family createNewFamily(Human mother, Human father){
        return familyService.createNewFamily(mother, father);
    }
    public void deleteFamilyByIndex(int index){
        familyService.deleteFamilyByIndex(index);
    }
    public Family bornChild(Family family, String mName, String fName){
        if(family.countFamily() >= MAX_FAMILY_SIZE){
            throw new FamilyOverFlowException("Family size must be smaller than " + MAX_FAMILY_SIZE);
        }
        return familyService.bornChild(family, mName, fName);
    }
    public Family adoptChild(Family family, Human child){
        if(family.countFamily() >= MAX_FAMILY_SIZE){
            throw new FamilyOverFlowException("Family size must be smaller than " + MAX_FAMILY_SIZE);
        }
        return familyService.adoptChild(family,child);
    }

    public void deleteAllChildrenOlderThan(int age){
        familyService.deleteAllChildrenOlderThan(age);
    }
    public void saveToFile(){
        familyService.saveToFile();
    }
    public void loadFromFile(){
        familyService.loadFromFile();
    }
    public int count(){
        return familyService.count();
    }
    public Family getFamilyById(int index){
        return familyService.getFamilyById(index);
    }
    public List<Pet> getPets(int index){
        return familyService.getPets(index);
    }
    public void addPet(int index, Pet pet){
        familyService.addPet(index, pet);
    }

}
