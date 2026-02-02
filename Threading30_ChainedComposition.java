import java.util.concurrent.CompletableFuture;

// Complex chained composition with multiple stages
public class Threading30_ChainedComposition {
    public static void main(String[] args) {
        System.out.println("Starting complex composition...");
        
        CompletableFuture<String> pipeline = CompletableFuture.supplyAsync(() -> {
            System.out.println("1. Fetch user");
            return "user_123";
        })
        .thenApplyAsync(userId -> {
            System.out.println("2. Fetch orders for " + userId);
            return "orders_" + userId;
        })
        .thenCompose(orders -> CompletableFuture.supplyAsync(() -> {
            System.out.println("3. Process " + orders);
            return "processed_" + orders;
        }))
        .thenApply(processed -> {
            System.out.println("4. Format " + processed);
            return "[RESULT] " + processed;
        })
        .whenComplete((result, ex) -> {
            if (ex == null) {
                System.out.println("5. Completed successfully");
            } else {
                System.out.println("5. Error occurred: " + ex.getMessage());
            }
        });
        
        System.out.println("Output: " + pipeline.join());
    }
}
