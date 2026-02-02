// Replace substring in a string
public class String19_ReplaceSubstring {
    public static void main(String[] args) {
        String text = "Hello World! Hello Java!";
        System.out.println("Original: " + text);
        
        // Replace first occurrence
        String replaced1 = text.replaceFirst("Hello", "Hi");
        System.out.println("Replace first: " + replaced1);
        
        // Replace all occurrences
        String replaced2 = text.replace("Hello", "Hi");
        System.out.println("Replace all: " + replaced2);
        
        // Replace using regex
        String replaced3 = text.replaceAll("Hello|World", "***");
        System.out.println("Replace with regex: " + replaced3);
        
        // Case insensitive replace
        String replaced4 = text.replaceAll("(?i)hello", "Hi");
        System.out.println("Case insensitive: " + replaced4);
    }
}
