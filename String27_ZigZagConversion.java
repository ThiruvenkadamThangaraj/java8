// Convert string to zigzag pattern
public class String27_ZigZagConversion {
    public static void main(String[] args) {
        String text = "PAYPALISHIRING";
        int numRows = 3;
        
        System.out.println("String: " + text);
        System.out.println("Rows: " + numRows);
        System.out.println("Zigzag: " + convert(text, numRows));
        
        System.out.println("\nWith 4 rows:");
        System.out.println("Zigzag: " + convert(text, 4));
    }
    
    static String convert(String s, int numRows) {
        if (numRows == 1) return s;
        
        StringBuilder[] rows = new StringBuilder[Math.min(numRows, s.length())];
        for (int i = 0; i < rows.length; i++) {
            rows[i] = new StringBuilder();
        }
        
        int currentRow = 0;
        boolean goingDown = false;
        
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            rows[currentRow].append(c);
            if (currentRow == 0 || currentRow == numRows - 1) {
                goingDown = !goingDown;
            }
            currentRow += goingDown ? 1 : -1;
        }
        
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < rows.length; i++) {
            result.append(rows[i]);
        }
        
        return result.toString();
    }
}
