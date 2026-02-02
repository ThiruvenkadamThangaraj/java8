import java.util.*;

// Sort employees by custom string comparator
public class EmployeeString47_CustomComparator {
    public static void main(String[] args) {
        List<Employee47> employees = Arrays.asList(
            new Employee47(1, "Alice", 50000),
            new Employee47(2, "alice", 60000),
            new Employee47(3, "ALICE", 55000),
            new Employee47(4, "Bob", 65000)
        );
        
        System.out.println("Original:");
        employees.forEach(System.out::println);
        
        // Natural order (case-sensitive)
        System.out.println("\nNatural order sort:");
        employees.stream()
                .sorted(Comparator.comparing(Employee47::getName))
                .forEach(System.out::println);
        
        // Case-insensitive
        System.out.println("\nCase-insensitive sort:");
        employees.stream()
                .sorted(Comparator.comparing(
                    Employee47::getName, 
                    String.CASE_INSENSITIVE_ORDER))
                .forEach(System.out::println);
        
        // By length, then alphabetically
        System.out.println("\nBy length, then alphabetically:");
        employees.stream()
                .sorted(Comparator.comparing((Employee47 e) -> e.getName().length())
                        .thenComparing(Employee47::getName))
                .forEach(System.out::println);
    }
}

class Employee47 {
    private int id;
    private String name;
    private double salary;
    
    public Employee47(int id, String name, double salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }
    
    public int getId() { return id; }
    public String getName() { return name; }
    public double getSalary() { return salary; }
    
    @Override
    public String toString() {
        return "Employee47{id=" + id + ", name='" + name + "', salary=" + salary + "}";
    }
}
