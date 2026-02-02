import java.util.concurrent.CompletableFuture;

// whenComplete - Execute after completion (with access to result/exception)
public class Threading18_WhenComplete {
    public static void main(String[] args) {
        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> {
            try {
                System.out.println("Task executing...");
                Thread.sleep(1500);
                System.out.println("Task completed");
                return "Success";
            } catch (InterruptedException e) {
                return "Interrupted";
            }
        })
        .whenComplete((result, exception) -> {
            System.out.println("WhenComplete called");
            if (exception == null) {
                System.out.println("Result: " + result);
            } else {
                System.out.println("Exception: " + exception.getMessage());
            }
        })
        .thenApply(s -> {
            System.out.println("Continuing with: " + s);
            return s + " -> Processed";
        });
        
        System.out.println("Final: " + future.join());
    }
}
