import java.util.*;
import java.util.stream.Collectors;

// Method reference examples
public class Program22_MethodReference {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("alice", "bob", "charlie");
        
        // Static method reference
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        numbers.forEach(System.out::println);
        
        // Instance method reference
        System.out.println("\nUppercase names:");
        List<String> upperNames = names.stream()
                .map(String::toUpperCase)
                .collect(Collectors.toList());
        upperNames.forEach(System.out::println);
        
        // Constructor reference
        System.out.println("\nString lengths using constructor:");
        List<String> lengths = names.stream()
                .map(String::length)
                .map(String::valueOf)
                .collect(Collectors.toList());
        System.out.println(lengths);
    }
}
