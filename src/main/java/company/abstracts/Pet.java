package company.abstracts;

import company.Species;

import java.util.Objects;
import java.util.Set;

public abstract class Pet {
    private Species species;
    private String nickName;
    private int age;
    private int trickLevel;
    private Set <String> habits;




    //empty const
    public Pet() {
    }

    //all fields
    public Pet( String nickName, int age, int trickLevel, Set <String> habits) {
        this.setSpecies(Species.UNKNOWN);
        this.setNickName(nickName);
        this.setAge(age);
        this.setTrickLevel(trickLevel);
        this.setHabits(habits);
    }

    //species nickname
    public Pet (String nickName) {
        this.setSpecies(Species.UNKNOWN);
        this.setNickName(nickName);
    }

    public void eat() {
        System.out.println("I am eating");
    }

    public abstract void respond();


    public Species getSpecies() {
        return species;
    }

    public void setSpecies(Species species) {
        this.species = species;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getTrickLevel() {
        return trickLevel;
    }

    public void setTrickLevel(int trickLevel) {
        this.trickLevel = trickLevel;
    }

    public Set <String> getHabits() {
        return habits;
    }

    public void setHabits(Set <String> habits) {
        this.habits = habits;
    }

    @Override
    public String toString() {
        return "Pet{" +
                "species=" + species +
                ", nickName='" + nickName + '\'' +
                ", age=" + age +
                ", trickLevel=" + trickLevel +
                ", habits=" + habits +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pet pet = (Pet) o;
        return age == pet.age && trickLevel == pet.trickLevel && species == pet.species && Objects.equals(nickName, pet.nickName);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(species, nickName, age, trickLevel);
        return result;

    }

    @Override
    protected void finalize()  {
        System.out.printf("%s is deleted",nickName);
    }
}
