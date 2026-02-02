import java.util.concurrent.CompletableFuture;
import java.util.concurrent.atomic.AtomicInteger;

// Load balancing with async operations
public class Threading47_LoadBalancing {
    static class Server {
        String name;
        AtomicInteger activeRequests = new AtomicInteger(0);
        
        Server(String name) {
            this.name = name;
        }
        
        CompletableFuture<String> handle(String request) {
            return CompletableFuture.supplyAsync(() -> {
                activeRequests.incrementAndGet();
                System.out.println(name + " handling: " + request + 
                                 " (active: " + activeRequests.get() + ")");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) { e.printStackTrace(); }
                activeRequests.decrementAndGet();
                return name + " responded";
            });
        }
        
        int getLoad() {
            return activeRequests.get();
        }
    }
    
    public static void main(String[] args) {
        Server server1 = new Server("Server-1");
        Server server2 = new Server("Server-2");
        
        for (int i = 1; i <= 6; i++) {
            Server chosen = server1.getLoad() <= server2.getLoad() ? server1 : server2;
            chosen.handle("Request-" + i)
                    .thenAccept(System.out::println);
        }
        
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
