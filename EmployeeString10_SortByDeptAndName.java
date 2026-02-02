import java.util.*;

// Sort employees by department and then by name
public class EmployeeString10_SortByDeptAndName {
    public static void main(String[] args) {
        List<Employee10> employees = Arrays.asList(
            new Employee10(1, "Charlie", "IT"),
            new Employee10(2, "Alice", "HR"),
            new Employee10(3, "Bob", "IT"),
            new Employee10(4, "David", "HR"),
            new Employee10(5, "Eve", "Finance")
        );
        
        System.out.println("Original:");
        employees.forEach(System.out::println);
        
        System.out.println("\nSorted by department, then by name:");
        employees.stream()
                .sorted(Comparator.comparing(Employee10::getDepartment)
                        .thenComparing(Employee10::getName))
                .forEach(System.out::println);
    }
}

class Employee10 {
    private int id;
    private String name;
    private String department;
    
    public Employee10(int id, String name, String department) {
        this.id = id;
        this.name = name;
        this.department = department;
    }
    
    public int getId() { return id; }
    public String getName() { return name; }
    public String getDepartment() { return department; }
    
    @Override
    public String toString() {
        return "Employee10{id=" + id + ", name='" + name + "', dept='" + department + "'}";
    }
}
