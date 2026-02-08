import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class StringBasicsBundle {

    public static String reverseString(String input) {
        if (input == null) {
            return null;
        }
        return new StringBuilder(input).reverse().toString();
    }

    public static boolean isPalindrome(String input) {
        if (input == null) {
            return false;
        }
        int left = 0;
        int right = input.length() - 1;
        while (left < right) {
            if (input.charAt(left) != input.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public static int[] countVowelsAndConsonants(String input) {
        if (input == null) {
            return new int[] { 0, 0 };
        }

        String normalized = input.toLowerCase();
        long letters = normalized.chars()
                .filter(ch -> ch >= 'a' && ch <= 'z')
                .count();
        long vowels = normalized.chars()
                .filter(ch -> ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u')
                .count();
        long consonants = letters - vowels;
        return new int[] { (int) vowels, (int) consonants };
    }

    public static String removeDuplicateCharacters(String input) {
        if (input == null) {
            return null;
        }

        boolean[] seen = new boolean[256];
        StringBuilder result = new StringBuilder();
        input.chars()
                .filter(ch -> ch < 256)
                .forEach(ch -> {
                    if (!seen[ch]) {
                        seen[ch] = true;
                        result.append((char) ch);
                    }
                });

        return result.toString();
    }

    public static Character firstNonRepeatingCharStream(String input) {
        if (input == null || input.isEmpty()) {
            return null;
        }

        Map<Character, Long> counts = input.chars()
                .mapToObj(ch -> (char) ch)
                .collect(Collectors.groupingBy(
                        Function.identity(),
                        LinkedHashMap::new,
                        Collectors.counting()));

        return counts.entrySet().stream()
                .filter(entry -> entry.getValue() == 1L)
                .map(Map.Entry::getKey)
                .findFirst()
                .orElse(null);
    }

    public static void main(String[] args) {
        String input = "swiss";

        System.out.println("Reverse: " + reverseString(input));
        System.out.println("Palindrome: " + isPalindrome("malayalam"));

        int[] counts = countVowelsAndConsonants("Thiru");
        System.out.println("Vowels: " + counts[0] + ", Consonants: " + counts[1]);

        System.out.println("Remove duplicates: " + removeDuplicateCharacters("banana"));
        System.out.println("First non-repeating: " + firstNonRepeatingCharStream(input));
    }
}
