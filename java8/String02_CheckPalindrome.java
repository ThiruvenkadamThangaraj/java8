// Check if a string is palindrome
public class String02_CheckPalindrome {
    public static void main(String[] args) {
        String[] words = {"radar", "hello", "level", "world", "madam"};
        
        for (String word : words) {
            boolean isPalindrome = word.equals(new StringBuilder(word).reverse().toString());
            System.out.println(word + " is palindrome? " + isPalindrome);
        }
        
        // Ignore case
        String text = "Racecar";
        boolean isPalindrome = text.equalsIgnoreCase(new StringBuilder(text).reverse().toString());
        System.out.println("\n" + text + " is palindrome (ignore case)? " + isPalindrome);
    }
}
