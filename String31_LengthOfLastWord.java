// Find length of last word in string
public class String31_LengthOfLastWord {
    public static void main(String[] args) {
        String[] testCases = {
            "Hello World",
            "   fly me   to   the moon  ",
            "luffy is still joyboy"
        };
        
        for (int i = 0; i < testCases.length; i++) {
            String test = testCases[i];
            System.out.println("String: '" + test + "'");
            System.out.println("Last word length: " + lengthOfLastWord(test));
            System.out.println();
        }
    }
    
    static int lengthOfLastWord(String s) {
        s = s.trim();
        int lastSpace = s.lastIndexOf(' ');
        return s.length() - lastSpace - 1;
    }
}
