import java.util.*;
import java.util.stream.Collectors;

// Create map of employee ID to name
public class EmployeeString22_IdToNameMap {
    public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(
            new Employee(1, "Alice", "IT"),
            new Employee(2, "Bob", "HR"),
            new Employee(3, "Charlie", "Finance")
        );
        
        System.out.println("All employees:");
        employees.forEach(System.out::println);
        
        Map<Integer, String> idToName = employees.stream()
                .collect(Collectors.toMap(
                    Employee::getId,
                    Employee::getName
                ));
        
        System.out.println("\nID to Name map:");
        idToName.forEach((id, name) -> 
            System.out.println("ID " + id + " -> " + name));
    }
}

class Employee {
    private int id;
    private String name;
    private String department;
    
    public Employee(int id, String name, String department) {
        this.id = id;
        this.name = name;
        this.department = department;
    }
    
    public int getId() { return id; }
    public String getName() { return name; }
    public String getDepartment() { return department; }
    
    @Override
    public String toString() {
        return "Employee{id=" + id + ", name='" + name + "', dept='" + department + "'}";
    }
}
