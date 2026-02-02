import java.util.concurrent.CompletableFuture;

// Basic supplyAsync - Asynchronous computation
public class Threading01_SupplyAsync {
    public static void main(String[] args) {
        System.out.println("Main thread: " + Thread.currentThread().getName());
        
        CompletableFuture<Integer> future = CompletableFuture.supplyAsync(() -> {
            System.out.println("Async thread: " + Thread.currentThread().getName());
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return 42;
        });
        
        System.out.println("Waiting for result...");
        Integer result = future.join();
        System.out.println("Result: " + result);
        System.out.println("Main completed on: " + Thread.currentThread().getName());
    }
}
