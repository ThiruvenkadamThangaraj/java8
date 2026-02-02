import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

// completeOnTimeout - Provide default value on timeout
public class Threading20_CompleteOnTimeout {
    public static void main(String[] args) {
        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> {
            try {
                System.out.println("Processing...");
                Thread.sleep(5000);
                return "Completed";
            } catch (InterruptedException e) {
                return "Interrupted";
            }
        })
        .completeOnTimeout("Default Value", 2, TimeUnit.SECONDS);
        
        System.out.println("Result: " + future.join());
    }
}
