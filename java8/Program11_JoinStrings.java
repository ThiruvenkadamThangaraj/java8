import java.util.*;
import java.util.stream.Collectors;

// Join strings with delimiter
public class Program11_JoinStrings {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Alice", "Bob", "Charlie", "David");
        
        System.out.println("Names: " + names);
        
        String joined = names.stream()
                .collect(Collectors.joining(", "));
        System.out.println("Joined: " + joined);
        
        String joinedWithPrefixSuffix = names.stream()
                .collect(Collectors.joining(", ", "[", "]"));
        System.out.println("With prefix/suffix: " + joinedWithPrefixSuffix);
    }
}
