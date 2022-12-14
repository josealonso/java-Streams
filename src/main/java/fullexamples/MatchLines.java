package fullexamples;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

/*
        Imperative style: we tell what to do and also how to do it.
        It's packed with accidental complexity.
        Declarative style has less accidental complexity.
        Functional style = Declarative style + higher-order functions.
        You can pass functions around, not only objects.
        Functional pipeline:

        - data -> f1 -> f2 -> f3 -> ...

        Functional style = Functional composition + lazy evaluation

 FP relies on lazy evaluation for performance.
 Lazy evaluation relies on immutability for correctness
 So, FP relies on immutability.


 Two benefits of immutability:
 1.- Easier to parallelize
 2.- Lazy evaluation
*/


public class MatchLines {

    public int numberOfLinesMeetingAGivenCriteria(String fileName, String searchWord) throws IOException {

        /* BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName));
        bufferedReader.lines();
        Too verbose, it was the only way to do it before Java 1.8 */

        // Let us think of this as a functional pipeline
        // 1.- open the file
        // 2.- for each line check if the searchWord appears
        // 3.- count number of lines that meet the above criteria

        return (int) Files.lines(Paths.get(fileName))
                .filter(line -> line.contains(searchWord))
                .count();  // It is a terminal operation, reduce comes in many flavours
    }


    public static void main(String[] args) {
        final String SEARCH_WORD = "dependency";
        int occurrences = 0;
        try {
            occurrences = new MatchLines().numberOfLinesMeetingAGivenCriteria("pom.xml", SEARCH_WORD);
        } catch (IOException unimportant) {
            throw new RuntimeException(unimportant);
        }
        StringBuilder message = new StringBuilder(40);
        message.append("The \"").append(SEARCH_WORD).append( "\" word appears ").append(occurrences).append(" times");
        // System.out.println("The " + SEARCH_WORD + " word appears " + occurrences + " times");
        System.out.println(message);
    }
}
