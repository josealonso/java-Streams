package methodreferences;

import data.Student;
import data.StudentDataBase;

import java.util.function.Predicate;

public class RefactorMethodReferenceExample {

    static Predicate<Student> p1 = RefactorMethodReferenceExample::greaterThanGradeLevel;


    public static boolean greaterThanGradeLevel(Student s) {
        return s.getGradeLevel() >= 3;
    }


    public static void main(String[] args) {

        var studentsList = StudentDataBase.getAllStudents();

        for (Student student : studentsList) {
            System.out.println(p1.test(student));
        }
        // System.out.println(p1.test(StudentDataBase.studentSupplier.get()));

    }
}
