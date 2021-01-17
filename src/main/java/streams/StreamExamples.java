package streams;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamExamples {
    public static void main(String[] args) throws IOException {
        IntStream.range(1, 10).skip(5).forEach(System.out::println);
        System.out.println(IntStream.range(1, 10).sum());

        Stream.of("komal", "Alberto", "zane").filter(x -> x.contains("l")).sorted().forEach(System.out::println);

        // avg of squares of int array
        Arrays.stream(new int[]{1, 2, 3, 5}).map(x -> x * x).average().ifPresent(System.out::println);

        //Stream from a list filter them and print
        List<String> people = Arrays.asList("Alex", "Tesla", "Mazda", "Nexus");
        people.stream().map(String::toLowerCase).filter(x -> x.startsWith("t")).forEach(System.out::println);

        // Stream rows from test file, sort , filter and print
        Files.lines(Paths.get("src/main/java/streams/random.txt")).filter(x -> x.length() > 5).forEach(System.out::println);

        //reduce
        double total = Stream.of(10.0, 12.05, 3.4).reduce(0.0, (a, b) -> a + b);
        System.out.println(total);

        //reduction to summary statistics
        IntSummaryStatistics summary = IntStream.of(7, 10, 6, 12).summaryStatistics();
        System.out.println(summary);
    }
}
