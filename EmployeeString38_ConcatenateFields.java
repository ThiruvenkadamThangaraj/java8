import java.util.*;

// Concatenate department and name with separator
public class EmployeeString38_ConcatenateFields {
    public static void main(String[] args) {
        List<Employee38> employees = Arrays.asList(
            new Employee38(1, "Alice", "IT"),
            new Employee38(2, "Bob", "HR"),
            new Employee38(3, "Charlie", "Finance")
        );
        
        System.out.println("Concatenated department and name:");
        employees.forEach(emp -> {
            String combined = emp.getDepartment() + " - " + emp.getName();
            System.out.println(combined);
        });
        
        System.out.println("\nWith different separator:");
        employees.forEach(emp -> {
            String combined = String.join(" :: ", emp.getDepartment(), emp.getName());
            System.out.println(combined);
        });
    }
}

class Employee38 {
    private int id;
    private String name;
    private String department;
    
    public Employee38(int id, String name, String department) {
        this.id = id;
        this.name = name;
        this.department = department;
    }
    
    public int getId() { return id; }
    public String getName() { return name; }
    public String getDepartment() { return department; }
    
    @Override
    public String toString() {
        return "Employee38{id=" + id + ", name='" + name + "', dept='" + department + "'}";
    }
}
