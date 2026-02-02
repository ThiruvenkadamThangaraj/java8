import java.util.*;
import java.util.stream.Collectors;

// Create map of Employee22 ID to name
public class EmployeeString22_IdToNameMap {
    public static void main(String[] args) {
        List<Employee22> employees = Arrays.asList(
            new Employee22(1, "Alice", "IT"),
            new Employee22(2, "Bob", "HR"),
            new Employee22(3, "Charlie", "Finance")
        );
        
        System.out.println("All employees:");
        employees.forEach(System.out::println);
        
        Map<Integer, String> idToName = employees.stream()
                .collect(Collectors.toMap(
                    Employee22::getId,
                    Employee22::getName
                ));
        
        System.out.println("\nID to Name map:");
        idToName.forEach((id, name) -> 
            System.out.println("ID " + id + " -> " + name));
    }
}

class Employee22 {
    private int id;
    private String name;
    private String department;
    
    public Employee22(int id, String name, String department) {
        this.id = id;
        this.name = name;
        this.department = department;
    }
    
    public int getId() { return id; }
    public String getName() { return name; }
    public String getDepartment() { return department; }
    
    @Override
    public String toString() {
        return "Employee22{id=" + id + ", name='" + name + "', dept='" + department + "'}";
    }
}
