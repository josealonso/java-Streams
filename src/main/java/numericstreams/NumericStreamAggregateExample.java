package numericstreams;

import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.OptionalLong;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

public class NumericStreamAggregateExample {

    public static void main(String[] args) {

        int summation = IntStream.rangeClosed(1, 10).sum();
        System.out.println("Summation: " + summation);

        OptionalInt optionalInt = IntStream.rangeClosed(1, 10).max();
        System.out.println("The max value is: " +
                (optionalInt.isPresent() ? optionalInt.getAsInt() : 0));

        OptionalLong optionalLong = LongStream.rangeClosed(12, 20).min();
        System.out.println("The min value is: " +
                (optionalLong.isPresent() ? optionalLong.getAsLong() : 0));

        // "average" returns an OptionalDouble
        OptionalDouble optionalDouble = IntStream.rangeClosed(1, 12).average();
        System.out.println("The average value is: " +
                (optionalDouble.isPresent() ? optionalDouble.getAsDouble() : 0));

    }
}
