import java.util.*;

// Sort employees by department and then by name
public class EmployeeString10_SortByDeptAndName {
    public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(
            new Employee(1, "Charlie", "IT"),
            new Employee(2, "Alice", "HR"),
            new Employee(3, "Bob", "IT"),
            new Employee(4, "David", "HR"),
            new Employee(5, "Eve", "Finance")
        );
        
        System.out.println("Original:");
        employees.forEach(System.out::println);
        
        System.out.println("\nSorted by department, then by name:");
        employees.stream()
                .sorted(Comparator.comparing(Employee::getDepartment)
                        .thenComparing(Employee::getName))
                .forEach(System.out::println);
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
