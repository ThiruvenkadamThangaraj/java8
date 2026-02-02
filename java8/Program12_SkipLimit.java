import java.util.*;
import java.util.stream.Collectors;

// Use skip and limit operations
public class Program12_SkipLimit {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        
        System.out.println("Original: " + numbers);
        
        List<Integer> first5 = numbers.stream()
                .limit(5)
                .collect(Collectors.toList());
        System.out.println("First 5: " + first5);
        
        List<Integer> skip5 = numbers.stream()
                .skip(5)
                .collect(Collectors.toList());
        System.out.println("Skip first 5: " + skip5);
        
        List<Integer> skip3Take4 = numbers.stream()
                .skip(3)
                .limit(4)
                .collect(Collectors.toList());
        System.out.println("Skip 3, take 4: " + skip3Take4);
    }
}
