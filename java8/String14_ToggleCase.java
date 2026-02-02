import java.util.stream.Collectors;

// Toggle case of each character
public class String14_ToggleCase {
    public static void main(String[] args) {
        String text = "Hello World";
        System.out.println("Original: " + text);
        
        String toggled = text.chars()
                .mapToObj(c -> {
                    char ch = (char) c;
                    if (Character.isUpperCase(ch)) {
                        return Character.toLowerCase(ch);
                    } else if (Character.isLowerCase(ch)) {
                        return Character.toUpperCase(ch);
                    }
                    return ch;
                })
                .map(String::valueOf)
                .collect(Collectors.joining());
        
        System.out.println("Toggled: " + toggled);
    }
}
