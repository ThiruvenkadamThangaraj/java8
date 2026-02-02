// Count occurrences of character or substring
public class String17_CountOccurrences {
    public static void main(String[] args) {
        String text = "Hello World! Hello Java!";
        System.out.println("Text: " + text);
        
        // Count character 'l'
        long charCount = text.toLowerCase().chars()
                .filter(c -> c == 'l')
                .count();
        System.out.println("Character 'l' appears: " + charCount + " times");
        
        // Count substring "Hello"
        String substring = "Hello";
        int count = 0;
        int index = 0;
        while ((index = text.indexOf(substring, index)) != -1) {
            count++;
            index += substring.length();
        }
        System.out.println("Substring '" + substring + "' appears: " + count + " times");
        
        // Using split method
        int count2 = text.split(substring, -1).length - 1;
        System.out.println("Using split method: " + count2 + " times");
    }
}
