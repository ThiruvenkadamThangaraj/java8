import java.util.*;
import java.util.stream.Collectors;

// Flatten a list of lists using flatMap
public class Program10_FlatMapExample {
    public static void main(String[] args) {
        List<List<Integer>> nestedList = Arrays.asList(
            Arrays.asList(1, 2, 3),
            Arrays.asList(4, 5),
            Arrays.asList(6, 7, 8, 9)
        );
        
        System.out.println("Nested list: " + nestedList);
        
        List<Integer> flatList = nestedList.stream()
                .flatMap(List::stream)
                .collect(Collectors.toList());
        
        System.out.println("Flattened list: " + flatList);
    }
}
