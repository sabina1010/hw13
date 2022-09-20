package company.pets;

import company.Species;
import company.abstracts.Foul;
import company.abstracts.Pet;

import java.util.Set;

public class DomesticCat extends Pet implements Foul {
    public DomesticCat(){
        super.setSpecies(Species.DOMESTICCAT);

    }
    public DomesticCat( String nickName, int age, int trickLevel, Set<String> habits){
        super(nickName, age, trickLevel, habits);
        super.setSpecies(Species.DOMESTICCAT);
    }
    @Override
    public void respond() {
        System.out.println(this.getNickName() +  " is responding" );

    }

    @Override
    public void foul() {
        System.out.println(this.getNickName() +  " fouls" );

    }
}
