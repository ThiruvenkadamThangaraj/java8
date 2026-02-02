import java.util.*;

// Advanced reduce operations
public class Program34_ReduceExample {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        
        System.out.println("Numbers: " + numbers);
        
        // Sum
        int sum = numbers.stream()
                .reduce(0, Integer::sum);
        System.out.println("Sum: " + sum);
        
        // Product
        int product = numbers.stream()
                .reduce(1, (a, b) -> a * b);
        System.out.println("Product: " + product);
        
        // Concatenation
        List<String> words = Arrays.asList("Hello", " ", "World");
        String sentence = words.stream()
                .reduce("", String::concat);
        System.out.println("Concatenated: '" + sentence + "'");
    }
}
