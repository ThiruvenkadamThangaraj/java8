import java.util.*;
import java.util.stream.Collectors;

// Use peek for debugging stream operations
public class Program17_PeekExample {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        
        System.out.println("Original: " + numbers);
        System.out.println("\nProcessing with peek:");
        
        List<Integer> result = numbers.stream()
                .peek(n -> System.out.println("Before map: " + n))
                .map(n -> n * 2)
                .peek(n -> System.out.println("After map: " + n))
                .filter(n -> n > 5)
                .peek(n -> System.out.println("After filter: " + n))
                .collect(Collectors.toList());
        
        System.out.println("\nFinal result: " + result);
    }
}
