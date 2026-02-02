// Compress string (e.g., "aabbbcccc" -> "a2b3c4")
public class String23_StringCompression {
    public static void main(String[] args) {
        String text = "aabbbcccc";
        System.out.println("Original: " + text);
        
        StringBuilder compressed = new StringBuilder();
        int count = 1;
        
        for (int i = 0; i < text.length(); i++) {
            if (i + 1 < text.length() && text.charAt(i) == text.charAt(i + 1)) {
                count++;
            } else {
                compressed.append(text.charAt(i));
                if (count > 1) {
                    compressed.append(count);
                }
                count = 1;
            }
        }
        
        String result = compressed.length() < text.length() ? compressed.toString() : text;
        System.out.println("Compressed: " + result);
    }
}
