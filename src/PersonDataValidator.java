public class PersonDataValidator {

    public boolean isNameValid(String input) {
        return input.matches("[a-zA-Z]+") && !input.equals(Person.TO_REMOVE);
    }

    public boolean isAgeValid(String input) {
        return input.matches("[\\d]+");
    }

}
