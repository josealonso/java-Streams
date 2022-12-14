package fullexamples;

import java.util.stream.IntStream;

public class Primes {

    public boolean isPrimeImperativeStyle(int number) {
        boolean divisible = false;
        for (int i = 2; i < number; i++) {
            if (number % i == 0) {
                divisible = true;
                break;
            }
        }
        return number > 1 && !divisible;
    }

    // Think declaratively and code functionally
    public boolean isPrimeFunctionalStyle(int number) {
        // given a range of numbers from 2 to the given number - 1,
        // the given number is a prime number if no number in the range can divide it
        return number > 1 && IntStream.range(2, number)
                .noneMatch(i -> number % i == 0);
    }

    public static void main(String[] args) {
        System.out.println("given a range of numbers from 2 to the given number - 1,\n" +
                "the given number is a prime number if no number in the range can divide it");
        System.out.println("For [2, 3, 4, 5], it's " + new Primes().isPrimeFunctionalStyle(6)
                + " using functional style");
        System.out.println("For [2, 3, 4, 5], it's " + new Primes().isPrimeImperativeStyle(6)
                + " using imperativel style");
    }
}
