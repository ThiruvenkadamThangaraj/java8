// Check if one string is rotation of another
public class String16_StringRotation {
    public static void main(String[] args) {
        String str1 = "abcde";
        String str2 = "cdeab";
        
        System.out.println("String 1: " + str1);
        System.out.println("String 2: " + str2);
        
        boolean isRotation = (str1.length() == str2.length()) && 
                             (str1 + str1).contains(str2);
        
        System.out.println("Is rotation? " + isRotation);
        
        // More examples
        System.out.println("\nMore examples:");
        System.out.println("'waterbottle' and 'erbottlewat': " + 
            isRotation("waterbottle", "erbottlewat"));
        System.out.println("'hello' and 'lohel': " + 
            isRotation("hello", "lohel"));
    }
    
    static boolean isRotation(String s1, String s2) {
        return (s1.length() == s2.length()) && (s1 + s1).contains(s2);
    }
}
