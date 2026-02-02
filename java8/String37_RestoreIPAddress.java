import java.util.*;

// Restore IP addresses from string
public class String37_RestoreIPAddress {
    public static void main(String[] args) {
        String s = "25525511135";
        System.out.println("Input: " + s);
        System.out.println("Possible IP addresses:");
        
        List<String> result = restoreIpAddresses(s);
        result.forEach(System.out::println);
    }
    
    static List<String> restoreIpAddresses(String s) {
        List<String> result = new ArrayList<>();
        backtrack(result, s, 0, "", 0);
        return result;
    }
    
    static void backtrack(List<String> result, String s, int index, String current, int count) {
        if (count > 4) return;
        if (count == 4 && index == s.length()) {
            result.add(current.substring(0, current.length() - 1));
            return;
        }
        
        for (int i = 1; i <= 3; i++) {
            if (index + i > s.length()) break;
            String segment = s.substring(index, index + i);
            if ((segment.startsWith("0") && segment.length() > 1) || 
                (i == 3 && Integer.parseInt(segment) > 255)) continue;
            backtrack(result, s, index + i, current + segment + ".", count + 1);
        }
    }
}
