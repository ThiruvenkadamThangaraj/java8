import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class StringInterviewSet02 {

    public static int countWords(String input) {
        if (input == null || input.trim().isEmpty()) {
            return 0;
        }
        return input.trim().split("\\s+").length;
    }

    public static boolean containsVowels(String input) {
        if (input == null) {
            return false;
        }
        String vowels = "aeiouAEIOU";
        return input.chars().anyMatch(ch -> vowels.indexOf(ch) >= 0);
    }

    public static String capitalizeWords(String input) {
        if (input == null || input.trim().isEmpty()) {
            return input;
        }
        String[] parts = input.trim().split("\\s+");
        return Arrays.stream(parts)
                .map(word -> Character.toUpperCase(word.charAt(0)) + word.substring(1).toLowerCase())
                .collect(Collectors.joining(" "));
    }

    public static String toggleCase(String input) {
        if (input == null) {
            return null;
        }
        return input.chars()
                .map(ch -> {
                    if (Character.isUpperCase(ch)) {
                        return Character.toLowerCase(ch);
                    }
                    if (Character.isLowerCase(ch)) {
                        return Character.toUpperCase(ch);
                    }
                    return ch;
                })
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();
    }

    public static String removeSpecialCharacters(String input) {
        if (input == null) {
            return null;
        }
        return input.replaceAll("[^a-zA-Z0-9 ]", "");
    }

    public static boolean isRotation(String a, String b) {
        if (a == null || b == null || a.length() != b.length()) {
            return false;
        }
        return (a + a).contains(b);
    }

    public static Map<Character, Integer> countOccurrences(String input) {
        if (input == null) {
            return new LinkedHashMap<>();
        }
        return input.chars()
                .mapToObj(ch -> (char) ch)
                .collect(Collectors.groupingBy(
                        Function.identity(),
                        LinkedHashMap::new,
                        Collectors.collectingAndThen(Collectors.counting(), Long::intValue)));
    }

    public static String sortCharacters(String input) {
        if (input == null) {
            return null;
        }
        char[] chars = input.toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }

    public static String replaceSubstring(String input, String target, String replacement) {
        if (input == null || target == null || replacement == null) {
            return input;
        }
        return input.replace(target, replacement);
    }

    public static boolean isSubsequence(String source, String target) {
        if (source == null || target == null) {
            return false;
        }
        int i = 0;
        int j = 0;
        while (i < source.length() && j < target.length()) {
            if (source.charAt(i) == target.charAt(j)) {
                i++;
            }
            j++;
        }
        return i == source.length();
    }

    public static void main(String[] args) {
        System.out.println("Count words: " + countWords("java is fun"));
        System.out.println("Contains vowels: " + containsVowels("rhythm"));
        System.out.println("Capitalize: " + capitalizeWords("hello java"));
        System.out.println("Toggle case: " + toggleCase("HeLLo"));
        System.out.println("Remove special: " + removeSpecialCharacters("a@b#c!"));
        System.out.println("Rotation: " + isRotation("abcd", "cdab"));
        System.out.println("Occurrences: " + countOccurrences("banana"));
        System.out.println("Sorted: " + sortCharacters("dcba"));
        System.out.println("Replace: " + replaceSubstring("hello world", "world", "java"));
        System.out.println("Subsequence: " + isSubsequence("ace", "abcde"));
    }
}
