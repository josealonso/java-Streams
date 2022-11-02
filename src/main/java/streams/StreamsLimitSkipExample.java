package streams;

import java.util.List;
import java.util.Optional;

public class StreamsLimitSkipExample {

    public static Optional<Integer> sumTheFirstTwoValues(List<Integer> integers) {
        return integers.stream()
                .limit(2)
                .reduce((a, b) -> a + b);
    }

    public static Optional<Integer> sumExceptTheFirstTwoElements(List<Integer> integers) {
        return integers.stream()
                .skip(2)
                .reduce((a, b) -> a + b);
    }

    public static void main(String[] args) {
        var integersList = List.of(6, 7, 8, 9, 10);
        var result = sumTheFirstTwoValues(integersList);
        if (result.isPresent()) {
            System.out.println("First two list numbers sum: " + result.get());
        }
        var result2 = sumExceptTheFirstTwoElements(integersList);
        if (result2.isPresent()) {
            System.out.println("Sum all the elements except the first two: " + result2.get());
        }
    }
}
