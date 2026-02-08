import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

public class StringOps04_Substrings {

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

    public static int lengthOfLastWord(String s) {
        if (s == null) {
            return 0;
        }
        String trimmed = s.trim();
        if (trimmed.isEmpty()) {
            return 0;
        }
        int lastSpace = trimmed.lastIndexOf(' ');
        return trimmed.length() - lastSpace - 1;
    }

    public static String minWindowSubstring(String s, String t) {
        if (s == null || t == null || t.isEmpty()) {
            return "";
        }
        int[] need = new int[256];
        char[] tChars = t.toCharArray();
        IntStream.range(0, tChars.length).forEach(i -> {
            char ch = tChars[i];
            if (ch < 256) {
                need[ch]++;
            }
        });
        int[] missing = new int[] { t.length() };
        int[] left = new int[] { 0 };
        int[] bestStart = new int[] { 0 };
        int[] bestLen = new int[] { Integer.MAX_VALUE };
        IntStream.range(0, s.length()).forEach(right -> {
            char ch = s.charAt(right);
            if (ch < 256 && need[ch] > 0) {
                missing[0]--;
            }
            if (ch < 256) {
                need[ch]--;
            }
            while (missing[0] == 0) {
                if (right - left[0] + 1 < bestLen[0]) {
                    bestLen[0] = right - left[0] + 1;
                    bestStart[0] = left[0];
                }
                char leftChar = s.charAt(left[0]++);
                if (leftChar < 256) {
                    need[leftChar]++;
                    if (need[leftChar] > 0) {
                        missing[0]++;
                    }
                }
            }
        });
        return bestLen[0] == Integer.MAX_VALUE ? "" : s.substring(bestStart[0], bestStart[0] + bestLen[0]);
    }

    public static String longestPalindromicSubstring(String s) {
        if (s == null || s.isEmpty()) {
            return "";
        }
        int[] start = new int[] { 0 };
        int[] end = new int[] { 0 };
        IntStream.range(0, s.length()).forEach(i -> {
            int len1 = expandAroundCenter(s, i, i);
            int len2 = expandAroundCenter(s, i, i + 1);
            int len = Math.max(len1, len2);
            if (len > end[0] - start[0]) {
                start[0] = i - (len - 1) / 2;
                end[0] = i + len / 2;
            }
        });
        return s.substring(start[0], end[0] + 1);
    }

    public static int countPalindromicSubstrings(String s) {
        if (s == null) {
            return 0;
        }
        return IntStream.range(0, s.length())
                .map(i -> countCenters(s, i, i) + countCenters(s, i, i + 1))
                .sum();
    }

    private static int expandAroundCenter(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return right - left - 1;
    }

    private static int countCenters(String s, int left, int right) {
        int count = 0;
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            count++;
            left--;
            right++;
        }
        return count;
    }

    public static int strStr(String haystack, String needle) {
        if (haystack == null || needle == null) {
            return -1;
        }
        return haystack.indexOf(needle);
    }

    public static void main(String[] args) {
        System.out.println("Longest without repeating: " + longestSubstringWithoutRepeating("abcabcbb"));
        System.out.println("Zigzag: " + convertZigzag("PAYPALISHIRING", 3));
        System.out.println("Group anagrams: " + groupAnagrams(new String[] { "eat", "tea", "tan", "ate", "nat", "bat" }));
        System.out.println("Last word length: " + lengthOfLastWord("Hello World"));
        System.out.println("Min window: " + minWindowSubstring("ADOBECODEBANC", "ABC"));
        System.out.println("Longest palindrome: " + longestPalindromicSubstring("babad"));
        System.out.println("Count palindromes: " + countPalindromicSubstrings("aaa"));
        System.out.println("strStr: " + strStr("hello", "ll"));
    }
}
