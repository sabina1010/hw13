package company.pets;

import company.Species;
import company.abstracts.Pet;

import java.util.Set;

public class Fish extends Pet {
    public Fish(){
        super.setSpecies(Species.FISH);

    }
    public Fish( String nickName, int age, int trickLevel,  Set<String> habits){
        super(nickName, age, trickLevel, habits);
        super.setSpecies(Species.FISH);
    }
    @Override
    public void respond() {
        System.out.println(this.getNickName() +  " is responding" );

    }
}
