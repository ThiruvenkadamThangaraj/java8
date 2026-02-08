import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.IntStream;

public class StringOps05_NumberAndPath {

    public static String addBinary(String a, String b) {
        if (a == null || b == null) {
            return "";
        }
        StringBuilder result = new StringBuilder();
        int i = a.length() - 1;
        int j = b.length() - 1;
        int carry = 0;
        while (i >= 0 || j >= 0 || carry > 0) {
            int sum = carry;
            if (i >= 0) {
                sum += a.charAt(i--) - '0';
            }
            if (j >= 0) {
                sum += b.charAt(j--) - '0';
            }
            result.append(sum % 2);
            carry = sum / 2;
        }
        return result.reverse().toString();
    }

    public static String multiplyStrings(String num1, String num2) {
        if (num1 == null || num2 == null) {
            return "";
        }
        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }
        int[] result = new int[num1.length() + num2.length()];
        IntStream.range(0, num1.length()).forEach(ii -> {
            int i = num1.length() - 1 - ii;
            IntStream.range(0, num2.length()).forEach(jj -> {
                int j = num2.length() - 1 - jj;
                int mul = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                int sum = mul + result[i + j + 1];
                result[i + j + 1] = sum % 10;
                result[i + j] += sum / 10;
            });
        });
        StringBuilder sb = new StringBuilder();
        int[] idx = new int[] { 0 };
        while (idx[0] < result.length && result[idx[0]] == 0) {
            idx[0]++;
        }
        IntStream.range(idx[0], result.length).forEach(i -> sb.append(result[i]));
        return sb.toString();
    }

    public static String simplifyPath(String path) {
        if (path == null || path.isEmpty()) {
            return "/";
        }
        String[] parts = path.split("/");
        Deque<String> stack = new ArrayDeque<>();
        Arrays.stream(parts).forEach(part -> {
            if (part.isEmpty() || part.equals(".")) {
                return;
            }
            if (part.equals("..")) {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else {
                stack.push(part);
            }
        });
        StringBuilder result = new StringBuilder();
        while (!stack.isEmpty()) {
            result.insert(0, "/" + stack.removeLast());
        }
        return result.length() == 0 ? "/" : result.toString();
    }

    public static int editDistance(String a, String b) {
        if (a == null || b == null) {
            return 0;
        }
        int[][] dp = new int[a.length() + 1][b.length() + 1];
        IntStream.rangeClosed(0, a.length()).forEach(i -> dp[i][0] = i);
        IntStream.rangeClosed(0, b.length()).forEach(j -> dp[0][j] = j);
        IntStream.rangeClosed(1, a.length()).forEach(i -> {
            IntStream.rangeClosed(1, b.length()).forEach(j -> {
                if (a.charAt(i - 1) == b.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    int replace = dp[i - 1][j - 1];
                    int delete = dp[i - 1][j];
                    int insert = dp[i][j - 1];
                    dp[i][j] = 1 + Math.min(replace, Math.min(delete, insert));
                }
            });
        });
        return dp[a.length()][b.length()];
    }

    public static String validateIPAddress(String ip) {
        if (ip == null) {
            return "Neither";
        }
        if (isValidIPv4(ip)) {
            return "IPv4";
        }
        if (isValidIPv6(ip)) {
            return "IPv6";
        }
        return "Neither";
    }

    private static boolean isValidIPv4(String ip) {
        String[] parts = ip.split("\\.", -1);
        if (parts.length != 4) {
            return false;
        }
        return IntStream.range(0, parts.length).allMatch(i -> {
            String part = parts[i];
            if (part.isEmpty() || (part.length() > 1 && part.startsWith("0"))) {
                return false;
            }
            try {
                int value = Integer.parseInt(part);
                return value >= 0 && value <= 255;
            } catch (NumberFormatException ex) {
                return false;
            }
        });
    }

    private static boolean isValidIPv6(String ip) {
        if (ip.startsWith(":" ) || ip.endsWith(":")) {
            if (!ip.contains("::")) {
                return false;
            }
        }
        String[] doubleSplit = ip.split("::", -1);
        if (doubleSplit.length > 2) {
            return false;
        }
        String[] left = doubleSplit[0].isEmpty() ? new String[0] : doubleSplit[0].split(":");
        String[] right = (doubleSplit.length == 2 && !doubleSplit[1].isEmpty()) ? doubleSplit[1].split(":") : new String[0];
        if (left.length + right.length > 8) {
            return false;
        }
        boolean leftValid = IntStream.range(0, left.length)
                .allMatch(i -> isValidIPv6Block(left[i]));
        boolean rightValid = IntStream.range(0, right.length)
                .allMatch(i -> isValidIPv6Block(right[i]));
        return leftValid && rightValid;
    }

    private static boolean isValidIPv6Block(String part) {
        if (part.isEmpty() || part.length() > 4) {
            return false;
        }
        char[] partChars = part.toCharArray();
        return IntStream.range(0, partChars.length).allMatch(i -> {
            char ch = partChars[i];
            boolean isDigit = ch >= '0' && ch <= '9';
            boolean isLower = ch >= 'a' && ch <= 'f';
            boolean isUpper = ch >= 'A' && ch <= 'F';
            return isDigit || isLower || isUpper;
        });
    }

    public static List<String> restoreIPAddresses(String s) {
        List<String> result = new ArrayList<>();
        if (s == null) {
            return result;
        }
        backtrackRestoreIp(s, 0, 0, new StringBuilder(), result);
        return result;
    }

    private static void backtrackRestoreIp(String s, int index, int parts, StringBuilder path, List<String> result) {
        if (parts == 4 && index == s.length()) {
            result.add(path.toString());
            return;
        }
        if (parts == 4 || index == s.length()) {
            return;
        }
        int length = path.length();
        IntStream.rangeClosed(1, 3)
                .filter(i -> index + i <= s.length())
                .forEach(i -> {
                    String segment = s.substring(index, index + i);
                    if (segment.length() > 1 && segment.startsWith("0")) {
                        return;
                    }
                    int value = Integer.parseInt(segment);
                    if (value > 255) {
                        return;
                    }
                    if (parts > 0) {
                        path.append('.');
                    }
                    path.append(segment);
                    backtrackRestoreIp(s, index + i, parts + 1, path, result);
                    path.setLength(length);
                });
    }

    public static int decodeWays(String s) {
        if (s == null || s.isEmpty() || s.charAt(0) == '0') {
            return 0;
        }
        int n = s.length();
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        IntStream.rangeClosed(2, n).forEach(i -> {
            char one = s.charAt(i - 1);
            char two = s.charAt(i - 2);
            if (one != '0') {
                dp[i] += dp[i - 1];
            }
            int value = (two - '0') * 10 + (one - '0');
            if (value >= 10 && value <= 26) {
                dp[i] += dp[i - 2];
            }
        });
        return dp[n];
    }

    public static boolean wordBreak(String s, Set<String> dict) {
        if (s == null || dict == null) {
            return false;
        }
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        IntStream.rangeClosed(1, s.length()).forEach(i -> {
            dp[i] = IntStream.range(0, i)
                    .anyMatch(j -> dp[j] && dict.contains(s.substring(j, i)));
        });
        return dp[s.length()];
    }

    public static void main(String[] args) {
        System.out.println("Add binary: " + addBinary("1010", "1011"));
        System.out.println("Multiply: " + multiplyStrings("123", "45"));
        System.out.println("Simplify: " + simplifyPath("/a/./b/../../c/"));
        System.out.println("Edit distance: " + editDistance("horse", "ros"));
        System.out.println("Validate IP: " + validateIPAddress("2001:0db8:85a3:0:0:8A2E:0370:7334"));
        System.out.println("Restore IPs: " + restoreIPAddresses("25525511135"));
        System.out.println("Decode ways: " + decodeWays("226"));
        Set<String> dict = new HashSet<>();
        dict.add("leet");
        dict.add("code");
        System.out.println("Word break: " + wordBreak("leetcode", dict));
    }
}
