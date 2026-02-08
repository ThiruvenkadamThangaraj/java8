import java.util.Arrays;
import java.util.stream.IntStream;

// IntStream range operations
public class Program35_RangeOperations {
    public static void main(String[] args) {
        // range (exclusive end)
        System.out.println("Range 1 to 5 (exclusive):");
        IntStream.range(1, 5).forEach(System.out::println);
        
        // rangeClosed (inclusive end)
        System.out.println("\nRangeClosed 1 to 5 (inclusive):");
        IntStream.rangeClosed(1, 5).forEach(System.out::println);
        
        // Sum of range
        int sum = IntStream.rangeClosed(1, 10).sum();
        System.out.println("\nSum of 1 to 10: " + sum);
        
        // Generate array
        int[] array = IntStream.range(0, 5).toArray();
        System.out.println("\nGenerated array: " + Arrays.toString(array));
    }
}
