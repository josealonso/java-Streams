package streams;

import data.Student;
import data.StudentDataBase;

public class StreamMapReduceExample {

    private static double sumOfGpas() {
        return StudentDataBase.getAllStudents().stream()
                .map(Student::getGpa)
                //.reduce(0.0, (a, b) -> a + b);
                .reduce(0.0, Double::sum);    // These lines are equivalent
    }

    public static void main(String[] args) {
        System.out.println("Total of GPAs: " + sumOfGpas());
    }
}
