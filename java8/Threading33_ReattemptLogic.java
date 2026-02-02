import java.util.concurrent.CompletableFuture;

// Retry logic with CompletableFuture
public class Threading33_ReattemptLogic {
    static int attemptCount = 0;
    
    static CompletableFuture<String> unreliableOperation() {
        attemptCount++;
        System.out.println("Attempt " + attemptCount);
        
        return CompletableFuture.supplyAsync(() -> {
            if (attemptCount < 3) {
                throw new RuntimeException("Failed at attempt " + attemptCount);
            }
            return "Success!";
        });
    }
    
    public static void main(String[] args) {
        System.out.println("Starting with retry logic...");
        
        CompletableFuture<String> result = unreliableOperation()
                .exceptionally(ex -> {
                    System.out.println("Exception: " + ex.getMessage());
                    return unreliableOperation().join();
                })
                .exceptionally(ex -> {
                    System.out.println("Exception: " + ex.getMessage());
                    return unreliableOperation().join();
                });
        
        System.out.println("Result: " + result.join());
    }
}
