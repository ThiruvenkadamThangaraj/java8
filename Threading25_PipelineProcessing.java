import java.util.concurrent.CompletableFuture;

// Multi-stage pipeline processing
public class Threading25_PipelineProcessing {
    public static void main(String[] args) {
        System.out.println("Starting pipeline processing...");
        
        CompletableFuture<String> pipeline = CompletableFuture.supplyAsync(() -> {
            System.out.println("Stage 1: Fetch data on " + Thread.currentThread().getName());
            try { Thread.sleep(1000); } catch (InterruptedException e) { e.printStackTrace(); }
            return "raw_data_12345";
        })
        .thenApplyAsync(data -> {
            System.out.println("Stage 2: Validate on " + Thread.currentThread().getName());
            return data.contains("_") ? data : "invalid";
        })
        .thenApplyAsync(data -> {
            System.out.println("Stage 3: Transform on " + Thread.currentThread().getName());
            return data.toUpperCase();
        })
        .thenApplyAsync(data -> {
            System.out.println("Stage 4: Encrypt on " + Thread.currentThread().getName());
            return new StringBuilder(data).reverse().toString();
        });
        
        System.out.println("Final result: " + pipeline.join());
    }
}
