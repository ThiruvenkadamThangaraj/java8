import java.util.concurrent.CompletableFuture;

// Using BiFunction with multiple futures
public class Threading29_BiFunction {
    public static void main(String[] args) {
        CompletableFuture<Integer> future1 = CompletableFuture.supplyAsync(() -> {
            System.out.println("Future 1: Calculating area");
            try { Thread.sleep(800); } catch (InterruptedException e) { e.printStackTrace(); }
            return 5;
        });
        
        CompletableFuture<Integer> future2 = CompletableFuture.supplyAsync(() -> {
            System.out.println("Future 2: Calculating width");
            try { Thread.sleep(600); } catch (InterruptedException e) { e.printStackTrace(); }
            return 4;
        });
        
        CompletableFuture<Integer> result = future1.thenCombineAsync(future2, (height, width) -> {
            System.out.println("Combining: height=" + height + ", width=" + width);
            return height * width;
        });
        
        System.out.println("Area: " + result.join());
    }
}
