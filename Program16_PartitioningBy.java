import java.util.*;
import java.util.stream.Collectors;

// Partition elements into two groups
public class Program16_PartitioningBy {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        
        System.out.println("Numbers: " + numbers);
        
        Map<Boolean, List<Integer>> partitioned = numbers.stream()
                .collect(Collectors.partitioningBy(n -> n % 2 == 0));
        
        System.out.println("Even numbers: " + partitioned.get(true));
        System.out.println("Odd numbers: " + partitioned.get(false));
    }
}
