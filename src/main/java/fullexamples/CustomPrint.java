package fullexamples;

import java.util.function.Function;

public class CustomPrint {
    Function<Integer, Integer> increment = e -> e + 1;
    Function<Integer, Integer> doubleIt = e -> e * 2;
    Function<Integer, Integer> incrementAndDouble = increment.andThen(doubleIt);

    public void print(int number, String message, Function<Integer, Integer> func) {
        System.out.println(number + " ---> " + message + " " + ": " + func.apply(number));
    }

    public static void main(String[] args) {
        new CustomPrint().print(6, "Increment and double", new CustomPrint().incrementAndDouble);
    }
}
