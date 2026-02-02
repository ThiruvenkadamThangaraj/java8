import java.util.*;
import java.util.concurrent.CompletableFuture;

// Process Employee objects asynchronously
public class Threading24_EmployeeProcessing {
    static class Employee {
        int id;
        String name;
        double salary;
        
        public Employee(int id, String name, double salary) {
            this.id = id;
            this.name = name;
            this.salary = salary;
        }
        
        @Override
        public String toString() {
            return "Employee{id=" + id + ", name='" + name + "', salary=" + salary + "}";
        }
    }
    
    public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(
            new Employee(1, "Alice", 50000),
            new Employee(2, "Bob", 60000),
            new Employee(3, "Charlie", 55000),
            new Employee(4, "David", 65000)
        );
        
        System.out.println("Processing employees asynchronously...");
        
        employees.forEach(emp -> 
            CompletableFuture.supplyAsync(() -> {
                System.out.println("Processing " + emp.name + " on " + Thread.currentThread().getName());
                try { Thread.sleep(500); } catch (InterruptedException e) { e.printStackTrace(); }
                return emp;
            })
            .thenApply(e -> {
                System.out.println("Calculating raise for " + e.name);
                e.salary *= 1.1;
                return e;
            })
            .thenAccept(e -> System.out.println("Updated: " + e))
            .join()
        );
        
        System.out.println("All employees processed!");
    }
}
