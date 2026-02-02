import java.util.*;
import java.util.stream.Collectors;

// Square each number in the list
public class Program09_SquareNumbers {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        
        System.out.println("Original numbers: " + numbers);
        
        List<Integer> squares = numbers.stream()
                .map(n -> n * n)
                .collect(Collectors.toList());
        
        System.out.println("Squared numbers: " + squares);
    }
}
