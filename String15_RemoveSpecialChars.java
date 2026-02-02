// Remove special characters from string
public class String15_RemoveSpecialChars {
    public static void main(String[] args) {
        String text = "Hello@World#2024$Java!";
        System.out.println("Original: " + text);
        
        // Remove all non-alphanumeric
        String cleaned = text.replaceAll("[^a-zA-Z0-9]", "");
        System.out.println("Only alphanumeric: " + cleaned);
        
        // Keep only letters
        String onlyLetters = text.replaceAll("[^a-zA-Z]", "");
        System.out.println("Only letters: " + onlyLetters);
        
        // Keep only digits
        String onlyDigits = text.replaceAll("[^0-9]", "");
        System.out.println("Only digits: " + onlyDigits);
        
        // Keep letters and spaces
        String lettersAndSpaces = text.replaceAll("[^a-zA-Z\\s]", "");
        System.out.println("Letters and spaces: " + lettersAndSpaces);
    }
}
