// Wildcard pattern matching (* and ?)
public class String40_WildcardMatching {
    public static void main(String[] args) {
        String[][] testCases = {
            {"aa", "a"},
            {"aa", "*"},
            {"cb", "?a"},
            {"adceb", "*a*b"},
            {"acdcb", "a*c?b"}
        };
        
        for (String[] test : testCases) {
            System.out.println("Text: " + test[0] + ", Pattern: " + test[1]);
            System.out.println("Matches? " + isMatch(test[0], test[1]));
            System.out.println();
        }
    }
    
    static boolean isMatch(String s, String p) {
        int m = s.length();
        int n = p.length();
        boolean[][] dp = new boolean[m + 1][n + 1];
        dp[0][0] = true;
        
        for (int j = 1; j <= n; j++) {
            if (p.charAt(j - 1) == '*') {
                dp[0][j] = dp[0][j - 1];
            }
        }
        
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (p.charAt(j - 1) == '*') {
                    dp[i][j] = dp[i - 1][j] || dp[i][j - 1];
                } else if (p.charAt(j - 1) == '?' || s.charAt(i - 1) == p.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                }
            }
        }
        
        return dp[m][n];
    }
}
