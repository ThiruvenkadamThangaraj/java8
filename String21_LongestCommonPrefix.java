import java.util.*;

// Find longest common prefix among strings
public class String21_LongestCommonPrefix {
    public static void main(String[] args) {
        String[] strings = {"flower", "flow", "flight"};
        
        System.out.println("Strings: " + Arrays.toString(strings));
        
        if (strings.length == 0) {
            System.out.println("No common prefix");
            return;
        }
        
        String prefix = strings[0];
        for (int i = 1; i < strings.length; i++) {
            while (strings[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.isEmpty()) {
                    System.out.println("No common prefix");
                    return;
                }
            }
        }
        
        System.out.println("Longest common prefix: '" + prefix + "'");
    }
}
