import java.util.*;

// Check if parentheses are valid
public class String25_ValidParentheses {
    public static void main(String[] args) {
        String[] testCases = {"()", "()[]{}", "(]", "([)]", "{[]}"};
        
        for (int i = 0; i < testCases.length; i++) {
            String test = testCases[i];
            System.out.println(test + " is valid? " + isValid(test));
        }
    }
    
    static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) return false;
                
                char top = stack.pop();
                if ((c == ')' && top != '(') ||
                    (c == ']' && top != '[') ||
                    (c == '}' && top != '{')) {
                    return false;
                }
            }
        }
        
        return stack.isEmpty();
    }
}
