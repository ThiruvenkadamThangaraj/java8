import java.util.*;

// Find longest substring without repeating characters
public class String26_LongestSubstringNoRepeat {
    public static void main(String[] args) {
        String[] testCases = {"abcabcbb", "bbbbb", "pwwkew", "dvdf"};
        
        for (String test : testCases) {
            System.out.println("String: " + test);
            String longest = findLongest(test);
            System.out.println("Longest substring: " + longest + " (length: " + longest.length() + ")\n");
        }
    }
    
    static String findLongest(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int maxLen = 0;
        int start = 0;
        int maxStart = 0;
        
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            
            if (map.containsKey(c) && map.get(c) >= start) {
                start = map.get(c) + 1;
            }
            
            map.put(c, i);
            
            if (i - start + 1 > maxLen) {
                maxLen = i - start + 1;
                maxStart = start;
            }
        }
        
        return s.substring(maxStart, maxStart + maxLen);
    }
}
