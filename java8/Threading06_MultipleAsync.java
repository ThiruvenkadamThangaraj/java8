import java.util.concurrent.CompletableFuture;

// Multiple async operations sequentially
public class Threading06_MultipleAsync {
    public static void main(String[] args) {
        System.out.println("Starting multiple operations...");
        
        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> {
            System.out.println("Task 1 on: " + Thread.currentThread().getName());
            try { Thread.sleep(500); } catch (InterruptedException e) { e.printStackTrace(); }
            return "Result1";
        })
        .thenApply(result -> {
            System.out.println("Task 2 on: " + Thread.currentThread().getName());
            System.out.println("Got: " + result);
            try { Thread.sleep(500); } catch (InterruptedException e) { e.printStackTrace(); }
            return result + " -> Result2";
        })
        .thenApply(result -> {
            System.out.println("Task 3 on: " + Thread.currentThread().getName());
            System.out.println("Got: " + result);
            return result + " -> Result3";
        });
        
        System.out.println("Final: " + future.join());
    }
}
