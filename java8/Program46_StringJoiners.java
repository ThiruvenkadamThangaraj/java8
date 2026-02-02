import java.util.*;

// StringJoiner class
public class Program46_StringJoiners {
    public static void main(String[] args) {
        StringJoiner joiner1 = new StringJoiner(", ");
        joiner1.add("Alice").add("Bob").add("Charlie");
        System.out.println("Simple join: " + joiner1);
        
        StringJoiner joiner2 = new StringJoiner(", ", "[", "]");
        joiner2.add("Apple").add("Banana").add("Cherry");
        System.out.println("With prefix/suffix: " + joiner2);
        
        // String.join
        String joined = String.join(" | ", "One", "Two", "Three");
        System.out.println("String.join: " + joined);
        
        List<String> names = Arrays.asList("Alice", "Bob", "Charlie");
        String nameString = String.join(", ", names);
        System.out.println("From list: " + nameString);
    }
}
