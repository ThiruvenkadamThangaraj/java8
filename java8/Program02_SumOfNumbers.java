import java.util.*;

// Calculate sum of all numbers using reduce
public class Program02_SumOfNumbers {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        
        System.out.println("Numbers: " + numbers);
        
        // Method 1: Using reduce
        int sum = numbers.stream()
                .reduce(0, Integer::sum);
        System.out.println("Sum using reduce: " + sum);
        
        // Method 2: Using mapToInt and sum
        int sum2 = numbers.stream()
                .mapToInt(Integer::intValue)
                .sum();
        System.out.println("Sum using mapToInt: " + sum2);
    }
}
