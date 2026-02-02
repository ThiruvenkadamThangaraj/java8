import java.util.*;

// Find maximum and minimum value in a list
public class Program03_MaxMinValue {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(5, 3, 9, 1, 7, 2, 8, 4, 6);
        
        System.out.println("Numbers: " + numbers);
        
        // Find maximum
        Optional<Integer> max = numbers.stream()
                .max(Integer::compareTo);
        max.ifPresent(m -> System.out.println("Maximum: " + m));
        
        // Find minimum
        Optional<Integer> min = numbers.stream()
                .min(Integer::compareTo);
        min.ifPresent(m -> System.out.println("Minimum: " + m));
    }
}
