import java.util.Collections;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class StringReverse {
    public static void main(String[] args) {
        String input = "Hello";
        System.out.println("Original: " + input);
        System.out.println("Reversed: " + reverseString(input));
        System.out.println("Reversed (Method 2): " + reverseStringMethod2(input));
    }
    
    // Method 1: Using IntStream with range
    private static String reverseString(String input) {
        return IntStream.range(0, input.length())
                .map(i -> input.charAt(input.length() - i - 1))
                .collect(StringBuilder::new, 
                        (sb, c) -> sb.append((char) c), 
                        StringBuilder::append)
                .toString();
    }
    
    // Method 2: Using Stream with split
    private static String reverseStringMethod2(String input) {
        return input.chars()
                .boxed()
                .sorted(Collections.reverseOrder())
                .map(c -> String.valueOf((char) c.intValue()))
                .collect(Collectors.joining());
    }
}
