package company;

import java.io.Serial;
import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.util.Date;
import java.util.Map;
import java.util.Objects;

public class Human implements Serializable {
    @Serial
    private static final long serialVersionUID = 1;
    private String name;
    private String surname;
    private long birthDate;
    private int iq;
    private Map<DayOfWeeks, String> schedule;
    private Family family;


    public Human(String name, String surname, long birthDate) {
        this.setName(name);
        this.setSurname(surname);
        this.setBirthDate(birthDate);
    }

    public Human() {

    }
    public Human(String name, String surname, String birthDate, int iq) {
        this.setName(name);
        this.setSurname(surname);
        this.setBirthDate(stringToDate(birthDate));
        this.setIq(iq);
    }
    public Human(String name, String surname, int birthDate, int iq, Map <DayOfWeeks, String> schedule, Family family) {
        this.setName(name);
        this.setSurname(surname);
        this.setBirthDate(birthDate);
        this.setIq(iq);
        this.setSchedule(schedule);
        this.setFamily(family);
    }

    public Human(String name, String surname, long birthDate, Human father, Human mother) {
        this.setName(name);
        this.setSurname(surname);
        this.setBirthDate(birthDate);
    }


    public void greetPet() {
        System.out.println("Hello");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public long getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(long birthDate) {
        this.birthDate = birthDate;
    }

    public int getIq() {
        return iq;
    }

    public void setIq(int iq) {
        this.iq = iq;
    }


    public Map<DayOfWeeks, String> getSchedule() {
        return schedule;
    }

    public void setSchedule( Map<DayOfWeeks, String> schedule) {
        this.schedule = schedule;
    }

    @Override
    public String toString() {
        return "Human{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", birthdate=" + new SimpleDateFormat("dd/MM/yyyy").format(birthDate) +
                ", iq=" + iq +
                ", schedule=" + schedule +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Human human = (Human) o;
        return birthDate == human.birthDate && iq == human.iq && Objects.equals(name, human.name) && Objects.equals(surname, human.surname);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(name, surname, birthDate, iq);
        return result;
    }

    @Override
    protected void finalize()  {
        System.out.printf("%s %s is deleted\n",name, surname);
    }

    public Family getFamily() {
        return family;
    }

    public void setFamily(Family family) {
        this.family = family;
    }

    public String describeAge(){
        Date date = new Date(birthDate);
        int year = LocalDate.now().getYear() - date.getYear() - 1900;
        int month = LocalDate.now().getMonthValue() - date.getMonth() - 1;
        int day = LocalDate.now().getDayOfMonth() - date.getDay();
        return year + " years " + month + " months " + day + " days";
    }

    private long stringToDate(String date)  {
        try {
            return new SimpleDateFormat("dd/MM/yyyy").parse(date).toInstant().toEpochMilli();
        }catch (ParseException e){
            e.printStackTrace();
        }
        return 0;
    }

}