package lambdas;

import java.util.function.Consumer;

public class LambdaVariable1 {

    public static void main(String[] args) {

        int i = 0;

        Consumer<Integer> c1 = (i1) -> { // "i1" cannot be called "i"

            System.out.println("Value is : " + i);
        };
    }
}
