import java.util.*;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

// Batch processing with async operations
public class Threading48_BatchProcessing {
    public static void main(String[] args) {
        List<Integer> items = IntStream.rangeClosed(1, 15)
                .boxed()
                .collect(Collectors.toList());
        
        int batchSize = 5;
        System.out.println("Processing " + items.size() + " items in batches of " + batchSize);
        
        List<List<Integer>> batches = new ArrayList<>();
        for (int i = 0; i < items.size(); i += batchSize) {
            batches.add(items.subList(i, Math.min(i + batchSize, items.size())));
        }
        
        List<CompletableFuture<Void>> batchFutures = batches.stream()
                .map(batch -> CompletableFuture.runAsync(() -> {
                    System.out.println("Processing batch: " + batch);
                    try { Thread.sleep(500); } catch (InterruptedException e) { e.printStackTrace(); }
                    System.out.println("Batch completed: " + batch);
                }))
                .collect(Collectors.toList());
        
        CompletableFuture.allOf(batchFutures.toArray(new CompletableFuture[0])).join();
        System.out.println("All batches processed!");
    }
}
