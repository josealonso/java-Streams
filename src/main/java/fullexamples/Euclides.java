package fullexamples;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

// Euclid's algorithm
public class Euclides {

    private String getTriple(int m, int n) {
        int a = m * m - n * n;
        int b = 2 * m * n;
        int c = m * m + n * n;

        return String.format("%d %d %d", a, b, c);
    }

    private List<String> computeTriples(int numOfValues) {
        // if you have a one to one function, use map
        // if you have a one to many function, use flatMap
        return Stream.iterate(2, e -> e + 1)
                .flatMap(m -> IntStream.range(1, m)
                        .mapToObj(n -> getTriple(m, n)))
                .limit(numOfValues)
                .collect(Collectors.toList());
    }


    /**
     * @param numOfPrimes
     * @return A list of prime numbers
     */
    public List<Integer> primesList(int numOfPrimes) {
        return Stream.iterate(3, n -> n + 1)
                .filter(n -> n % 2 == 0)
                .limit(numOfPrimes)
                .collect(Collectors.toList());
    }

    public Predicate<Integer> isPrime = (n -> n % 2 == 0);

    /**
     * @param firstPrime
     * @param numOfPrimes
     * @return The summation of the square roots for all the prime numbers in the list.
     */
    public double sumOfSqrtOfKPrimesStartingWithN(int firstPrime, int numOfPrimes) {
        return Stream.iterate(firstPrime, n -> n + 1)
                .filter(isPrime)                                        // .filter(n -> n % 2 == 0)
                .limit(numOfPrimes)
                .mapToDouble(Math::sqrt)
                .sum();
    }

    public static void main(String[] args) {
        System.out.println("The summation of the square roots for the first 20 prime numbers is: "
                + new Euclides().sumOfSqrtOfKPrimesStartingWithN(3, 20));
    }
}
