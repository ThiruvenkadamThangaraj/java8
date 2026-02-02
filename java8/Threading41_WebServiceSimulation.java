import java.util.concurrent.CompletableFuture;

// Simulating web service calls with CompletableFuture
public class Threading41_WebServiceSimulation {
    static class WebService {
        CompletableFuture<String> getUser(int userId) {
            return CompletableFuture.supplyAsync(() -> {
                System.out.println("Fetching user " + userId);
                try { Thread.sleep(500); } catch (InterruptedException e) { e.printStackTrace(); }
                return "{id:" + userId + ", name:User" + userId + "}";
            });
        }
        
        CompletableFuture<String> getOrders(int userId) {
            return CompletableFuture.supplyAsync(() -> {
                System.out.println("Fetching orders for user " + userId);
                try { Thread.sleep(300); } catch (InterruptedException e) { e.printStackTrace(); }
                return "[Order1, Order2, Order3]";
            });
        }
    }
    
    public static void main(String[] args) {
        WebService service = new WebService();
        
        CompletableFuture<String> fullData = service.getUser(123)
                .thenCombine(service.getOrders(123), (user, orders) -> 
                    user + " has orders: " + orders);
        
        System.out.println(fullData.join());
    }
}
