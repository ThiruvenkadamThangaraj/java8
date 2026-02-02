import java.util.*;
import java.util.stream.Collectors;

// Filter strings that start with a specific letter
public class Program05_StartsWith {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Alice", "Bob", "Andrew", "Charlie", "Amanda");
        
        System.out.println("Original names: " + names);
        
        List<String> namesStartingWithA = names.stream()
                .filter(name -> name.startsWith("A"))
                .collect(Collectors.toList());
        
        System.out.println("Names starting with 'A': " + namesStartingWithA);
    }
}
