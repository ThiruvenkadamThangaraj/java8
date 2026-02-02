import java.util.*;
import java.util.stream.Collectors;

// Count employees per department (String grouping)
public class EmployeeString11_CountByDepartment {
    public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(
            new Employee(1, "Alice", "IT"),
            new Employee(2, "Bob", "HR"),
            new Employee(3, "Charlie", "IT"),
            new Employee(4, "David", "Finance"),
            new Employee(5, "Eve", "IT"),
            new Employee(6, "Frank", "HR")
        );
        
        System.out.println("All employees:");
        employees.forEach(System.out::println);
        
        System.out.println("\nEmployee count by department:");
        Map<String, Long> countByDept = employees.stream()
                .collect(Collectors.groupingBy(
                    Employee::getDepartment,
                    Collectors.counting()
                ));
        
        countByDept.forEach((dept, count) -> 
            System.out.println(dept + ": " + count + " employees"));
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
