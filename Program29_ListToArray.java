import java.util.*;

// Convert list to array
public class Program29_ListToArray {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Alice", "Bob", "Charlie");
        
        System.out.println("List: " + names);
        
        // Method 1: toArray with generator
        String[] array1 = names.stream()
                .toArray(String[]::new);
        System.out.println("Array: " + Arrays.toString(array1));
        
        // Method 2: Integer array
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        Integer[] array2 = numbers.toArray(new Integer[0]);
        System.out.println("Numbers array: " + Arrays.toString(array2));
    }
}
