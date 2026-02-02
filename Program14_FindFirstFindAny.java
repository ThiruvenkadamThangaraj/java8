import java.util.*;

// findFirst and findAny examples
public class Program14_FindFirstFindAny {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        
        System.out.println("Numbers: " + numbers);
        
        Optional<Integer> first = numbers.stream()
                .filter(n -> n > 5)
                .findFirst();
        first.ifPresent(n -> System.out.println("First element > 5: " + n));
        
        Optional<Integer> any = numbers.stream()
                .filter(n -> n > 5)
                .findAny();
        any.ifPresent(n -> System.out.println("Any element > 5: " + n));
    }
}
