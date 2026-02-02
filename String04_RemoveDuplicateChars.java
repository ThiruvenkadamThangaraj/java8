import java.util.stream.Collectors;

// Remove duplicate characters from string
public class String04_RemoveDuplicateChars {
    public static void main(String[] args) {
        String text = "programming";
        System.out.println("Original: " + text);
        
        // Method 1: Using distinct
        String unique = text.chars()
                .distinct()
                .mapToObj(c -> String.valueOf((char) c))
                .collect(Collectors.joining());
        System.out.println("Unique characters: " + unique);
        
        // Method 2: Using LinkedHashSet
        String unique2 = text.chars()
                .mapToObj(c -> (char) c)
                .distinct()
                .map(String::valueOf)
                .collect(Collectors.joining());
        System.out.println("Using LinkedHashSet approach: " + unique2);
    }
}
