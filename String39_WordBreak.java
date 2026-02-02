import java.util.*;

// Check if string can be segmented into dictionary words
public class String39_WordBreak {
    public static void main(String[] args) {
        String s = "leetcode";
        List<String> wordDict = Arrays.asList("leet", "code");
        
        System.out.println("String: " + s);
        System.out.println("Dictionary: " + wordDict);
        System.out.println("Can be segmented? " + wordBreak(s, wordDict));
        
        System.out.println("\nAnother example:");
        String s2 = "catsandog";
        List<String> dict2 = Arrays.asList("cats", "dog", "sand", "and", "cat");
        System.out.println("String: " + s2);
        System.out.println("Dictionary: " + dict2);
        System.out.println("Can be segmented? " + wordBreak(s2, dict2));
    }
    
    static boolean wordBreak(String s, List<String> wordDict) {
        Set<String> dict = new HashSet<>(wordDict);
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && dict.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        
        return dp[s.length()];
    }
}
