import java.util.concurrent.CompletableFuture;
import java.util.concurrent.atomic.AtomicInteger;

// Track progress of async operations
public class Threading45_ProgressTracking {
    public static void main(String[] args) {
        AtomicInteger completed = new AtomicInteger(0);
        int totalTasks = 10;
        
        System.out.println("Starting " + totalTasks + " tasks...");
        
        for (int i = 1; i <= totalTasks; i++) {
            final int taskNum = i;
            CompletableFuture.runAsync(() -> {
                try {
                    System.out.println("Task " + taskNum + " started");
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            })
            .whenComplete((result, ex) -> {
                int done = completed.incrementAndGet();
                int progress = (done * 100) / totalTasks;
                System.out.println("Progress: " + progress + "% (" + done + "/" + totalTasks + ")");
            });
        }
        
        try {
            Thread.sleep(12000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
