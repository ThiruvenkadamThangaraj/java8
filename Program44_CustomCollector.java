import java.util.*;
import java.util.stream.Collectors;

// Custom collector example
public class Program44_CustomCollector {
    public static void main(String[] args) {
        List<String> words = Arrays.asList("apple", "banana", "cherry", "date");
        
        // Collecting to custom format
        String result = words.stream()
                .collect(Collectors.collectingAndThen(
                    Collectors.joining(", "),
                    s -> "[" + s + "]"
                ));
        
        System.out.println("Custom format: " + result);
        
        // Get length statistics
        IntSummaryStatistics lengthStats = words.stream()
                .collect(Collectors.summarizingInt(String::length));
        
        System.out.println("\nLength statistics:");
        System.out.println("Average length: " + lengthStats.getAverage());
        System.out.println("Max length: " + lengthStats.getMax());
    }
}
