import java.util.concurrent.CompletableFuture;

// applyToEither - Apply function to whichever completes first
public class Threading13_ApplyToEither {
    public static void main(String[] args) {
        CompletableFuture<Integer> future1 = CompletableFuture.supplyAsync(() -> {
            try {
                System.out.println("Future 1 working...");
                Thread.sleep(2000);
                System.out.println("Future 1 done");
                return 100;
            } catch (InterruptedException e) { return 0; }
        });
        
        CompletableFuture<Integer> future2 = CompletableFuture.supplyAsync(() -> {
            try {
                System.out.println("Future 2 working...");
                Thread.sleep(1000);
                System.out.println("Future 2 done");
                return 50;
            } catch (InterruptedException e) { return 0; }
        });
        
        CompletableFuture<Integer> result = future1.applyToEither(future2, value -> {
            System.out.println("Processing: " + value);
            return value * 2;
        });
        
        System.out.println("Result: " + result.join());
    }
}
