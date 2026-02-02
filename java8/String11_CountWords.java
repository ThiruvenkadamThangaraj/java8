import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

// Count words in a string
public class String11_CountWords {
    public static void main(String[] args) {
        String text = "Hello World! Java Programming is fun. Java is powerful.";
        System.out.println("Text: " + text);
        
        // Count total words
        long wordCount = Arrays.stream(text.split("\\s+"))
                .filter(word -> !word.isEmpty())
                .count();
        System.out.println("Total words: " + wordCount);
        
        // Count unique words
        long uniqueWords = Arrays.stream(text.toLowerCase().split("\\W+"))
                .filter(word -> !word.isEmpty())
                .distinct()
                .count();
        System.out.println("Unique words: " + uniqueWords);
        
        // Word frequency
        System.out.println("\nWord frequency:");
        Arrays.stream(texCollectors.groupingBy(
                    Function.identity(),
                    ream.Collectors.groupingBy(
                    java.util.function.Function.identity(),
                    java.util.stream.Collectors.counting()
                ))
                .forEach((word, count) -> System.out.println(word + ": " + count));
    }
}
