import java.util.*;
import java.util.stream.Collectors;

// Count employees per department (String grouping)
public class EmployeeString11_CountByDepartment {
    public static void main(String[] args) {
        List<Employee11> employees = Arrays.asList(
            new Employee11(1, "Alice", "IT"),
            new Employee11(2, "Bob", "HR"),
            new Employee11(3, "Charlie", "IT"),
            new Employee11(4, "David", "Finance"),
            new Employee11(5, "Eve", "IT"),
            new Employee11(6, "Frank", "HR")
        );
        
        System.out.println("All employees:");
        employees.forEach(System.out::println);
        
        System.out.println("\nEmployee count by department:");
        Map<String, Long> countByDept = employees.stream()
                .collect(Collectors.groupingBy(
                    Employee11::getDepartment,
                    Collectors.counting()
                ));
        
        countByDept.forEach((dept, count) -> 
            System.out.println(dept + ": " + count + " employees"));
    }
}

class Employee11 {
    private int id;
    private String name;
    private String department;
    
    public Employee11(int id, String name, String department) {
        this.id = id;
        this.name = name;
        this.department = department;
    }
    
    public int getId() { return id; }
    public String getName() { return name; }
    public String getDepartment() { return department; }
    
    @Override
    public String toString() {
        return "Employee11{id=" + id + ", name='" + name + "', dept='" + department + "'}";
    }
}
