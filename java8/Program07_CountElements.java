import java.util.*;

// Count elements in a stream
public class Program07_CountElements {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Alice", "Bob", "Charlie", "David", "Eve");
        
        System.out.println("Names: " + names);
        
        long count = names.stream().count();
        System.out.println("Total count: " + count);
        
        long countLongNames = names.stream()
                .filter(name -> name.length() > 4)
                .count();
        System.out.println("Names longer than 4 characters: " + countLongNames);
    }
}
