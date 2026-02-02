import java.util.*;
import java.util.stream.Collectors;

// Filter even numbers from a list
public class Program01_FilterEvenNumbers {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        
        System.out.println("Original numbers: " + numbers);
        
        List<Integer> evenNumbers = numbers.stream()
                .filter(n -> n % 2 == 0)
                .collect(Collectors.toList());
        
        System.out.println("Even numbers: " + evenNumbers);
    }
}
