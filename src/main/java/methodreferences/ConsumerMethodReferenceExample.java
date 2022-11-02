package methodreferences;

import data.Student;
import data.StudentDataBase;

import java.util.function.Consumer;

public class ConsumerMethodReferenceExample {

    /**
     * classname::methodName
     */
    static Consumer<Student> c1 = System.out::println;

    public static void main(String[] args) {

        StudentDataBase.getAllStudents().forEach(c1);
    }
}
