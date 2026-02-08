import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

public class StringInterviewSet05 {

    public static boolean regexMatch(String s, String p) {
        if (s == null || p == null) {
            return false;
        }
        int m = s.length();
        int n = p.length();
        boolean[][] dp = new boolean[m + 1][n + 1];
        dp[0][0] = true;
        IntStream.rangeClosed(2, n).forEach(j -> {
            if (p.charAt(j - 1) == '*') {
                dp[0][j] = dp[0][j - 2];
            }
        });
        IntStream.rangeClosed(1, m).forEach(i -> {
            IntStream.rangeClosed(1, n).forEach(j -> {
                char pc = p.charAt(j - 1);
                if (pc == '*') {
                    dp[i][j] = dp[i][j - 2];
                    char prev = p.charAt(j - 2);
                    if (prev == '.' || prev == s.charAt(i - 1)) {
                        dp[i][j] = dp[i][j] || dp[i - 1][j];
                    }
                } else if (pc == '.' || pc == s.charAt(i - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                }
            });
        });
        return dp[m][n];
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

    public static int longestCommonSubsequence(String a, String b) {
        if (a == null || b == null) {
            return 0;
        }
        int[][] dp = new int[a.length() + 1][b.length() + 1];
        IntStream.rangeClosed(1, a.length()).forEach(i -> {
            IntStream.rangeClosed(1, b.length()).forEach(j -> {
                if (a.charAt(i - 1) == b.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            });
        });
        return dp[a.length()][b.length()];
    }

    public static long countDistinctSubsequences(String s, String t) {
        if (s == null || t == null) {
            return 0;
        }
        long[][] dp = new long[s.length() + 1][t.length() + 1];
        IntStream.rangeClosed(0, s.length()).forEach(i -> dp[i][0] = 1);
        IntStream.rangeClosed(1, s.length()).forEach(i -> {
            IntStream.rangeClosed(1, t.length()).forEach(j -> {
                dp[i][j] = dp[i - 1][j];
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    dp[i][j] += dp[i - 1][j - 1];
                }
            });
        });
        return dp[s.length()][t.length()];
    }

    public static boolean isInterleaving(String s1, String s2, String s3) {
        if (s1 == null || s2 == null || s3 == null || s1.length() + s2.length() != s3.length()) {
            return false;
        }
        boolean[][] dp = new boolean[s1.length() + 1][s2.length() + 1];
        dp[0][0] = true;
        IntStream.rangeClosed(0, s1.length()).forEach(i -> {
            IntStream.rangeClosed(0, s2.length()).forEach(j -> {
                if (i > 0) {
                    dp[i][j] = dp[i][j] || (dp[i - 1][j] && s1.charAt(i - 1) == s3.charAt(i + j - 1));
                }
                if (j > 0) {
                    dp[i][j] = dp[i][j] || (dp[i][j - 1] && s2.charAt(j - 1) == s3.charAt(i + j - 1));
                }
            });
        });
        return dp[s1.length()][s2.length()];
    }

    public static boolean isScramble(String s1, String s2) {
        if (s1 == null || s2 == null || s1.length() != s2.length()) {
            return false;
        }
        Map<String, Boolean> memo = new HashMap<>();
        return isScrambleHelper(s1, s2, memo);
    }

    private static boolean isScrambleHelper(String s1, String s2, Map<String, Boolean> memo) {
        String key = s1 + "|" + s2;
        if (memo.containsKey(key)) {
            return memo.get(key);
        }
        if (s1.equals(s2)) {
            memo.put(key, true);
            return true;
        }
        char[] a = s1.toCharArray();
        char[] b = s2.toCharArray();
        Arrays.sort(a);
        Arrays.sort(b);
        if (!Arrays.equals(a, b)) {
            memo.put(key, false);
            return false;
        }
        boolean match = IntStream.range(1, s1.length()).anyMatch(i ->
                (isScrambleHelper(s1.substring(0, i), s2.substring(0, i), memo)
                        && isScrambleHelper(s1.substring(i), s2.substring(i), memo))
                        || (isScrambleHelper(s1.substring(0, i), s2.substring(s2.length() - i), memo)
                        && isScrambleHelper(s1.substring(i), s2.substring(0, s2.length() - i), memo)));
        memo.put(key, match);
        return match;
    }

    public static List<String> fullJustify(String[] words, int maxWidth) {
        List<String> result = new ArrayList<>();
        int index = 0;
        while (index < words.length) {
            int total = words[index].length();
            int last = index + 1;
            while (last < words.length) {
                if (total + 1 + words[last].length() > maxWidth) {
                    break;
                }
                total += 1 + words[last].length();
                last++;
            }
            StringBuilder line = new StringBuilder();
            int gaps = last - index - 1;
            if (last == words.length || gaps == 0) {
                IntStream.range(index, last).forEach(i -> {
                    line.append(words[i]);
                    if (i < last - 1) {
                        line.append(' ');
                    }
                });
                while (line.length() < maxWidth) {
                    line.append(' ');
                }
            } else {
                int[] totalSpaces = new int[] { maxWidth };
                IntStream.range(index, last).forEach(i -> totalSpaces[0] -= words[i].length());
                int spaceEach = totalSpaces[0] / gaps;
                int[] extra = new int[] { totalSpaces[0] % gaps };
                IntStream.range(index, last).forEach(i -> {
                    line.append(words[i]);
                    if (i < last - 1) {
                        int spaces = spaceEach + (extra[0]-- > 0 ? 1 : 0);
                        IntStream.range(0, spaces).forEach(s -> line.append(' '));
                    }
                });
            }
            result.add(line.toString());
            index = last;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println("Regex: " + regexMatch("aab", "c*a*b"));
        System.out.println("Min window: " + minWindowSubstring("ADOBECODEBANC", "ABC"));
        System.out.println("Longest palindrome: " + longestPalindromicSubstring("babad"));
        System.out.println("Count palindromes: " + countPalindromicSubstrings("aaa"));
        System.out.println("strStr: " + strStr("hello", "ll"));
        System.out.println("LCS: " + longestCommonSubsequence("abcde", "ace"));
        System.out.println("Distinct subseq: " + countDistinctSubsequences("rabbbit", "rabbit"));
        System.out.println("Interleaving: " + isInterleaving("aab", "axy", "aaxaby"));
        System.out.println("Scramble: " + isScramble("great", "rgeat"));
        System.out.println("Justify: " + fullJustify(new String[] { "This", "is", "an", "example", "of", "text", "justification." }, 16));
    }
}
