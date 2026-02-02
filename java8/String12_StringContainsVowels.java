// Check if string contains vowels
public class String12_StringContainsVowels {
    public static void main(String[] args) {
        String[] words = {"Hello", "Sky", "Rhythm", "Fly", "Programming"};
        
        for (String word : words) {
            boolean hasVowels = word.toLowerCase().chars()
                    .anyMatch(c -> "aeiou".indexOf(c) != -1);
            
            System.out.println(word + " contains vowels? " + hasVowels);
        }
        
        // Check for all vowels present
        System.out.println("\n--- Check if string contains all vowels ---");
        String text = "Education";
        boolean hasAllVowels = "aeiou".chars()
                .allMatch(vowel -> text.toLowerCase().indexOf(vowel) != -1);
        System.out.println(text + " contains all vowels? " + hasAllVowels);
    }
}
