// Count vowels and consonants in a string
public class String03_CountVowelsConsonants {
    public static void main(String[] args) {
        String text = "Hello World";
        System.out.println("Text: " + text);
        
        long vowels = text.toLowerCase().chars()
                .filter(c -> "aeiou".indexOf(c) != -1)
                .count();
        
        long consonants = text.toLowerCase().chars()
                .filter(Character::isLetter)
                .filter(c -> "aeiou".indexOf(c) == -1)
                .count();
        
        System.out.println("Vowels: " + vowels);
        System.out.println("Consonants: " + consonants);
        
        // Show each vowel count
        "aeiou".chars().forEach(vowel -> {
            long count = text.toLowerCase().chars()
                    .filter(c -> c == vowel)
                    .count();
            if (count > 0) {
                System.out.println((char) vowel + ": " + count);
            }
        });
    }
}
