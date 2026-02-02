import java.util.concurrent.CompletableFuture;

// Simulating parallel data fetching from multiple sources
public class Threading34_DataFetching {
    static class DataSource {
        String name;
        long delay;
        
        DataSource(String name, long delay) {
            this.name = name;
            this.delay = delay;
        }
        
        CompletableFuture<String> fetch() {
            return CompletableFuture.supplyAsync(() -> {
                try {
                    System.out.println("Fetching from " + name);
                    Thread.sleep(delay);
                    return "Data from " + name;
                } catch (InterruptedException e) {
                    return null;
                }
            });
        }
    }
    
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        
        DataSource source1 = new DataSource("API-1", 2000);
        DataSource source2 = new DataSource("API-2", 1500);
        DataSource source3 = new DataSource("API-3", 1000);
        
        CompletableFuture<String> result = source1.fetch()
                .thenCombine(source2.fetch(), (d1, d2) -> d1 + " | " + d2)
                .thenCombine(source3.fetch(), (d12, d3) -> d12 + " | " + d3);
        
        System.out.println("Fetched: " + result.join());
        System.out.println("Time taken: " + (System.currentTimeMillis() - start) + " ms");
    }
}
