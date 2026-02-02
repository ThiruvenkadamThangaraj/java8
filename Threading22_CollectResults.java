import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

// Collect results from multiple futures
public class Threading22_CollectResults {
    public static void main(String[] args) {
        System.out.println("Starting parallel tasks with result collection...");
        
        var results = IntStream.rangeClosed(1, 5)
                .mapToObj(i -> CompletableFuture.supplyAsync(() -> {
                    try {
                        System.out.println("Task " + i + " on " + Thread.currentThread().getName());
                        Thread.sleep(500);
                    } catch (InterruptedException e) { e.printStackTrace(); }
                    return "Result-" + i;
                }))
                .collect(Collectors.toList());
        
        results.stream()
                .map(CompletableFuture::join)
                .forEach(System.out::println);
        
        System.out.println("All tasks completed!");
    }
}
