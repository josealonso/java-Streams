package numericstreams;

import com.sun.source.doctree.SeeTree;

import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class NumericStreamsExample {

    public static int sumOfNumbersUsingReduce(List<Integer> integerList) {
        return integerList.stream()
                // unboxing to convert the Integer to int
                .reduce(0, (a, b) -> a + b);
    }

    public static int sumOfNumbersUsingIntStream(List<Integer> integerList) {
        // this is faster
        return IntStream.rangeClosed(1, 6)
                .sum();
    }

    public static void main(String[] args) {
        var integersList = List.of(1, 2, 3, 4, 5, 6);
        System.out.println("Sum using reduce: " + sumOfNumbersUsingReduce(integersList));
        System.out.println("Sum using IntStream: " + sumOfNumbersUsingIntStream(integersList));
    }
}
