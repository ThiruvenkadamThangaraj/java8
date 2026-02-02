import java.util.*;

// Get summary statistics
public class Program19_SummaryStatistics {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        
        System.out.println("Numbers: " + numbers);
        
        IntSummaryStatistics stats = numbers.stream()
                .mapToInt(Integer::intValue)
                .summaryStatistics();
        
        System.out.println("\nStatistics:");
        System.out.println("Count: " + stats.getCount());
        System.out.println("Sum: " + stats.getSum());
        System.out.println("Min: " + stats.getMin());
        System.out.println("Max: " + stats.getMax());
        System.out.println("Average: " + stats.getAverage());
    }
}
