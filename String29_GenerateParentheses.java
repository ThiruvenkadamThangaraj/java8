import java.util.*;

// Generate all valid parentheses combinations
public class String29_GenerateParentheses {
    public static void main(String[] args) {
        int n = 3;
        System.out.println("Generate " + n + " pairs of parentheses:");
        
        List<String> result = generateParenthesis(n);
        result.forEach(System.out::println);
        
        System.out.println("\nTotal combinations: " + result.size());
    }
    
    static List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        generate(result, "", 0, 0, n);
        return result;
    }
    
    static void generate(List<String> result, String current, int open, int close, int max) {
        if (current.length() == max * 2) {
            result.add(current);
            return;
        }
        
        if (open < max) {
            generate(result, current + "(", open + 1, close, max);
        }
        if (close < open) {
            generate(result, current + ")", open, close + 1, max);
        }
    }
}
