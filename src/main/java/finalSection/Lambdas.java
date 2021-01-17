package finalSection;

import java.util.function.BiFunction;
import java.util.function.Function;

public class Lambdas {

    public static void main(String[] args) {

        Integer counter = null;
       // int count = null;  -> cannot pass null values through primitive types hence we pass Object types in functional programming.

        Function<String, String> upperCaseName = name -> {
            if(name.isBlank()) throw new IllegalStateException("");
            return name.toUpperCase();
        };

        BiFunction<String, Integer, String> nameAndAge = (name, age) ->{
            if(name.isBlank()) throw new IllegalStateException("");
            System.out.println("Age is " + age);
            return name.toUpperCase();
        };

        upperCaseName.apply("Alex");
        nameAndAge.apply("Alex", 20);
    }
}
