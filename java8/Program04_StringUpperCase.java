import java.util.*;
import java.util.stream.Collectors;

// Convert all strings to uppercase
public class Program04_StringUpperCase {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("alice", "bob", "charlie", "david");
        
        System.out.println("Original names: " + names);
        
        List<String> upperNames = names.stream()
                .map(String::toUpperCase)
                .collect(Collectors.toList());
        
        System.out.println("Uppercase names: " + upperNames);
    }
}
