import java.util.*;

// removeIf operation
public class Program40_RemoveIf {
    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));
        
        System.out.println("Original: " + numbers);
        
        // Remove all even numbers
        numbers.removeIf(n -> n % 2 == 0);
        System.out.println("After removing even: " + numbers);
        
        // String example
        List<String> names = new ArrayList<>(Arrays.asList("Alice", "Bob", "Andrew", "Charlie"));
        System.out.println("\nOriginal names: " + names);
        
        names.removeIf(name -> name.startsWith("A"));
        System.out.println("After removing names starting with 'A': " + names);
    }
}
