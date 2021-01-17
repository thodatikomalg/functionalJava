package streams;


import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static streams._Stream.Gender.FEMALE;
import static streams._Stream.Gender.MALE;


public class _Stream {

    public static void main(String[] args) {
        List<Person> people = List.of(
                new Person("John", MALE, 20),
                new Person("Maria", FEMALE, 45),
                new Person("Aisha", FEMALE, 15),
                new Person("Alex", MALE, 8),
                new Person("Alice", FEMALE, 17)
        );

        people.stream().map(person -> person.gender).collect(Collectors.toSet()).forEach(System.out::println);
        boolean containsFemales = people.stream().allMatch(person -> FEMALE.equals(person.gender));
        System.out.println(containsFemales);

        List<Person> filteredList = people.stream().filter(x -> MALE.equals(x.gender)).sorted(Comparator.comparing(Person::getAge).thenComparing(Person::getName))
                .collect(Collectors.toList());
        filteredList.forEach(System.out::println);

        String collect1 = Stream.of(1, 2).map(x -> x % 2 == 0 ? "e" + String.valueOf(x) : "o" + String.valueOf(x)).collect(Collectors.joining(","));
        System.out.println(collect1);
    }

    public static class Person {

        private final String name;
        private final Gender gender;
        private final int age;

        public Person(String name, Gender gender, int age) {
            this.name = name;
            this.gender = gender;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public Gender getGender() {
            return gender;
        }

        public int getAge() {
            return age;
        }

        @Override
        public String toString() {
            return "Person{" +
                    "name='" + name + '\'' +
                    ", gender=" + gender +
                    ", age=" + age +
                    '}';
        }
    }

    enum Gender {
        MALE, FEMALE
    }

}
