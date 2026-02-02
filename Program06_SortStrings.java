import java.util.*;
import java.util.stream.Collectors;

// Sort strings in natural and reverse order
public class Program06_SortStrings {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Charlie", "Alice", "Bob", "David", "Eve");
        
        System.out.println("Original: " + names);
        
        // Natural order
        List<String> sortedAsc = names.stream()
                .sorted()
                .collect(Collectors.toList());
        System.out.println("Sorted (ascending): " + sortedAsc);
        
        // Reverse order
        List<String> sortedDesc = names.stream()
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());
        System.out.println("Sorted (descending): " + sortedDesc);
    }
}
