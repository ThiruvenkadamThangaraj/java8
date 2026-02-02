import java.util.stream.Collectors;
import java.util.stream.IntStream;

// Reverse a string using streams
public class Program28_ReverseString {
    public static void main(String[] args) {
        String text = "Hello World";
        
        System.out.println("Original: " + text);
        
        String reversed = IntStream.range(0, text.length())
                .map(i -> text.charAt(text.length() - 1 - i))
                .mapToObj(c -> String.valueOf((char) c))
                .collect(Collectors.joining());
        
        System.out.println("Reversed: " + reversed);
    }
}
