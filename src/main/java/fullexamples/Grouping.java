package fullexamples;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.groupingBy;

public class Grouping {

    public Map<Integer, List<String>> groupByScores(Map<String, Integer> scores) {
        return scores.keySet()
                .stream()
                .collect(groupingBy(scores::get));  // name -> score.get(name)
    }

    public static void main(String[] args) {
        Map<String, Integer> scores = new HashMap<>();
        scores.put("Manuela",5);
        scores.put("Bruno",6);
        scores.put("John",8);
        scores.put("Alice",6);
        scores.put("Susana",5);
        scores.put("Pedro",6);
        scores.put("Ambrosio",8);

        System.out.println("===========================");
        System.out.println("scores grouped by score value: ");
        System.out.println(new Grouping().groupByScores(scores));
    }
}
