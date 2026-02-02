import java.util.*;

// Collectors.teeing() - Java 12+ but showing the concept
public class Program43_Teeing {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        
        // Separate approach for Java 8
        int sum = numbers.stream().mapToInt(Integer::intValue).sum();
        long count = numbers.stream().count();
        double average = (double) sum / count;
        
        System.out.println("Numbers: " + numbers);
        System.out.println("Sum: " + sum);
        System.out.println("Count: " + count);
        System.out.println("Average: " + average);
    }
}
