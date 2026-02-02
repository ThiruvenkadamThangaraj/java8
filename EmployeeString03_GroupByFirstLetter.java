import java.util.*;
import java.util.stream.Collectors;

// Group employees by first letter of name
public class EmployeeString03_GroupByFirstLetter {
    public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(
            new Employee(1, "Alice", "IT"),
            new Employee(2, "Bob", "HR"),
            new Employee(3, "Andrew", "IT"),
            new Employee(4, "Charlie", "Finance"),
            new Employee(5, "Amanda", "HR")
        );
        
        System.out.println("All employees:");
        employees.forEach(System.out::println);
        
        System.out.println("\nGrouped by first letter:");
        Map<Character, List<Employee>> grouped = employees.stream()
                .collect(Collectors.groupingBy(
                    emp -> emp.getName().charAt(0)
                ));
        
        grouped.forEach((letter, empList) -> {
            System.out.println("\n" + letter + ":");
            empList.forEach(System.out::println);
        });
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
