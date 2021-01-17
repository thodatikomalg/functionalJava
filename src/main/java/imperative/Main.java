package imperative;


import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import static imperative.Main.Gender.*;

public class Main {
    public static void main(String[] args) {

        List<Person> people = List.of(
                new Person("John", MALE),
                new Person("Maria", FEMALE),
                new Person("Aisha", FEMALE),
                new Person("Alex", MALE),
                new Person("Alice", FEMALE)
        );

        System.out.println("Imperative approach");

        List<Person> females = new ArrayList<>();
        for(Person p : people){
            if(FEMALE.equals(p.gender)){
                females.add(p);
            }
        }

        for(Person female: females){
            System.out.println(female);
        }

        System.out.println("Declarative approach");
        people.stream().filter(person -> FEMALE.equals(person.gender)).forEach(System.out::println);
        List<Person> females2 = people.stream().filter(person -> FEMALE.equals(person.gender)).collect(Collectors.toList());
        females2.forEach(System.out::println);

        System.out.println("---Using Predicate");
        System.out.println("**** Predicate represent boolean value of a function ***");
        Predicate<Person> personPredicate = person -> FEMALE.equals(person.gender);
        people.stream().filter(personPredicate).forEach(System.out::println);

    }


     public static class Person {

        private final String name;
        private final Gender gender;

        public Person(String name, Gender gender) {
            this.name = name;
            this.gender = gender;
        }

        @Override
        public String toString() {
            return "Person{" +
                    "name='" + name + '\'' +
                    ", gender=" + gender +
                    '}';
        }
    }

    public enum Gender {
        MALE, FEMALE
    }

}

