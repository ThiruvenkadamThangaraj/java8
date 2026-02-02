import java.util.concurrent.CompletableFuture;

// acceptEither - Accept result of whichever completes first
public class Threading14_AcceptEither {
    public static void main(String[] args) {
        CompletableFuture<String> future1 = CompletableFuture.supplyAsync(() -> {
            try {
                System.out.println("Future 1 working...");
                Thread.sleep(2000);
                return "First";
            } catch (InterruptedException e) { return null; }
        });
        
        CompletableFuture<String> future2 = CompletableFuture.supplyAsync(() -> {
            try {
                System.out.println("Future 2 working...");
                Thread.sleep(1000);
                return "Second";
            } catch (InterruptedException e) { return null; }
        });
        
        CompletableFuture<Void> result = future1.acceptEither(future2, value -> {
            System.out.println("Accepted value: " + value);
            System.out.println("Processing completed");
        });
        
        result.join();
        System.out.println("Done!");
    }
}
