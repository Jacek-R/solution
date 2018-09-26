import java.util.ArrayList;
import java.util.List;

public class App {

    public void start() {
        List<Person> persons = new ArrayList<>();
        persons.add(new Person(20, "Asia"));
        persons.add(new Person(15, "Asia"));
        persons.add(new Person(18, "Maciek"));
        persons.add(new Person(22, "Jacek"));
        persons.add(new Person(16, "Artur"));
        persons.add(new Person(22, "Maciek"));
        persons.add(new Person(24, "Asia"));


        persons = new PersonTransformer().transform(persons);

        for (Person p : persons) {
            System.out.println(p.getName());
            System.out.println(p.getAge());
        }

        PersonDataValidator dataValidator = new PersonDataValidator();

        System.out.println("--Validate age--");
        System.out.println(dataValidator.isAgeValid("20"));
        System.out.println(dataValidator.isAgeValid("1"));
        System.out.println(dataValidator.isAgeValid("d2"));
        System.out.println(dataValidator.isAgeValid("2dd3"));
        System.out.println(dataValidator.isAgeValid(""));
        System.out.println(dataValidator.isAgeValid("Marcin"));
        System.out.println("--Validate name--");
        System.out.println(dataValidator.isNameValid("bogdan"));
        System.out.println(dataValidator.isNameValid("Anna"));
        System.out.println(dataValidator.isNameValid("TO_REMOVE"));
        System.out.println(dataValidator.isNameValid(""));
        System.out.println(dataValidator.isNameValid("33"));
        System.out.println(dataValidator.isNameValid("fr4"));

    }
}
