import java.util.*;

// Find second highest number
public class Program27_SecondHighest {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(5, 9, 11, 2, 8, 21, 1);
        
        System.out.println("Numbers: " + numbers);
        
        Optional<Integer> secondHighest = numbers.stream()
                .sorted(Comparator.reverseOrder())
                .skip(1)
                .findFirst();
        
        secondHighest.ifPresent(n -> 
            System.out.println("Second highest: " + n));
    }
}
