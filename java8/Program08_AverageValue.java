import java.util.*;

// Calculate average of numbers
public class Program08_AverageValue {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(10, 20, 30, 40, 50);
        
        System.out.println("Numbers: " + numbers);
        
        OptionalDouble average = numbers.stream()
                .mapToInt(Integer::intValue)
                .average();
        
        average.ifPresent(avg -> System.out.println("Average: " + avg));
    }
}
