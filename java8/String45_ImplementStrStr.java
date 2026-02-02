// Implement strStr() - find substring
public class String45_ImplementStrStr {
    public static void main(String[] args) {
        String haystack = "hello";
        String needle = "ll";
        
        System.out.println("Haystack: " + haystack);
        System.out.println("Needle: " + needle);
        System.out.println("Index: " + strStr(haystack, needle));
        
        System.out.println("\nMore examples:");
        System.out.println("'aaaaa' contains 'bba': " + strStr("aaaaa", "bba"));
        System.out.println("'mississippi' contains 'issip': " + strStr("mississippi", "issip"));
    }
    
    static int strStr(String haystack, String needle) {
        if (needle.isEmpty()) return 0;
        if (haystack.length() < needle.length()) return -1;
        
        for (int i = 0; i <= haystack.length() - needle.length(); i++) {
            int j = 0;
            while (j < needle.length() && haystack.charAt(i + j) == needle.charAt(j)) {
                j++;
            }
            if (j == needle.length()) {
                return i;
            }
        }
        
        return -1;
    }
}
