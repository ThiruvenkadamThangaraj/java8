import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ConcurrentHashMap;

// Async caching pattern
public class Threading43_CacheWithAsync {
    static class AsyncCache<K, V> {
        private ConcurrentHashMap<K, CompletableFuture<V>> cache = new ConcurrentHashMap<>();
        
        CompletableFuture<V> get(K key, java.util.function.Function<K, CompletableFuture<V>> loader) {
            return cache.computeIfAbsent(key, k -> {
                System.out.println("Cache miss for " + k + ", loading...");
                return loader.apply(k);
            });
        }
    }
    
    public static void main(String[] args) {
        AsyncCache<String, String> cache = new AsyncCache<>();
        
        var future1 = cache.get("user1", key -> 
            CompletableFuture.supplyAsync(() -> {
                try { Thread.sleep(500); } catch (InterruptedException e) { e.printStackTrace(); }
                return "User1Data";
            })
        );
        
        var future2 = cache.get("user1", key -> 
            CompletableFuture.supplyAsync(() -> "Should not load")
        );
        
        System.out.println("First: " + future1.join());
        System.out.println("Second (cached): " + future2.join());
    }
}
