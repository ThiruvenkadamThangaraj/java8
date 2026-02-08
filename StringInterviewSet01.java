import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class StringInterviewSet01 {

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
        return input.chars()
                .distinct()
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();
    }

    public static Map<Character, Integer> duplicateCharCounts(String input) {
        if (input == null) {
            return new LinkedHashMap<>();
        }
        Map<Character, Long> counts = input.chars()
                .mapToObj(ch -> (char) ch)
                .collect(Collectors.groupingBy(
                        Function.identity(),
                        LinkedHashMap::new,
                        Collectors.counting()));
        return counts.entrySet().stream()
                .filter(entry -> entry.getValue() > 1L)
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        entry -> entry.getValue().intValue(),
                        (a, b) -> a,
                        LinkedHashMap::new));
    }

    public static boolean areAnagrams(String a, String b) {
        if (a == null || b == null || a.length() != b.length()) {
            return false;
        }
        char[] aChars = a.toCharArray();
        char[] bChars = b.toCharArray();
        Arrays.sort(aChars);
        Arrays.sort(bChars);
        return Arrays.equals(aChars, bChars);
    }

    public static Character firstNonRepeatingChar(String input) {
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

    public static String reverseWords(String input) {
        if (input == null || input.trim().isEmpty()) {
            return input;
        }
        String[] parts = input.trim().split("\\s+");
        return IntStream.range(0, parts.length)
                .mapToObj(i -> parts[parts.length - 1 - i])
                .collect(Collectors.joining(" "));
    }

    public static String removeAllWhitespaces(String input) {
        if (input == null) {
            return null;
        }
        return input.replaceAll("\\s+", "");
    }

    public static String longestWord(String input) {
        if (input == null || input.trim().isEmpty()) {
            return "";
        }
        String[] parts = input.trim().split("\\s+");
        return Arrays.stream(parts)
                .max(Comparator.comparingInt(String::length))
                .orElse("");
    }

    public static void main(String[] args) {
        System.out.println("Reverse: " + reverseString("Thiru"));
        System.out.println("Palindrome: " + isPalindrome("malayalam"));
        int[] vc = countVowelsAndConsonants("Thiru");
        System.out.println("Vowels: " + vc[0] + ", Consonants: " + vc[1]);
        System.out.println("Remove duplicates: " + removeDuplicateCharacters("banana"));
        System.out.println("Duplicate counts: " + duplicateCharCounts("programming"));
        System.out.println("Anagrams: " + areAnagrams("listen", "silent"));
        System.out.println("First non-repeating: " + firstNonRepeatingChar("swiss"));
        System.out.println("Reverse words: " + reverseWords("hello java world"));
        System.out.println("Remove whitespaces: " + removeAllWhitespaces("a b\t c"));
        System.out.println("Longest word: " + longestWord("java is powerful"));
    }
}
