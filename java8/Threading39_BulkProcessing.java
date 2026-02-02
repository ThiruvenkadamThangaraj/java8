import java.util.*;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

// Process bulk data asynchronously
public class Threading39_BulkProcessing {
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        
        List<Integer> numbers = IntStream.rangeClosed(1, 20)
                .boxed()
                .collect(Collectors.toList());
        
        System.out.println("Processing " + numbers.size() + " items in parallel...");
        
        List<CompletableFuture<Integer>> futures = numbers.stream()
                .map(n -> CompletableFuture.supplyAsync(() -> {
                    System.out.println("Processing " + n);
                    try { Thread.sleep(500); } catch (InterruptedException e) { e.printStackTrace(); }
                    return n * n;
                }))
                .collect(Collectors.toList());
        
        List<Integer> results = futures.stream()
                .map(CompletableFuture::join)
                .collect(Collectors.toList());
        
        System.out.println("Results: " + results);
        System.out.println("Time: " + (System.currentTimeMillis() - start) + " ms");
    }
}
