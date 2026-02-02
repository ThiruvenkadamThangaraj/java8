import java.util.concurrent.CompletableFuture;

// Comprehensive error recovery strategy
public class Threading44_ErrorRecovery {
    public static void main(String[] args) {
        CompletableFuture<Integer> future = CompletableFuture.supplyAsync(() -> {
            System.out.println("Step 1: Computing");
            throw new RuntimeException("Calculation failed!");
        })
        .exceptionally(ex -> {
            System.out.println("Recovery 1: " + ex.getMessage());
            return 50;
        })
        .thenApply(n -> {
            Integer val = (Integer) n;
            System.out.println("Step 2: Got " + val);
            if (val < 100) {
                throw new RuntimeException("Value too small!");
            }
                return val;
        })
        .exceptionally(ex -> {
            System.out.println("Recovery 2: " + ex.getMessage());
            System.out.println("Returning default value");
            return 100;
        });
        
        System.out.println("Final: " + future.join());
    }
}
