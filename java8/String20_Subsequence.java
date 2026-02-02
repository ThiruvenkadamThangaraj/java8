// Check if string is subsequence of another
public class String20_Subsequence {
    public static void main(String[] args) {
        String main = "abcde";
        String sub = "ace";
        
        System.out.println("Main string: " + main);
        System.out.println("Subsequence: " + sub);
        
        boolean isSubsequence = isSubsequence(main, sub);
        System.out.println("Is subsequence? " + isSubsequence);
        
        // More tests
        System.out.println("\nMore tests:");
        System.out.println("'hello' contains 'hlo': " + isSubsequence("hello", "hlo"));
        System.out.println("'hello' contains 'loh': " + isSubsequence("hello", "loh"));
    }
    
    static boolean isSubsequence(String main, String sub) {
        int j = 0;
        for (int i = 0; i < main.length() && j < sub.length(); i++) {
            if (main.charAt(i) == sub.charAt(j)) {
                j++;
            }
        }
        return j == sub.length();
    }
}
