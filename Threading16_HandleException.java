import java.util.concurrent.CompletableFuture;

// handle - Handle both success and exception
public class Threading16_HandleException {
    public static void main(String[] args) {
        CompletableFuture<Integer> future = CompletableFuture.supplyAsync(() -> {
            System.out.println("Computing...");
            try { Thread.sleep(1000); } catch (InterruptedException e) { e.printStackTrace(); }
            if (Math.random() > 0.5) {
                return 100;
            } else {
                throw new RuntimeException("Random error occurred!");
            }
        })
        .handle((result, exception) -> {
            if (exception != null) {
                System.out.println("Exception caught: " + exception.getMessage());
                return 0;
            } else {
                System.out.println("Success! Result: " + result);
                return result;
            }
        });
        
        System.out.println("Final result: " + future.join());
    }
}
