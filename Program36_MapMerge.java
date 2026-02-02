import java.util.*;

// Map merge operation in Java 8
public class Program36_MapMerge {
    public static void main(String[] args) {
        Map<String, Integer> map1 = new HashMap<>();
        map1.put("apple", 10);
        map1.put("banana", 20);
        
        System.out.println("Initial map: " + map1);
        
        // Merge - if key exists, combine values
        map1.merge("apple", 5, Integer::sum);
        System.out.println("After merging apple +5: " + map1);
        
        map1.merge("cherry", 15, Integer::sum);
        System.out.println("After adding cherry: " + map1);
        
        // Use in loop
        List<String> fruits = Arrays.asList("apple", "banana", "apple", "cherry", "banana");
        Map<String, Integer> counter = new HashMap<>();
        
        fruits.forEach(fruit -> counter.merge(fruit, 1, Integer::sum));
        System.out.println("\nFrequency counter: " + counter);
    }
}
