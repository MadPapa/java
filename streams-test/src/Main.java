import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        List<Person> people = getPeople();

        // Imperative approach
        System.out.println("\nImperative approach");
        System.out.println();

        List<Person> females = new ArrayList<>();

        for (Person person : people) {
            if (person.getGender().equals(Gender.FEMALE)) {
                females.add(person);
            }
        }

        females.forEach(System.out::println);


        // Declarative approach
        System.out.println("\nDeclarative approach");
        System.out.println();

        // Filter
        List<Person> females2 = people
                .stream()
                .filter(person -> person.getGender().equals(Gender.FEMALE))
                .toList();

        females2.forEach(System.out::println);

        // Sort
        List<Person> sorted = people
                .stream()
                .sorted(Comparator.comparing(Person::getAge)
                        .thenComparing(Person::getGender)
                        .reversed())
                .toList();

        System.out.println();
        sorted.forEach(System.out::println);

        // All match
        boolean allHaveAgeBiggerThan5 = people
                .stream()
                .allMatch(person -> person.getAge() > 5);

        System.out.println();
        System.out.println(allHaveAgeBiggerThan5);

        // Any match
        boolean anyBiggerThan5 = people
                .stream()
                .anyMatch(person -> person.getAge() > 8);

        System.out.println();
        System.out.println(anyBiggerThan5);

        // None match
        boolean noneBiggerThan121 = people
                .stream()
                .noneMatch(person -> person.getName().equals("Antonio"));

        System.out.println();
        System.out.println(noneBiggerThan121);

        // Max
        people.stream()
                .max(Comparator.comparing(Person::getAge))
                .ifPresent(System.out::println);

        // Min
        Optional<Person> minAgePerson = people.stream()
                .min(Comparator.comparing(Person::getAge));

        System.out.println();
        System.out.println(minAgePerson);
        System.out.println();

        // Group
        Map<Gender, List<Person>> groupByGender = people.stream()
                .collect(Collectors.groupingBy(Person::getGender));

        groupByGender.forEach(((gender, people1) -> {
            System.out.println(gender);
            people1.forEach(System.out::println);
            System.out.println();
        }));

        System.out.println();
//        System.out.println(groupByGender);

        Optional<String> oldestFemaleAge = people.stream()
                .filter(person -> person.getGender().equals(Gender.FEMALE))
                .max(Comparator.comparing(Person::getAge))
                .map(Person::getName);

        System.out.println();
        oldestFemaleAge.ifPresent(System.out::println);



        Integer[] numbers = {1, 2, 3, 4, 5, 6};

        Optional<Integer> maxInteger = Arrays.stream(numbers)
                .max(Integer::compareTo);

        maxInteger.ifPresent(System.out::println);


        List<Double> doubles = List.of(1.2, 1.4, 2.2, 5.4);

        Optional<Double> minDouble = doubles.stream()
                .min(Double::compareTo);

        minDouble.ifPresent(System.out::println);


    }

    private static List<Person> getPeople() {
        return List.of(
                new Person("James Bond", 20, Gender.MALE),
                new Person("Alina Smith", 33, Gender.FEMALE),
                new Person("Helen White", 57, Gender.FEMALE),
                new Person("Alex Boz", 14, Gender.MALE),
                new Person("Jamie Goa", 99, Gender.MALE),
                new Person("Anna Cook", 7, Gender.FEMALE),
                new Person("Zelda Brown", 120, Gender.FEMALE)
        );
    }
}
