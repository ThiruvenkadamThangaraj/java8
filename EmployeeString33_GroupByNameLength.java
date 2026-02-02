import java.util.*;
import java.util.stream.Collectors;

// Group employees by name length
public class EmployeeString33_GroupByNameLength {
    public static void main(String[] args) {
        List<Employee33> employees = Arrays.asList(
            new Employee33(1, "Alice", "IT"),
            new Employee33(2, "Bo", "HR"),
            new Employee33(3, "Charlie", "Finance"),
            new Employee33(4, "Sam", "IT"),
            new Employee33(5, "Amanda", "HR")
        );
        
        System.out.println("All employees:");
        employees.forEach(System.out::println);
        
        System.out.println("\nGrouped by name length:");
        Map<Integer, List<Employee33>> grouped = employees.stream()
                .collect(Collectors.groupingBy(
                    emp -> emp.getName().length()
                ));
        
        grouped.forEach((length, empList) -> {
            System.out.println("\nLength " + length + ":");
            empList.forEach(System.out::println);
        });
    }
}

class Employee33 {
    private int id;
    private String name;
    private String department;
    
    public Employee33(int id, String name, String department) {
        this.id = id;
        this.name = name;
        this.department = department;
    }
    
    public int getId() { return id; }
    public String getName() { return name; }
    public String getDepartment() { return department; }
    
    @Override
    public String toString() {
        return "Employee33{id=" + id + ", name='" + name + "', dept='" + department + "'}";
    }
}
