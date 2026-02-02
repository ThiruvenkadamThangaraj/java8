import java.util.*;
import java.util.stream.Collectors;

// Sort strings by length
public class Program32_SortByLength {
    public static void main(String[] args) {
        List<String> words = Arrays.asList("apple", "pie", "banana", "cat", "elephant");
        
        System.out.println("Original: " + words);
        
        List<String> sortedByLength = words.stream()
                .sorted(Comparator.comparing(String::length))
                .collect(Collectors.toList());
        
        System.out.println("Sorted by length: " + sortedByLength);
        
        List<String> sortedByLengthDesc = words.stream()
                .sorted(Comparator.comparing(String::length).reversed())
                .collect(Collectors.toList());
        
        System.out.println("Sorted by length (desc): " + sortedByLengthDesc);
    }
}
