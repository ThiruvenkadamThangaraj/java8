import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

// Find first non-repeating character
public class String07_FirstNonRepeatingChar {
    public static void main(String[] args) {
        String text = "programming";
        System.out.println("Text: " + text);
        
        Map<Character, Long> frequency = text.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(
                    Function.identity(),
                    LinkedHashMap::new,
                    Collectors.counting()
                ));
        
        Optional<Character> firstNonRepeating = frequency.entrySet().stream()
                .filter(entry -> entry.getValue() == 1)
                .map(Map.Entry::getKey)
                .findFirst();
        
        firstNonRepeating.ifPresentOrElse(
            ch -> System.out.println("First non-repeating character: " + ch),
            () -> System.out.println("No non-repeating character found")
        );
    }
}
