// Count ways to decode a string (1-26 = A-Z)
public class String38_DecodeWays {
    public static void main(String[] args) {
        String[] testCases = {"12", "226", "06", "11106"};
        
        for (int i = 0; i < testCases.length; i++) {
            String s = testCases[i];
            System.out.println("String: " + s);
            System.out.println("Number of ways to decode: " + numDecodings(s));
            System.out.println();
        }
    }
    
    static int numDecodings(String s) {
        if (s == null || s.length() == 0 || s.charAt(0) == '0') return 0;
        
        int n = s.length();
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        
        for (int i = 2; i <= n; i++) {
            int oneDigit = Integer.parseInt(s.substring(i - 1, i));
            int twoDigits = Integer.parseInt(s.substring(i - 2, i));
            
            if (oneDigit >= 1) {
                dp[i] += dp[i - 1];
            }
            if (twoDigits >= 10 && twoDigits <= 26) {
                dp[i] += dp[i - 2];
            }
        }
        
        return dp[n];
    }
}
