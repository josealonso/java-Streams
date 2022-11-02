package numericstreams;

import java.util.stream.IntStream;
import java.util.stream.LongStream;

public class NumericStreamRangesExample {
    public static void main(String[] args) {
        IntStream intStream = IntStream.range(1, 10);  // like "range" in Python
        System.out.println("Range Count: " + intStream.count());
        IntStream.range(1, 10).forEach((value -> System.out.print(value + ",")));

        // ======== Integer
        System.out.println("\nRange Closed Count: " + IntStream.rangeClosed(1, 10).count());
        // Beware: Use "print" instead of "println"
        IntStream.rangeClosed(1, 10).forEach((value -> System.out.print(value + ",")));
        // ======== Long
        System.out.println("\nLong Stream Range Closed Count: " + LongStream.rangeClosed(1, 10).count());
        LongStream.rangeClosed(1, 10).forEach((value -> System.out.print(value + ",")));
        System.out.println();
        // ======== Double
        System.out.println("Double Stream Range Closed Count: " + LongStream.rangeClosed(1, 10).count());
        IntStream.rangeClosed(1, 10).asDoubleStream().forEach(value -> System.out.print(value + ","));
    }

}
