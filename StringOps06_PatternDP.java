import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

public class StringOps06_PatternDP {

    public static boolean wildcardMatch(String s, String p) {
        if (s == null || p == null) {
            return false;
        }
        int m = s.length();
        int n = p.length();
        boolean[][] dp = new boolean[m + 1][n + 1];
        dp[0][0] = true;
        IntStream.rangeClosed(1, n).forEach(j -> {
            if (p.charAt(j - 1) == '*') {
                dp[0][j] = dp[0][j - 1];
            }
        });
        IntStream.rangeClosed(1, m).forEach(i -> {
            IntStream.rangeClosed(1, n).forEach(j -> {
                char pc = p.charAt(j - 1);
                if (pc == '*') {
                    dp[i][j] = dp[i][j - 1] || dp[i - 1][j];
                } else if (pc == '?' || pc == s.charAt(i - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                }
            });
        });
        return dp[m][n];
    }

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
        System.out.println("Wildcard: " + wildcardMatch("aa", "a*"));
        System.out.println("Regex: " + regexMatch("aab", "c*a*b"));
        System.out.println("LCS: " + longestCommonSubsequence("abcde", "ace"));
        System.out.println("Distinct subseq: " + countDistinctSubsequences("rabbbit", "rabbit"));
        System.out.println("Interleaving: " + isInterleaving("aab", "axy", "aaxaby"));
        System.out.println("Scramble: " + isScramble("great", "rgeat"));
        System.out.println("Justify: " + fullJustify(new String[] { "This", "is", "an", "example", "of", "text", "justification." }, 16));
    }
}
