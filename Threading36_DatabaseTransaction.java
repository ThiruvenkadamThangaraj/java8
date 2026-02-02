import java.util.concurrent.CompletableFuture;

// Simulating async database operations
public class Threading36_DatabaseTransaction {
    static class Database {
        CompletableFuture<Boolean> insert(String table, String data) {
            return CompletableFuture.supplyAsync(() -> {
                try {
                    System.out.println("Inserting into " + table);
                    Thread.sleep(500);
                    return true;
                } catch (InterruptedException e) {
                    return false;
                }
            });
        }
        
        CompletableFuture<String> query(String sql) {
            return CompletableFuture.supplyAsync(() -> {
                try {
                    System.out.println("Querying: " + sql);
                    Thread.sleep(700);
                    return "Query Result";
                } catch (InterruptedException e) {
                    return null;
                }
            });
        }
    }
    
    public static void main(String[] args) {
        Database db = new Database();
        
        CompletableFuture<String> transaction = db.insert("users", "Alice")
                .thenCompose(success -> success ? db.query("SELECT * FROM users") : 
                             CompletableFuture.completedFuture("Insert failed"));
        
        System.out.println("Result: " + transaction.join());
    }
}
