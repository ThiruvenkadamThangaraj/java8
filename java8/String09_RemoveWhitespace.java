// Remove whitespace from string
public class String09_RemoveWhitespace {
    public static void main(String[] args) {
        String text = "  Hello   World   Java  ";
        System.out.println("Original: '" + text + "'");
        
        // Remove all whitespace
        String noSpaces = text.replaceAll("\\s+", "");
        System.out.println("No spaces: '" + noSpaces + "'");
        
        // Trim leading/trailing spaces
        String trimmed = text.trim();
        System.out.println("Trimmed: '" + trimmed + "'");
        
        // Replace multiple spaces with single space
        String singleSpace = text.trim().replaceAll("\\s+", " ");
        System.out.println("Single space: '" + singleSpace + "'");
        
        // Java 11+ strip (similar to trim but handles Unicode)
        System.out.println("Strip: '" + text.strip() + "'");
    }
}
