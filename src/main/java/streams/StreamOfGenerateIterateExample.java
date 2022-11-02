package streams;

import java.util.Random;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class StreamOfGenerateIterateExample {

    public static void main(String[] args) {
        // How to create a finite stream
        Stream<Integer> integerStream = Stream.of(1, 2, 3, 4);
        integerStream.forEach(System.out::println);

        // How to create an infinite stream
        Stream.iterate(1, x -> x * 2)
                .limit(10)
                .forEach(System.out::println);
        // Other method to create an infinite stream
        Supplier<Integer> integerSupplier = new Random()::nextInt;
        Stream.generate(integerSupplier)
                .limit(5)
                .forEach(System.out::println);
    }
}
