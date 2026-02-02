import java.util.*;

// Find longest word in a string
public class String10_LongestWord {
    public static void main(String[] args) {
        String text = "The quick brown fox jumps over the lazy dog";
        System.out.println("Text: " + text);
        
        Optional<String> longest = Arrays.stream(text.split(" "))
                .max(Comparator.comparing(String::length));
        
        longest.ifPresent(word -> 
            System.out.println("Longest word: " + word + " (length: " + word.length() + ")"));
        
        // Find all words with maximum length
        int maxLength = Arrays.stream(text.split(" "))
                .mapToInt(String::length)
                .max()
                .orElse(0);
        
        System.out.println("\nAll longest words:");
        Arrays.stream(text.split(" "))
                .filter(word -> word.length() == maxLength)
                .forEach(System.out::println);
    }
}
