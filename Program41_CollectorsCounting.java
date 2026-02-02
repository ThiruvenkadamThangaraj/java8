import java.util.*;
import java.util.stream.Collectors;

// Collectors.counting() example
public class Program41_CollectorsCounting {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Alice", "Bob", "Andrew", "Charlie", "Amanda");
        
        Map<Character, Long> countByFirstLetter = names.stream()
                .collect(Collectors.groupingBy(
                    name -> name.charAt(0),
                    Collectors.counting()
                ));
        
        System.out.println("Count by first letter:");
        countByFirstLetter.forEach((letter, count) -> 
            System.out.println(letter + ": " + count));
    }
}
