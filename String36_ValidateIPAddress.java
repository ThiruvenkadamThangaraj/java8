// Validate IP address (IPv4)
public class String36_ValidateIPAddress {
    public static void main(String[] args) {
        String[] testCases = {
            "192.168.1.1",
            "256.256.256.256",
            "192.168.1",
            "192.168.1.1.1",
            "192.168.01.1"
        };
        
        for (String ip : testCases) {
            System.out.println(ip + " is valid? " + isValidIPv4(ip));
        }
    }
    
    static boolean isValidIPv4(String ip) {
        String[] parts = ip.split("\\.");
        if (parts.length != 4) return false;
        
        for (String part : parts) {
            if (part.isEmpty() || part.length() > 3) return false;
            if (part.length() > 1 && part.charAt(0) == '0') return false;
            
            try {
                int num = Integer.parseInt(part);
                if (num < 0 || num > 255) return false;
            } catch (NumberFormatException e) {
                return false;
            }
        }
        
        return true;
    }
}
