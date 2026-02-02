import java.util.*;
import java.util.stream.Collectors;

// Group elements by a property
public class Program15_GroupingBy {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Alice", "Bob", "Andrew", "Charlie", "Amanda", "Brian");
        
        System.out.println("Names: " + names);
        
        Map<Character, List<String>> groupedByFirstLetter = names.stream()
                .collect(Collectors.groupingBy(name -> name.charAt(0)));
        
        System.out.println("\nGrouped by first letter:");
        groupedByFirstLetter.forEach((letter, nameList) -> 
            System.out.println(letter + ": " + nameList));
    }
}
