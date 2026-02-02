import java.util.*;

// anyMatch, allMatch, noneMatch examples
public class Program13_AnyAllNoneMatch {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(2, 4, 6, 8, 10);
        
        System.out.println("Numbers: " + numbers);
        
        boolean anyGreaterThan5 = numbers.stream()
                .anyMatch(n -> n > 5);
        System.out.println("Any number > 5? " + anyGreaterThan5);
        
        boolean allEven = numbers.stream()
                .allMatch(n -> n % 2 == 0);
        System.out.println("All even? " + allEven);
        
        boolean noneNegative = numbers.stream()
                .noneMatch(n -> n < 0);
        System.out.println("None negative? " + noneNegative);
    }
}
