package functionalInterfaces;

import data.Student;
import data.StudentDataBase;

import java.util.List;
import java.util.function.Consumer;

/*
A Functional Interface (SAM) is an interface that has exactly one abstract method.
The @FunctionalInterface annotation was introduced in Java 8. It's optional.

New functional interfaces in Java 8 --->
Consumer - Predicate - Function
*/
public class ConsumerExample {

    static Consumer<Student> c2 = (student) -> System.out.println(student);
    static Consumer<Student> c3 = (student) -> System.out.print(student.getName());
    static Consumer<Student> c4 = (student) -> System.out.println(student.getActivities());

    public static void printStudents() {
        List<Student> studentList = StudentDataBase.getAllStudents();
        studentList.forEach(c2);
    }

    public static void printNameAndActivities() {
        List<Student> studentList = StudentDataBase.getAllStudents();
        studentList.forEach(c3.andThen(c4));  // consumer chaining
    }

    public static void printNameAndActivitiesUsingCondition() {
        List<Student> studentList = StudentDataBase.getAllStudents();
        studentList.forEach((student -> {
            if (student.getGradeLevel() > 2) {
                c3.andThen(c4).accept(student);
            }
        }));
    }

    public static void main(String[] args) {
        Consumer<String> c1 = (s) -> System.out.println(s.toUpperCase());

        c1.accept("java8");
        printStudents();
        System.out.println("====================");
        printNameAndActivities();
        System.out.println("====================");
        printNameAndActivitiesUsingCondition();
    }
}
