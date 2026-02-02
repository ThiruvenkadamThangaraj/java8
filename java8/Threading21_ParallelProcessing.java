import java.util.concurrent.CompletableFuture;
import java.util.ArrayList;
import java.util.List;

// Process list of items in parallel
public class Threading21_ParallelProcessing {
    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>();
        for (int i = 1; i <= 10; i++) {
            numbers.add(i);
        }
        
        System.out.println("Processing " + numbers.size() + " items in parallel...");
        long start = System.currentTimeMillis();
        
        List<CompletableFuture<Integer>> futures = new ArrayList<>();
        for (Integer num : numbers) {
            CompletableFuture<Integer> future = CompletableFuture.supplyAsync(() -> {
                System.out.println("Processing " + num + " on " + Thread.currentThread().getName());
                try { Thread.sleep(1000); } catch (InterruptedException e) { e.printStackTrace(); }
                return num * num;
            });
            futures.add(future);
        }
        
        CompletableFuture.allOf(futures.toArray(new CompletableFuture[0])).join();
        
        long end = System.currentTimeMillis();
        System.out.println("Time taken: " + (end - start) + " ms");
        System.out.println("Completed!");
    }
}
