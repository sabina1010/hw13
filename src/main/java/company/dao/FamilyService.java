package company.dao;

import company.Family;
import company.Human;
import company.abstracts.Pet;
import company.humans.Man;
import company.humans.Woman;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

public class FamilyService {
    private FamilyDao familyDao;
    public FamilyService(FamilyDao familyDao){
        this.familyDao = familyDao;
    }
    public List<Family> getAllFamilies(){
        return familyDao.getAllFamilies();
    }
    public void displayAllFamilies(){
        List<Family> familyList = getAllFamilies();
        for(int i = 0; i < familyList.size(); i++){
            Family family = familyList.get(i);
            System.out.println(i + "-" + family.prettyFormat());
        }
    }
    public List<Family> getFamiliesBiggerThan(int count){
        return getAllFamilies().stream()
                .filter(family -> family.countFamily() > count)
                .collect(Collectors.toList());
    }
    public List<Family> getFamiliesLessThan(int count){
        return getAllFamilies().stream()
                .filter(family -> family.countFamily() < count)
                .collect(Collectors.toList());
    }

    public int countFamiliesWithMemberNumber(int number){
        return getAllFamilies().stream()
                .reduce(0, (total, family) -> total + (family.countFamily() == number ? 1 : 0), Integer::sum);
    }
    public Family createNewFamily(Human mother, Human father){
        Family fam = new Family(mother, father);
        familyDao.saveFamily(fam);
        return fam;
    }
    public void deleteFamilyByIndex(int index){
        familyDao.deleteFamily(index);
    }
    public Family bornChild(Family family, String mName, String fName){
        Random random = new Random();
        int r = random.nextInt(100);
        Human child;
        if(r%2 == 1){
            child = new Man();
            child.setName(mName);
        }else{
            child = new Woman();
            child.setName(fName);
        }
        child.setBirthDate(LocalDate.now().getYear());
        child.setFamily(family);
        child.setSurname(family.getFather().getSurname());
        child.setIq((family.getFather().getIq()+family.getMother().getIq()) / 2);
        family.addChild(child);

        return family;
    }
    public Family adoptChild(Family family, Human child){
        family.addChild(child);
        child.setFamily(family);
        familyDao.saveFamily(family);
        return family;
    }

    public void deleteAllChildrenOlderThan(int age){
        getAllFamilies().stream()
                .forEach(family -> deleteChildrenOlderThan(family, age));
    }

    public int count(){
        return getAllFamilies().size();
    }
    public Family getFamilyById(int index){
        return familyDao.getFamilyByIndex(index);
    }
    public List<Pet> getPets(int index){
        List<Pet> pets = Collections.emptyList();
        if(index >= 0 && index < getAllFamilies().size()){
            pets = new ArrayList<>(familyDao.getFamilyByIndex(index).getPet());
        }
        return pets;
    }
    public void addPet(int index, Pet pet){
        if(index >= 0 && index < getAllFamilies().size()){
            familyDao.getFamilyByIndex(index).addPet(pet);
        }
    }
    public void saveToFile(){
        familyDao.saveFile();
    }
    public void loadFromFile(){
        familyDao.loadFile();
    }

    private void deleteChildrenOlderThan(Family family, int age){
        List<Human> children = family.getChildren();
        for(int i = 0; i < children.size(); i++){
            Human child = children.get(i);
            if(LocalDate.now().getYear() - epochToAge(child.getBirthDate()) > age){
                children.remove(i);
                i--;
            }
        }
    }

    private int epochToAge(long epoch){
        Date date = new Date(epoch);
        return LocalDate.now().getYear() - date.getYear() - 1900;
    }
}