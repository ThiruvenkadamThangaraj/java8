import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

// Create frequency map of elements
public class Program26_FrequencyMap {
    public static void main(String[] args) {
        List<String> words = Arrays.asList("apple", "banana", "apple", "cherry", "banana", "apple");
        
        System.out.println("Words: " + words);
        
        Map<String, Long> frequencyMap = words.stream()
                .collect(Collectors.groupingBy(
                    Function.identity(),
                    Collectors.counting()
                ));
        
        System.out.println("\nFrequency map:");
        frequencyMap.forEach((word, count) -> 
            System.out.println(word + ": " + count));
    }
}
