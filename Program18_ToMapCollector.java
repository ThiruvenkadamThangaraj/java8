import java.util.*;
import java.util.stream.Collectors;

// Convert list to map
public class Program18_ToMapCollector {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Alice", "Bob", "Charlie");
        
        System.out.println("Names: " + names);
        
        Map<String, Integer> nameToLength = names.stream()
                .collect(Collectors.toMap(
                    name -> name,
                    String::length
                ));
        
        System.out.println("Name to length map: " + nameToLength);
    }
}
