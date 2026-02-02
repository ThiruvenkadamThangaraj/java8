import java.util.concurrent.*;

// Managing thread pool with CompletableFuture
public class Threading35_ThreadPoolManagement {
    public static void main(String[] args) {
        ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(4);
        
        System.out.println("Initial pool size: " + executor.getPoolSize());
        
        for (int i = 1; i <= 10; i++) {
            final int taskNum = i;
            CompletableFuture.runAsync(() -> {
                System.out.println("Task " + taskNum + " on " + Thread.currentThread().getName());
                try { Thread.sleep(1000); } catch (InterruptedException e) { e.printStackTrace(); }
            }, executor);
        }
        
        System.out.println("Active threads: " + executor.getActiveCount());
        System.out.println("Queue size: " + executor.getQueue().size());
        
        executor.shutdown();
        try {
            executor.awaitTermination(10, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        System.out.println("All tasks completed!");
    }
}
