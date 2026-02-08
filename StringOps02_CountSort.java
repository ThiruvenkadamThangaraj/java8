import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class StringOps02_CountSort {

    public static Map<Character, Long> countOccurrences(String input) {
        Map<Character, Long> counts = new LinkedHashMap<>();
        if (input == null) {
            return counts;
        }
        return input.chars()
                .mapToObj(ch -> (char) ch)
                .collect(Collectors.groupingBy(
                        Function.identity(),
                        LinkedHashMap::new,
                        Collectors.counting()));
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

    public static String longestCommonPrefix(String[] words) {
        if (words == null || words.length == 0) {
            return "";
        }
        String[] prefixHolder = new String[] { words[0] };
        IntStream.range(1, words.length).forEach(i -> {
            while (!words[i].startsWith(prefixHolder[0])) {
                prefixHolder[0] = prefixHolder[0].substring(0, prefixHolder[0].length() - 1);
            }
        });
        return prefixHolder[0];
    }

    public static List<String> permutations(String input) {
        List<String> results = new ArrayList<>();
        if (input == null) {
            return results;
        }
        boolean[] used = new boolean[input.length()];
        backtrackPermutations(input.toCharArray(), used, new StringBuilder(), results);
        return results;
    }

    private static void backtrackPermutations(char[] chars, boolean[] used, StringBuilder path, List<String> results) {
        if (path.length() == chars.length) {
            results.add(path.toString());
            return;
        }
        IntStream.range(0, chars.length).forEach(i -> {
            if (used[i]) {
                return;
            }
            used[i] = true;
            path.append(chars[i]);
            backtrackPermutations(chars, used, path, results);
            path.deleteCharAt(path.length() - 1);
            used[i] = false;
        });
    }

    public static String compressString(String input) {
        if (input == null || input.isEmpty()) {
            return input;
        }
        StringBuilder result = new StringBuilder();
        int[] count = new int[] { 1 };
        int length = input.length();
        IntStream.range(1, length + 1).forEach(i -> {
            if (i < length && input.charAt(i) == input.charAt(i - 1)) {
                count[0]++;
            } else {
                result.append(input.charAt(i - 1)).append(count[0]);
                count[0] = 1;
            }
        });
        return result.toString();
    }

    public static void main(String[] args) {
        System.out.println("Counts: " + countOccurrences("banana"));
        System.out.println("Sorted: " + sortCharacters("dcba"));
        System.out.println("Replace: " + replaceSubstring("hello world", "world", "java"));
        System.out.println("Subsequence: " + isSubsequence("ace", "abcde"));
        System.out.println("Prefix: " + longestCommonPrefix(new String[] { "flower", "flow", "flight" }));
        System.out.println("Permutations: " + permutations("abc"));
        System.out.println("Compress: " + compressString("aaabb"));
    }
}
