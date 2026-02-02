// Check if string is scrambled version of another
public class String49_ScrambleString {
    public static void main(String[] args) {
        String s1 = "great";
        String s2 = "rgeat";
        
        System.out.println("String 1: " + s1);
        System.out.println("String 2: " + s2);
        System.out.println("Is scramble? " + isScramble(s1, s2));
        
        System.out.println("\nAnother example:");
        System.out.println("'abcde' and 'caebd': " + isScramble("abcde", "caebd"));
    }
    
    static boolean isScramble(String s1, String s2) {
        if (s1.equals(s2)) return true;
        if (s1.length() != s2.length()) return false;
        
        int[] letters = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            letters[s1.charAt(i) - 'a']++;
            letters[s2.charAt(i) - 'a']--;
        }
        for (int i = 0; i < 26; i++) {
            if (letters[i] != 0) return false;
        }
        
        for (int i = 1; i < s1.length(); i++) {
            if (isScramble(s1.substring(0, i), s2.substring(0, i)) &&
                isScramble(s1.substring(i), s2.substring(i))) {
                return true;
            }
            if (isScramble(s1.substring(0, i), s2.substring(s2.length() - i)) &&
                isScramble(s1.substring(i), s2.substring(0, s2.length() - i))) {
                return true;
            }
        }
        
        return false;
    }
}
