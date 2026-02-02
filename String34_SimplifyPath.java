import java.util.*;

// Simplify Unix file path
public class String34_SimplifyPath {
    public static void main(String[] args) {
        String[] paths = {
            "/home/",
            "/../",
            "/home//foo/",
            "/a/./b/../../c/"
        };
        
        for (String path : paths) {
            System.out.println("Original: " + path);
            System.out.println("Simplified: " + simplifyPath(path));
            System.out.println();
        }
    }
    
    static String simplifyPath(String path) {
        Stack<String> stack = new Stack<>();
        String[] parts = path.split("/");
        
        for (String part : parts) {
            if (part.isEmpty() || part.equals(".")) {
                continue;
            } else if (part.equals("..")) {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else {
                stack.push(part);
            }
        }
        
        return "/" + String.join("/", stack);
    }
}
