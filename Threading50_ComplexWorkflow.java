import java.util.concurrent.CompletableFuture;

// Complex multi-stage workflow with CompletableFuture
public class Threading50_ComplexWorkflow {
    static class Workflow {
        CompletableFuture<String> stage1() {
            return CompletableFuture.supplyAsync(() -> {
                System.out.println("Stage 1: Authenticate user");
                try { Thread.sleep(500); } catch (InterruptedException e) { e.printStackTrace(); }
                return "user_authenticated";
            });
        }
        
        CompletableFuture<String> stage2(String auth) {
            return CompletableFuture.supplyAsync(() -> {
                System.out.println("Stage 2: Validate " + auth);
                try { Thread.sleep(500); } catch (InterruptedException e) { e.printStackTrace(); }
                return "data_validated";
            });
        }
        
        CompletableFuture<String> stage3(String validated) {
            return CompletableFuture.supplyAsync(() -> {
                System.out.println("Stage 3: Process " + validated);
                try { Thread.sleep(500); } catch (InterruptedException e) { e.printStackTrace(); }
                return "data_processed";
            });
        }
        
        CompletableFuture<String> execute() {
            return stage1()
                    .thenCompose(this::stage2)
                    .thenCompose(this::stage3)
                    .thenApply(result -> "Final: " + result)
                    .whenComplete((result, ex) -> {
                        if (ex == null) {
                            System.out.println("Workflow completed: " + result);
                        } else {
                            System.out.println("Workflow failed: " + ex.getMessage());
                        }
                    });
        }
    }
    
    public static void main(String[] args) {
        Workflow workflow = new Workflow();
        String result = workflow.execute().join();
        System.out.println("Output: " + result);
    }
}
