import java.util.Arrays;

// Check if two strings are anagrams
public class String06_CheckAnagram {
    public static void main(String[] args) {
        String str1 = "listen";
        String str2 = "silent";
        
        System.out.println("String 1: " + str1);
        System.out.println("String 2: " + str2);
        
        // Method 1: Sort and compare
        boolean isAnagram1 = isAnagram(str1, str2);
        System.out.println("Are anagrams (Method 1)? " + isAnagram1);
        
        // Test more pairs
        System.out.println("\nMore tests:");
        System.out.println("'eat' and 'tea': " + isAnagram("eat", "tea"));
        System.out.println("'hello' and 'world': " + isAnagram("hello", "world"));
    }
    
    static boolean isAnagram(String s1, String s2) {
        if (s1.length() != s2.length()) return false;
        
        char[] arr1 = s1.toLowerCase().toCharArray();
        char[] arr2 = s2.toLowerCase().toCharArray();
        
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        
        return Arrays.equals(arr1, arr2);
    }
}
