import java.util.concurrent.CompletableFuture;

// Inspect the state of CompletableFuture
public class Threading32_StateInspection {
    public static void main(String[] args) throws InterruptedException {
        CompletableFuture<Integer> future1 = CompletableFuture.supplyAsync(() -> {
            try { Thread.sleep(1000); } catch (InterruptedException e) { e.printStackTrace(); }
            return 42;
        });
        
        System.out.println("Before completion:");
        System.out.println("isDone: " + future1.isDone());
        System.out.println("isCancelled: " + future1.isCancelled());
        System.out.println("isCompletedExceptionally: " + future1.isCompletedExceptionally());
        
        Thread.sleep(1500);
        
        System.out.println("\nAfter completion:");
        System.out.println("isDone: " + future1.isDone());
        System.out.println("isCancelled: " + future1.isCancelled());
        System.out.println("isCompletedExceptionally: " + future1.isCompletedExceptionally());
        System.out.println("getNow: " + future1.getNow(-1));
    }
}
