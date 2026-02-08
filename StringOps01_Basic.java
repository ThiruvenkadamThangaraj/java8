import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class StringOps01_Basic {

    public static Map<Character, Long> duplicateCharCounts(String input) {
        Map<Character, Long> counts = new LinkedHashMap<>();
        if (input == null) {
            return counts;
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
                        Map.Entry::getValue,
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

    public static void main(String[] args) {
        System.out.println("Duplicate counts: " + duplicateCharCounts("programming"));
        System.out.println("Anagrams: " + areAnagrams("listen", "silent"));
        System.out.println("Reverse words: " + reverseWords("hello java world"));
        System.out.println("Remove whitespace: " + removeAllWhitespaces("a b\t c"));
        System.out.println("Longest word: " + longestWord("java is fun"));
        System.out.println("Word count: " + countWords("java is fun"));
        System.out.println("Contains vowels: " + containsVowels("rhythm"));
        System.out.println("Capitalize words: " + capitalizeWords("hello java"));
        System.out.println("Toggle case: " + toggleCase("HeLLo"));
        System.out.println("Remove special: " + removeSpecialCharacters("a@b#c!"));
        System.out.println("Rotation: " + isRotation("abcd", "cdab"));
    }
}
