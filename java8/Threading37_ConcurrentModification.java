import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ConcurrentHashMap;

// Safe concurrent modifications
public class Threading37_ConcurrentModification {
    public static void main(String[] args) {
        ConcurrentHashMap<Integer, String> map = new ConcurrentHashMap<>();
        
        System.out.println("Starting concurrent updates...");
        
        for (int i = 1; i <= 5; i++) {
            final int index = i;
            CompletableFuture.runAsync(() -> {
                try {
                    Thread.sleep(100 * index);
                    map.put(index, "Value-" + index);
                    System.out.println("Added: " + index + " -> " + map.get(index));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }
        
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        System.out.println("\nFinal map: " + map);
    }
}
