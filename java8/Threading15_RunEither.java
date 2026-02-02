import java.util.concurrent.CompletableFuture;

// runEither - Run action after either future completes
public class Threading15_RunEither {
    public static void main(String[] args) {
        CompletableFuture<Void> future1 = CompletableFuture.runAsync(() -> {
            try {
                System.out.println("Task 1 working...");
                Thread.sleep(2000);
                System.out.println("Task 1 done");
            } catch (InterruptedException e) { e.printStackTrace(); }
        });
        
        CompletableFuture<Void> future2 = CompletableFuture.runAsync(() -> {
            try {
                System.out.println("Task 2 working...");
                Thread.sleep(1000);
                System.out.println("Task 2 done");
            } catch (InterruptedException e) { e.printStackTrace(); }
        });
        
        CompletableFuture<Void> result = future1.runEitherAsync(future2, () -> {
            System.out.println("One of them completed!");
            System.out.println("Running follow-up action");
        });
        
        result.join();
        System.out.println("Completed!");
    }
}
