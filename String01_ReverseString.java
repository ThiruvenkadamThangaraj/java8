// Reverse a string using different methods
public class String01_ReverseString {
    public static void main(String[] args) {
        String text = "Hello World";
        System.out.println("Original: " + text);
        
        // Method 1: Using StringBuilder
        String reversed1 = new StringBuilder(text).reverse().toString();
        System.out.println("Method 1 (StringBuilder): " + reversed1);
        
        // Method 2: Using Stream
        String reversed2 = text.chars()
                .mapToObj(c -> (char) c)
                .reduce("", (s, c) -> c + s, (s1, s2) -> s2 + s1);
        System.out.println("Method 2 (Stream): " + reversed2);
        
        // Method 3: Manual iteration
        String reversed3 = "";
        for (int i = text.length() - 1; i >= 0; i--) {
            reversed3 += text.charAt(i);
        }
        System.out.println("Method 3 (Loop): " + reversed3);
    }
}
