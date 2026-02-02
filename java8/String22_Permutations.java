import java.util.*;

// Generate all permutations of a string
public class String22_Permutations {
    public static void main(String[] args) {
        String str = "abc";
        System.out.println("String: " + str);
        System.out.println("Permutations:");
        
        List<String> permutations = new ArrayList<>();
        permute(str, "", permutations);
        permutations.forEach(System.out::println);
        
        System.out.println("\nTotal permutations: " + permutations.size());
    }
    
    static void permute(String str, String prefix, List<String> result) {
        if (str.isEmpty()) {
            result.add(prefix);
            return;
        }
        
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            String remaining = str.substring(0, i) + str.substring(i + 1);
            permute(remaining, prefix + ch, result);
        }
    }
}
