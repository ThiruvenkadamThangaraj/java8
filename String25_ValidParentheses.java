import java.util.*;

// Check if parentheses are valid
public class String25_ValidParentheses {
    public static void main(String[] args) {
        String[] testCases = {"()", "()[]{}", "(]", "([)]", "{[]}"};
        
        for (String test : testCases) {
            System.out.println(test + " is valid? " + isValid(test));
        }
    }
    
    static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        
        for (char c : s.toCharArray()) {
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
