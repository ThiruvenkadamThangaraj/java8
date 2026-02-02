import java.util.*;
import java.util.stream.Collectors;

// Capitalize first letter of each word
public class String13_CapitalizeWords {
    public static void main(String[] args) {
        String text = "hello world java programming";
        System.out.println("Original: " + text);
        
        String capitalized = Arrays.stream(text.split(" "))
                .map(word -> word.substring(0, 1).toUpperCase() + word.substring(1))
                .collect(Collectors.joining(" "));
        
        System.out.println("Capitalized: " + capitalized);
        
        // Alternative method
        String capitalized2 = Arrays.stream(text.split(" "))
                .map(word -> Character.toUpperCase(word.charAt(0)) + word.substring(1))
                .collect(Collectors.joining(" "));
        
        System.out.println("Alternative: " + capitalized2);
    }
}
