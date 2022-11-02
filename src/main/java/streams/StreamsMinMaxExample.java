package streams;

import java.util.List;
import java.util.Optional;

public class StreamsMinMaxExample {

    public static int findMaxValue(List<Integer> integerList) {
        return integerList.stream()
                .reduce(0, (a, b) -> a > b ? a : b);
    }

    // What if we receive an empty list ? We should NOT have a default value (0)
    public static Optional<Integer> findMaxValueOptional(List<Integer> integerList) {
        return integerList.stream()
                .reduce((a, b) -> a > b ? a : b);
    }

    public static void main(String[] args) {
        var integersList = List.of(6, 7, 8, 9, 10);
        System.out.println("The max number is: " + findMaxValue(integersList));

        Optional<Integer> maxValueOptional = findMaxValueOptional(integersList);
        if (maxValueOptional.isPresent()) {
            System.out.println("The max number using Optional is: " + maxValueOptional.get());
        } else {
            System.out.println("Input list is empty");
        }
    }
}
