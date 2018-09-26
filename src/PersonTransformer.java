import java.util.List;

public class PersonTransformer {

    public List<Person> transform(List<Person> personList) {

        for (int i = 0; i < personList.size(); i++) {
            Person initialPerson = personList.get(i);

            for (int j = i + 1; j < personList.size(); j++) {
                Person currentPerson = personList.get(j);
                if (personsHaveTheSameName(initialPerson, currentPerson)) {
                    mergePersons(initialPerson, currentPerson);
                }
            }
        }

        removePersons(personList);

        return personList;
    }

    private void removePersons(List<Person> personList) {
        for (int i = personList.size() - 1; i >= 0; i--) {
            if (personList.get(i).isMarkedForRemoval()) {
                personList.remove(personList.get(i));
            }
        }
    }

    private boolean personsHaveTheSameName(Person firstPerson, Person secondPerson) {
        return firstPerson.getName().equals(secondPerson.getName());
    }

    private void mergePersons(Person initialPerson, Person currentPerson) {
        int newAge = initialPerson.getAge() + currentPerson.getAge();
        initialPerson.setAge(newAge);
        currentPerson.setName(Person.TO_REMOVE);
    }
}
