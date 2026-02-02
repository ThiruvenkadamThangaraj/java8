import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

// Find duplicate characters in a string
public class String05_FindDuplicateChars {
    public static void main(String[] args) {
        String text = "programming";
        System.out.println("Text: " + text);
        
        Map<Character, Long> charFrequency = text.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(
                    Function.identity(),
                    Collectors.counting()
                ));
        
        System.out.println("\nCharacter frequency:");
        charFrequency.forEach((ch, count) -> 
            System.out.println(ch + ": " + count));
        
        System.out.println("\nDuplicate characters:");
        charFrequency.entrySet().stream()
                .filter(entry -> entry.getValue() > 1)
                .forEach(entry -> 
                    System.out.println(entry.getKey() + " appears " + entry.getValue() + " times"));
    }
}
