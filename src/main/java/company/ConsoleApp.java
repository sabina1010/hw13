package company;

import company.dao.FamilyController;
import company.dao.FamilyService;
import company.dao.impl.CollectionFamilyDao;
import company.humans.Man;
import company.humans.Woman;

import java.util.Scanner;

public class ConsoleApp {
    private String commands = "Commands: \n" +
            "1. Fill with test data\n" +
            "2. Display the entire list of families\n" +
            "3. Display a list of families where the number of people is greater than the specified number\n" +
            "4. Display a list of families where the number of people is less than the specified number\n" +
            "5. Calculate the number of families where the number of members is equal to the specified number\n" +
            "6. Create a new family\n" +
            "7. Delete a family\n" +
            "8. Edit a family by its index in the general list\n" +
            "9. Remove all children over the specified age\n" +
            "10. Load data from file\n" +
            "11. Save data to file\n" +
            "`exit` to exit\n";

    private String editCommands = "Commands: \n" +
            "1. Give birth\n" +
            "2. Adopt a child\n" +
            "`exit` to go back main menu\n";
    private final FamilyController familyController = new FamilyController(new FamilyService(new CollectionFamilyDao()));

    public void start(){
        Scanner sc = new Scanner(System.in);
        while(true){
            System.out.println(commands);
            System.out.print("Enter command: ");
            String command = sc.nextLine();
            if(command.equalsIgnoreCase("exit")){
                break;
            }
            try {
                switch (command) {
                    case "1":
                        fillWithTestData();
                        break;
                    case "2":
                        familyController.displayAllFamilies();
                        break;
                    case "3":
                        System.out.print("Enter value: ");
                        int number = Integer.parseInt(sc.nextLine());
                        familyController.getFamiliesBiggerThan(number).forEach(family -> System.out.println(family.prettyFormat()));
                        break;
                    case "4":
                        System.out.print("Enter value: ");
                        number = Integer.parseInt(sc.nextLine());
                        familyController.getFamiliesLessThan(number).forEach(family -> System.out.println(family.prettyFormat()));
                        break;
                    case "5":
                        System.out.print("Enter value: ");
                        number = Integer.parseInt(sc.nextLine());
                        System.out.println(familyController.countFamiliesWithMemberNumber(number));
                        break;
                    case "6":
                        createFamily(sc);
                        break;
                    case "7":
                        System.out.print("Enter index: ");
                        int index = Integer.parseInt(sc.nextLine());
                        familyController.deleteFamilyByIndex(index);
                        break;
                    case "8":
                        editFamily(sc);
                        break;
                    case "9":
                        System.out.println("Removing all children over the specified age: ");
                        int age = Integer.parseInt(sc.nextLine());
                        familyController.deleteAllChildrenOlderThan(age);
                        break;
                    case "10":
                        familyController.loadFromFile();
                        break;
                    case "11":
                        familyController.saveToFile();
                        break;
                    default:
                        System.out.println("Unknown command");
                }
            }catch (NumberFormatException e){
                System.out.println("Improper input");
            }
        }
    }

    private void editFamily(Scanner sc){
        System.out.println(editCommands);
        System.out.print("Enter command: ");
        String command = sc.nextLine();
        if(command.equalsIgnoreCase("exit")){
            return;
        }
        switch (command){
            case "1":
                System.out.print("Enter family index: ");
                int index = Integer.parseInt(sc.nextLine());
                System.out.print("Enter male name: ");
                String mName = sc.nextLine();
                System.out.print("Enter female name: ");
                String fName = sc.nextLine();
                familyController.bornChild(familyController.getFamilyById(index), mName, fName);
                break;
            case "2":
                System.out.print("Enter family index: ");
                index = Integer.parseInt(sc.nextLine());
                System.out.print("Enter child name: ");
                String name = sc.nextLine();
                System.out.print("Enter child surname: ");
                String surname = sc.nextLine();
                System.out.print("Enter child birth date(dd/MM/yyyy): ");
                String birthDate = sc.nextLine();
                System.out.print("Enter child iq: ");
                int iq = Integer.parseInt(sc.nextLine());

                familyController.adoptChild(familyController.getFamilyById(index),
                        new Human(name, surname, birthDate, iq));
                break;
            default:
                System.out.println("Unknown command");
        }
    }
    private void fillWithTestData(){
        Human mother = new Woman("Mother", "Surname", "10/10/1990", 101);
        Human father= new Man("Father", "Surname", "11/11/1990", 101);
        Family family=new Family(mother,father);
        Human child= new Human("Child", "Surname", "15/12/2020",101);

        familyController.createNewFamily(mother, father);
        familyController.adoptChild(family,child);
    }

    private void createFamily(Scanner sc){
        System.out.println("Enter mother's name: ");
        String motherName = sc.nextLine();
        System.out.println("Enter mother's surname: ");
        String motherSurname = sc.nextLine();
        System.out.println("Enter mother's birth date(dd/MM/yyyy): ");
        String motherBirthDate = sc.nextLine();
        System.out.println("Enter mother's iq: ");
        int iq = Integer.parseInt(sc.nextLine());
        Woman mother = new Woman(motherName, motherSurname, motherBirthDate, iq);

        System.out.println("Enter father's name: ");
        String fatherName = sc.nextLine();
        System.out.println("Enter father's surname: ");
        String fatherSurname = sc.nextLine();
        System.out.println("Enter father's birth date(dd/MM/yyyy): ");
        String fatherBirthDate = sc.nextLine();
        System.out.println("Enter father's iq: ");
        iq = Integer.parseInt(sc.nextLine());
        Man father = new Man(fatherName, fatherSurname, fatherBirthDate, iq);
        familyController.createNewFamily(mother, father);
    }
}
