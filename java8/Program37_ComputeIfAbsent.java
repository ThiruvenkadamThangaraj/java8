import java.util.*;

// computeIfAbsent example
public class Program37_ComputeIfAbsent {
    public static void main(String[] args) {
        Map<String, List<String>> map = new HashMap<>();
        
        // Traditional way
        if (!map.containsKey("fruits")) {
            map.put("fruits", new ArrayList<>());
        }
        map.get("fruits").add("apple");
        
        // Java 8 way with computeIfAbsent
        map.computeIfAbsent("fruits", k -> new ArrayList<>()).add("banana");
        map.computeIfAbsent("vegetables", k -> new ArrayList<>()).add("carrot");
        map.computeIfAbsent("vegetables", k -> new ArrayList<>()).add("potato");
        
        System.out.println("Map: " + map);
    }
}
