import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {

    private static final String EXIT = "0";
    private static final String ADD_PERSON = "1";
    private static final String TRANSFORM = "2";


    public void start() {
        List<Person> persons = new ArrayList<>();

        boolean runProgram = true;
        Scanner scanner = new Scanner(System.in);

        while (runProgram) {
            showMenu();
            String input = scanner.nextLine();
            runProgram = handleInput(scanner, persons, input);
        }
        scanner.close();
    }

    private boolean handleInput(Scanner scanner, List<Person> persons, String input) {
        boolean continueProgram = true;
        switch (input) {
            case EXIT:
                continueProgram = false;
                break;
            case ADD_PERSON:
                addPerson(scanner, persons);
                break;
            case TRANSFORM:
                transformPersons(persons);
                break;
            default:
                System.out.println("There is no such option");
                break;
        }
        return continueProgram;
    }

    private void addPerson(Scanner scanner, List<Person> persons) {
        PersonDataValidator validator = new PersonDataValidator();

        System.out.println("Please enter the name of a person(use only letters): ");
        String name = scanner.nextLine();
        if (!validator.isNameValid(name)) {
            System.out.println("The name is invalid");
            return;
        }

        System.out.println("Please enter the age of a person (use only digits): ");
        String age = scanner.nextLine();
        if (!validator.isAgeValid(age)) {
            System.out.println("The age is invalid");
            return;
        }

        persons.add(new Person(Integer.valueOf(age), name));
        System.out.println("Added a new person");
    }


    private void transformPersons(List<Person> persons) {
        persons = new PersonTransformer().transform(persons);

        for (Person p : persons) {
            System.out.println(p.getName());
            System.out.println(p.getAge());
            System.out.println("-----------");
        }
    }

    private void showMenu() {
        System.out.println("Enter what you want to do :\n" +
                "0 - exit\n" +
                "1 - add person\n" +
                "2 - transform list\n");
    }
}
