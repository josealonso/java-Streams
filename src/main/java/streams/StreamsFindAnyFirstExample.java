package streams;

import data.Student;
import data.StudentDataBase;

import java.util.Optional;

/*
  Unless there are parallel streams, findFirst and findAny do the same thing
  Similar to the *Match operations, but they return the whole element.
 */
public class StreamsFindAnyFirstExample {

    public static Optional<Student> findAnyStudent() {
        return StudentDataBase.getAllStudents().stream()
                .filter(student -> student.getGpa() >= 3.9)
                .findAny();
    }

    public static void main(String[] args) {
        Optional<Student> result = findAnyStudent();
        if (result.isPresent()) {
            System.out.println("First student with a GPA greater than 3.8: \n" + result.get());
        } else {
            System.out.println("Student not found ");
        }
    }
}
