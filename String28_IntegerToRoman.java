// Convert integer to Roman numeral
public class String28_IntegerToRoman {
    public static void main(String[] args) {
        int[] numbers = {3, 4, 9, 58, 1994, 3999};
        
        for (int i = 0; i < numbers.length; i++) {
            int num = numbers[i];
            System.out.println(num + " = " + intToRoman(num));
        }
    }
    
    static String intToRoman(int num) {
        String[] symbols = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        
        StringBuilder result = new StringBuilder();
        
        for (int i = 0; i < values.length; i++) {
            while (num >= values[i]) {
                num -= values[i];
                result.append(symbols[i]);
            }
        }
        
        return result.toString();
    }
}
