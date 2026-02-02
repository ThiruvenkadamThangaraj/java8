import java.util.stream.Collectors;

// Convert string to character array and process
public class Program25_StringToCharArray {
    public static void main(String[] args) {
        String text = "Hello World";
        
        System.out.println("Original: " + text);
        
        // Get unique characters
        String uniqueChars = text.chars()
                .distinct()
                .mapToObj(c -> String.valueOf((char) c))
                .collect(Collectors.joining());
        System.out.println("Unique characters: " + uniqueChars);
        
        // Count vowels
        long vowelCount = text.toLowerCase().chars()
                .filter(c -> "aeiou".indexOf(c) != -1)
                .count();
        System.out.println("Vowel count: " + vowelCount);
    }
}
