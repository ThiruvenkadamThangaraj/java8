import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

public class StringOps03_RomanParentheses {

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

    public static boolean isParenthesesBalanced(String input) {
        if (input == null) {
            return false;
        }
        Deque<Character> stack = new ArrayDeque<>();
        char[] chars = input.toCharArray();
        final boolean[] valid = new boolean[] { true };
        IntStream.range(0, chars.length).forEach(i -> {
            if (!valid[0]) {
                return;
            }
            char ch = chars[i];
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
        if (!valid[0]) {
            return false;
        }
        return stack.isEmpty();
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

    public static void main(String[] args) {
        System.out.println("Roman to int: " + romanToInt("MCMXCIV"));
        System.out.println("Int to roman: " + intToRoman(1994));
        System.out.println("Balanced: " + isParenthesesBalanced("{[()]}"));
        System.out.println("Parentheses: " + generateParentheses(3));
    }
}
