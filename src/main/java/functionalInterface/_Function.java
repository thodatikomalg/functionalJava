package functionalInterface;


import java.util.function.BiFunction;
import java.util.function.Function;

public class _Function {
    public static void main(String[] args) {
        int increment = incrementByOne(1);
        System.out.println(increment);

        System.out.println("*** Function accepts one argument and produces a result *** ");
        int increment2 = incrementByOneFunction.apply(1);
        System.out.println(increment2);
        Function<Integer, Integer> incrementAndMultipy = incrementByOneFunction.andThen(multiplyByTenFunction);
        int increment3 = incrementAndMultipy.apply(1);
        System.out.println(increment3);

        System.out.println("---BiFunction example");
        int increment4 = incrementByOneAndMultiplyBiFunction.apply(4, 10);
        System.out.println(increment4);
    }

    static Function<Integer, Integer> incrementByOneFunction = number -> number + 1;
    static Function<Integer, Integer> multiplyByTenFunction = number -> number * 10;


    static int incrementByOne(int i) {
        return i + 1;
    }

    static int incrementByOneAndMultiply(int num, int numToMultiply) {
        return (num + 1) * numToMultiply;
    }

    static BiFunction<Integer, Integer, Integer> incrementByOneAndMultiplyBiFunction =
            (numberToIncrementByOne, numberToMultiply) -> (numberToIncrementByOne + 1) * numberToMultiply;

}
