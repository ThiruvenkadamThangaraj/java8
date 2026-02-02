import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

// Combine multiple lists
public class Program31_CombineLists {
    public static void main(String[] args) {
        List<Integer> list1 = Arrays.asList(1, 2, 3);
        List<Integer> list2 = Arrays.asList(4, 5, 6);
        List<Integer> list3 = Arrays.asList(7, 8, 9);
        
        System.out.println("List 1: " + list1);
        System.out.println("List 2: " + list2);
        System.out.println("List 3: " + list3);
        
        List<Integer> combined = Stream.of(list1, list2, list3)
                .flatMap(List::stream)
                .collect(Collectors.toList());
        
        System.out.println("Combined: " + combined);
    }
}
