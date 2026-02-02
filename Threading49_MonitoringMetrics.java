import java.util.concurrent.CompletableFuture;
import java.util.concurrent.atomic.AtomicLong;

// Monitoring and metrics collection
public class Threading49_MonitoringMetrics {
    static class Metrics {
        AtomicLong totalCompleted = new AtomicLong(0);
        AtomicLong totalFailed = new AtomicLong(0);
        AtomicLong totalTime = new AtomicLong(0);
        
        void recordSuccess(long duration) {
            totalCompleted.incrementAndGet();
            totalTime.addAndGet(duration);
        }
        
        void recordFailure() {
            totalFailed.incrementAndGet();
        }
        
        void report() {
            long completed = totalCompleted.get();
            System.out.println("\n=== Metrics Report ===");
            System.out.println("Completed: " + completed);
            System.out.println("Failed: " + totalFailed.get());
            System.out.println("Avg time: " + (completed > 0 ? totalTime.get() / completed : 0) + " ms");
        }
    }
    
    public static void main(String[] args) {
        Metrics metrics = new Metrics();
        
        for (int i = 1; i <= 5; i++) {
            final int taskNum = i;
            long startTime = System.currentTimeMillis();
            
            CompletableFuture.runAsync(() -> {
                try {
                    System.out.println("Task " + taskNum + " executing");
                    Thread.sleep(500);
                    metrics.recordSuccess(System.currentTimeMillis() - startTime);
                } catch (InterruptedException e) {
                    metrics.recordFailure();
                }
            });
        }
        
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        metrics.report();
    }
}
