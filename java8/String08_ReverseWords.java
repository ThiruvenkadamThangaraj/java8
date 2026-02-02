import java.util.*;
import java.util.stream.Collectors;

// Reverse words in a string
public class String08_ReverseWords {
    public static void main(String[] args) {
        String text = "Hello World Java Programming";
        System.out.println("Original: " + text);
        
        // Method 1: Reverse order of words
        String reversed = Arrays.stream(text.split(" "))
                .collect(Collectors.collectingAndThen(
                    Collectors.toList(),
                    list -> {
                        Collections.reverse(list);
                        return list.stream();
                    }
                ))
                .collect(Collectors.joining(" "));
        System.out.println("Reversed word order: " + reversed);
        
        // Method 2: Reverse each word individually
        String reversedWords = Arrays.stream(text.split(" "))
                .map(word -> new StringBuilder(word).reverse().toString())
                .collect(Collectors.joining(" "));
        System.out.println("Each word reversed: " + reversedWords);
    }
}
