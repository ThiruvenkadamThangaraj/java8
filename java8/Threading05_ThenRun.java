import java.util.concurrent.CompletableFuture;

// thenRun - Execute action after completion (no access to result)
public class Threading05_ThenRun {
    public static void main(String[] args) {
        CompletableFuture<Integer> future = CompletableFuture.supplyAsync(() -> {
            System.out.println("Computing on: " + Thread.currentThread().getName());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return 50;
        })
        .thenRun(() -> {
            System.out.println("Running after completion on: " + Thread.currentThread().getName());
            System.out.println("No access to previous result");
            System.out.println("Just executing side effects");
        });
        
        future.join();
        System.out.println("Completed!");
    }
}
