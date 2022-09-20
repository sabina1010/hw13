package company.humans;

import company.DayOfWeeks;
import company.Family;
import company.Human;

import java.util.Map;

public final class Man extends Human {
    public void car(){
        System.out.println("Mercedes");
    }
    public void greetPet() {
        System.out.println("Hello from Mr." + super.getName());
    }

    public Man (){

    }
    public Man(String name, String surname, int year, int iq, Map<DayOfWeeks, String> schedule, Family family){
        super(name,surname,year,iq,schedule,family);
    }
    public Man(String name, String surname, int year){
        super(name,surname,year);
    }
    public Man(String name, String surname, String birthDate, int iq) {
        super(name,surname,birthDate,iq);
    }
}
