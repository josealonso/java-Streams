package numericstreams;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class NumericStreamsBoxingUnboxingExample {

    public static List<Integer> boxing() {
        return IntStream.rangeClosed(1, 10)
                .boxed()
                .collect(Collectors.toList());
    }

    public static int unBoxing(List<Integer> integerList) {
        // wrapper class to primitive data type
        return integerList.stream()
                .mapToInt(Integer::intValue)
                .sum();
    }

    public static void main(String[] args) {

        System.out.println("Boxing: " + boxing());
        List<Integer> integerList = boxing();
        System.out.println("Sum using unboxing: " + unBoxing(integerList));
    }
}
