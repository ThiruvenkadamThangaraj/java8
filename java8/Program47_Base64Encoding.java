import java.util.Base64;

// Base64 encoding and decoding
public class Program47_Base64Encoding {
    public static void main(String[] args) {
        String originalText = "Hello World!";
        System.out.println("Original: " + originalText);
        
        // Encode
        String encoded = Base64.getEncoder().encodeToString(originalText.getBytes());
        System.out.println("Encoded: " + encoded);
        
        // Decode
        byte[] decodedBytes = Base64.getDecoder().decode(encoded);
        String decoded = new String(decodedBytes);
        System.out.println("Decoded: " + decoded);
        
        // URL encoding
        String urlEncoded = Base64.getUrlEncoder().encodeToString(originalText.getBytes());
        System.out.println("URL Encoded: " + urlEncoded);
    }
}
