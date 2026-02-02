import java.util.*;
import java.util.stream.Collectors;

// Handle null values in streams
public class Program33_NullSafeStream {
    public static void main(String[] args) {
        List<String> words = Arrays.asList("apple", null, "banana", null, "cherry");
        
        System.out.println("Original (with nulls): " + words);
        
        List<String> nonNullWords = words.stream()
                .filter(Objects::nonNull)
                .collect(Collectors.toList());
        
        System.out.println("Without nulls: " + nonNullWords);
        
        List<String> upperCase = words.stream()
                .filter(Objects::nonNull)
                .map(String::toUpperCase)
                .collect(Collectors.toList());
        
        System.out.println("Uppercase: " + upperCase);
    }
}
