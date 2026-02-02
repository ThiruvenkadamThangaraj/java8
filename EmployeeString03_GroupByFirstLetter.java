import java.util.*;
import java.util.stream.Collectors;

// Group employees by first letter of name
public class EmployeeString03_GroupByFirstLetter {
    public static void main(String[] args) {
        List<Employee03> employees = Arrays.asList(
            new Employee03(1, "Alice", "IT"),
            new Employee03(2, "Bob", "HR"),
            new Employee03(3, "Andrew", "IT"),
            new Employee03(4, "Charlie", "Finance"),
            new Employee03(5, "Amanda", "HR")
        );
        
        System.out.println("All employees:");
        employees.forEach(System.out::println);
        
        System.out.println("\nGrouped by first letter:");
        Map<Character, List<Employee03>> grouped = employees.stream()
                .collect(Collectors.groupingBy(
                    emp -> emp.getName().charAt(0)
                ));
        
        grouped.forEach((letter, empList) -> {
            System.out.println("\n" + letter + ":");
            empList.forEach(System.out::println);
        });
    }
}

class Employee03 {
    private int id;
    private String name;
    private String department;
    
    public Employee03(int id, String name, String department) {
        this.id = id;
        this.name = name;
        this.department = department;
    }
    
    public int getId() { return id; }
    public String getName() { return name; }
    public String getDepartment() { return department; }
    
    @Override
    public String toString() {
        return "Employee03{id=" + id + ", name='" + name + "', dept='" + department + "'}";
    }
}
