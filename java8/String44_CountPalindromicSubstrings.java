// Count all palindromic substrings
public class String44_CountPalindromicSubstrings {
    public static void main(String[] args) {
        String[] testCases = {"abc", "aaa", "racecar"};
        
        for (String test : testCases) {
            System.out.println("String: " + test);
            System.out.println("Palindromic substrings: " + countSubstrings(test));
            System.out.println();
        }
    }
    
    static int countSubstrings(String s) {
        int count = 0;
        
        for (int i = 0; i < s.length(); i++) {
            count += expandAroundCenter(s, i, i);
            count += expandAroundCenter(s, i, i + 1);
        }
        
        return count;
    }
    
    static int expandAroundCenter(String s, int left, int right) {
        int count = 0;
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            count++;
            left--;
            right++;
        }
        return count;
    }
}
