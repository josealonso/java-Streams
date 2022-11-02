package streams;

import data.Student;
import data.StudentDataBase;

import java.util.List;
import java.util.Optional;

/*
reduce is a terminal operation used to reduce the contents of a stream
to a single value
 */
public class StreamReduceExample {
    public static int performMultiplication(List<Integer> integerList) {
        return integerList.stream()
                .reduce(1, (a, b) -> a * b);  // 1 is the accumulator
    }

    // A function should NOT return an Optional type
    public static Optional<Integer> performSumWithoutIdentity(List<Integer> integerList) {
        return integerList.stream()
                .reduce((a, b) -> a + b);
    }

    public static Optional<Student> getHighestGpaStudent() {
        return StudentDataBase.getAllStudents().stream()
                .reduce((s1, s2) -> (s1.getGpa() > s2.getGpa() ? s1 : s2));
    }

    public static void main(String[] args) {
        int sum = 0;
        var integersList = List.of(1, 3, 5, 7);
        if (performSumWithoutIdentity(integersList).isPresent()) {
            sum = performSumWithoutIdentity(integersList).get();
        }

        System.out.println("Sum is: " + sum);
        System.out.println("Multiplication is: " + performMultiplication(integersList));
        Optional<Student> winnerStudent = getHighestGpaStudent();
        if (winnerStudent.isPresent()) {
            var student = winnerStudent.get();
            System.out.println("Highest GPA student is: " + student);
        }
    }
}
