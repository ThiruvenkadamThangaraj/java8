import java.util.*;

// replaceAll in List and Map
public class Program39_ReplaceAll {
    public static void main(String[] args) {
        // List replaceAll
        List<String> names = new ArrayList<>(Arrays.asList("alice", "bob", "charlie"));
        System.out.println("Original: " + names);
        
        names.replaceAll(String::toUpperCase);
        System.out.println("After replaceAll: " + names);
        
        // Map replaceAll
        Map<String, Integer> scores = new HashMap<>();
        scores.put("Alice", 85);
        scores.put("Bob", 90);
        scores.put("Charlie", 78);
        
        System.out.println("\nOriginal scores: " + scores);
        
        scores.replaceAll((name, score) -> score + 5);
        System.out.println("After adding 5 to all: " + scores);
    }
}
