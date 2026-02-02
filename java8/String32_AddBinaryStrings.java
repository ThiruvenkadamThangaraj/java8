// Add two binary strings
public class String32_AddBinaryStrings {
    public static void main(String[] args) {
        String a = "1010";
        String b = "1011";
        
        System.out.println("Binary 1: " + a);
        System.out.println("Binary 2: " + b);
        System.out.println("Sum: " + addBinary(a, b));
        
        System.out.println("\nAnother example:");
        System.out.println("11 + 1 = " + addBinary("11", "1"));
    }
    
    static String addBinary(String a, String b) {
        StringBuilder result = new StringBuilder();
        int i = a.length() - 1;
        int j = b.length() - 1;
        int carry = 0;
        
        while (i >= 0 || j >= 0 || carry > 0) {
            int sum = carry;
            if (i >= 0) sum += a.charAt(i--) - '0';
            if (j >= 0) sum += b.charAt(j--) - '0';
            
            result.append(sum % 2);
            carry = sum / 2;
        }
        
        return result.reverse().toString();
    }
}
