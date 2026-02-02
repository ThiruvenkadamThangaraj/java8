import java.util.stream.Collectors;

// Sort characters in a string
public class String18_SortCharacters {
    public static void main(String[] args) {
        String text = "programming";
        System.out.println("Original: " + text);
        
        // Sort ascending
        String sortedAsc = text.chars()
                .sorted()
                .mapToObj(c -> String.valueOf((char) c))
                .collect(Collectors.joining());
        System.out.println("Sorted (ascending): " + sortedAsc);
        
        // Sort descending
        String sortedDesc = text.chars()
                .boxed()
                .sorted((a, b) -> b - a)
                .map(c -> String.valueOf((char) c.intValue()))
                .collect(Collectors.joining());
        System.out.println("Sorted (descending): " + sortedDesc);
    }
}
