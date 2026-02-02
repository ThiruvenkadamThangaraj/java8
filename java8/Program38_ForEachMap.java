import java.util.*;

// forEach on Map
public class Program38_ForEachMap {
    public static void main(String[] args) {
        Map<String, Integer> scores = new HashMap<>();
        scores.put("Alice", 95);
        scores.put("Bob", 87);
        scores.put("Charlie", 92);
        
        System.out.println("Scores:");
        scores.forEach((name, score) -> 
            System.out.println(name + ": " + score));
        
        // Filter and process
        System.out.println("\nHigh scorers (>90):");
        scores.entrySet().stream()
                .filter(entry -> entry.getValue() > 90)
                .forEach(entry -> System.out.println(entry.getKey() + ": " + entry.getValue()));
    }
}
