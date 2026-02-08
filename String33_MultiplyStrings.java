// Multiply two numbers represented as strings
public class String33_MultiplyStrings {
    public static void main(String[] args) {
        System.out.println("2 * 3 = " + multiply("2", "3"));
        System.out.println("123 * 456 = " + multiply("123", "456"));
        System.out.println("999 * 999 = " + multiply("999", "999"));
    }
    
    static String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) return "0";
        
        int[] result = new int[num1.length() + num2.length()];
        
        for (int i = num1.length() - 1; i >= 0; i--) {
            for (int j = num2.length() - 1; j >= 0; j--) {
                int mul = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                int p1 = i + j;
                int p2 = i + j + 1;
                int sum = mul + result[p2];
                
                result[p2] = sum % 10;
                result[p1] += sum / 10;
            }
        }
        
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < result.length; i++) {
            int num = result[i];
            if (!(sb.length() == 0 && num == 0)) {
                sb.append(num);
            }
        }
        
        return sb.length() == 0 ? "0" : sb.toString();
    }
}
