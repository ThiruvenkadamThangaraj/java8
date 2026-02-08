import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

public class StringInterviewSet03 {

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
        List<String> result = new ArrayList<>();
        if (input == null) {
            return result;
        }
        boolean[] used = new boolean[input.length()];
        backtrackPermutations(input.toCharArray(), used, new StringBuilder(), result);
        return result;
    }

    private static void backtrackPermutations(char[] chars, boolean[] used, StringBuilder path, List<String> result) {
        if (path.length() == chars.length) {
            result.add(path.toString());
            return;
        }
        IntStream.range(0, chars.length).forEach(i -> {
            if (used[i]) {
                return;
            }
            used[i] = true;
            path.append(chars[i]);
            backtrackPermutations(chars, used, path, result);
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

    public static int romanToInt(String s) {
        if (s == null || s.isEmpty()) {
            return 0;
        }
        Map<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        int[] total = new int[] { 0 };
        int[] prev = new int[] { 0 };
        IntStream.range(0, s.length())
                .map(i -> s.length() - 1 - i)
                .forEach(i -> {
                    int curr = map.getOrDefault(s.charAt(i), 0);
                    if (curr < prev[0]) {
                        total[0] -= curr;
                    } else {
                        total[0] += curr;
                    }
                    prev[0] = curr;
                });
        return total[0];
    }

    public static boolean isParenthesesBalanced(String input) {
        if (input == null) {
            return false;
        }
        LinkedList<Character> stack = new LinkedList<>();
        char[] inputChars = input.toCharArray();
        final boolean[] valid = new boolean[] { true };
        IntStream.range(0, inputChars.length).forEach(i -> {
            if (!valid[0]) {
                return;
            }
            char ch = inputChars[i];
            if (ch == '(' || ch == '{' || ch == '[') {
                stack.push(ch);
            } else if (ch == ')' || ch == '}' || ch == ']') {
                if (stack.isEmpty()) {
                    valid[0] = false;
                    return;
                }
                char open = stack.pop();
                if ((ch == ')' && open != '(') || (ch == '}' && open != '{') || (ch == ']' && open != '[')) {
                    valid[0] = false;
                }
            }
        });
        return valid[0] && stack.isEmpty();
    }

    public static int longestSubstringWithoutRepeating(String s) {
        if (s == null) {
            return 0;
        }
        int[] last = new int[256];
        Arrays.fill(last, -1);
        int[] max = new int[] { 0 };
        int[] start = new int[] { 0 };
        IntStream.range(0, s.length()).forEach(i -> {
            char ch = s.charAt(i);
            if (ch < 256 && last[ch] >= start[0]) {
                start[0] = last[ch] + 1;
            }
            if (ch < 256) {
                last[ch] = i;
            }
            max[0] = Math.max(max[0], i - start[0] + 1);
        });
        return max[0];
    }

    public static String convertZigzag(String s, int numRows) {
        if (s == null || numRows <= 1 || s.length() <= numRows) {
            return s;
        }
        StringBuilder[] rows = new StringBuilder[numRows];
        IntStream.range(0, numRows).forEach(i -> rows[i] = new StringBuilder());
        int[] row = new int[] { 0 };
        int[] step = new int[] { 1 };
        char[] zigzagChars = s.toCharArray();
        IntStream.range(0, zigzagChars.length).forEach(i -> {
            char ch = zigzagChars[i];
            rows[row[0]].append(ch);
            if (row[0] == 0) {
                step[0] = 1;
            } else if (row[0] == numRows - 1) {
                step[0] = -1;
            }
            row[0] += step[0];
        });
        StringBuilder result = new StringBuilder();
        IntStream.range(0, rows.length).forEach(i -> result.append(rows[i]));
        return result.toString();
    }

    public static String intToRoman(int num) {
        int[] values = { 1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1 };
        String[] symbols = { "M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I" };
        StringBuilder result = new StringBuilder();
        int[] remaining = new int[] { num };
        IntStream.range(0, values.length).forEach(i -> {
            while (remaining[0] >= values[i]) {
                remaining[0] -= values[i];
                result.append(symbols[i]);
            }
        });
        return result.toString();
    }

    public static List<String> generateParentheses(int n) {
        List<String> result = new ArrayList<>();
        backtrackParentheses(n, 0, 0, new StringBuilder(), result);
        return result;
    }

    private static void backtrackParentheses(int n, int open, int close, StringBuilder path, List<String> result) {
        if (path.length() == n * 2) {
            result.add(path.toString());
            return;
        }
        if (open < n) {
            path.append('(');
            backtrackParentheses(n, open + 1, close, path, result);
            path.deleteCharAt(path.length() - 1);
        }
        if (close < open) {
            path.append(')');
            backtrackParentheses(n, open, close + 1, path, result);
            path.deleteCharAt(path.length() - 1);
        }
    }

    public static List<List<String>> groupAnagrams(String[] words) {
        Map<String, List<String>> groups = new HashMap<>();
        Arrays.stream(words).forEach(word -> {
            char[] chars = word.toCharArray();
            Arrays.sort(chars);
            String key = new String(chars);
            groups.computeIfAbsent(key, k -> new ArrayList<>()).add(word);
        });
        return new ArrayList<>(groups.values());
    }

    public static void main(String[] args) {
        System.out.println("Prefix: " + longestCommonPrefix(new String[] { "flower", "flow", "flight" }));
        System.out.println("Permutations: " + permutations("abc"));
        System.out.println("Compress: " + compressString("aaabb"));
        System.out.println("Roman to int: " + romanToInt("MCMXCIV"));
        System.out.println("Balanced: " + isParenthesesBalanced("{[()]}"));
        System.out.println("Longest without repeating: " + longestSubstringWithoutRepeating("abcabcbb"));
        System.out.println("Zigzag: " + convertZigzag("PAYPALISHIRING", 3));
        System.out.println("Int to roman: " + intToRoman(1994));
        System.out.println("Parentheses: " + generateParentheses(3));
        System.out.println("Group anagrams: " + groupAnagrams(new String[] { "eat", "tea", "tan", "ate", "nat", "bat" }));
    }
}
