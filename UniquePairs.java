import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class UniquePairs {

    private static class Pair {
        private final int a;
        private final int b;

        Pair(int a, int b) {
            this.a = a;
            this.b = b;
        }

        @Override
        public String toString() {
            return "(" + a + "," + b + ")";
        }
    }

    public static void main(String[] args) {
        List<Pair> pairs = new ArrayList<>();
        pairs.add(new Pair(72, 2));
        pairs.add(new Pair(75, 5));
        pairs.add(new Pair(77, 7));
        pairs.add(new Pair(85, 5));

        Map<Integer, Integer> countA = new LinkedHashMap<>();
        Map<Integer, Integer> countB = new LinkedHashMap<>();
        pairs.stream().forEach(pair -> {
            countA.put(pair.a, countA.getOrDefault(pair.a, 0) + 1);
            countB.put(pair.b, countB.getOrDefault(pair.b, 0) + 1);
        });

        List<Integer> uniqueA = countA.entrySet().stream()
                .filter(entry -> entry.getValue() == 1)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());

        List<Integer> uniqueB = countB.entrySet().stream()
                .filter(entry -> entry.getValue() == 1)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());

        System.out.println("Pairs: " + pairs);
        System.out.println("Unique A values: " + uniqueA);
        System.out.println("Unique B values: " + uniqueB);
    }
}
