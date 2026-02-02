import java.util.*;
import java.util.stream.Collectors;

// takeWhile and dropWhile concept (Java 9+, shown with filter)
public class Program45_TakeWhileDropWhile {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        
        System.out.println("Original: " + numbers);
        
        // Simulating takeWhile with filter (not exactly the same)
        System.out.println("\nElements less than 6:");
        List<Integer> lessThan6 = numbers.stream()
                .filter(n -> n < 6)
                .collect(Collectors.toList());
        System.out.println(lessThan6);
        
        // Simulating dropWhile
        System.out.println("\nElements from first >= 5:");
        boolean[] found = {false};
        List<Integer> fromFive = numbers.stream()
                .filter(n -> {
                    if (n >= 5) found[0] = true;
                    return found[0];
                })
                .collect(Collectors.toList());
        System.out.println(fromFive);
    }
}
