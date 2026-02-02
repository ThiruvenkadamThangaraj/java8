import java.util.*;

// Format employee names (capitalize first letter)
public class EmployeeString32_FormatNames {
    public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(
            new Employee(1, "alice smith", 50000),
            new Employee(2, "BOB JOHNSON", 60000),
            new Employee(3, "cHaRlIe BrOwN", 55000)
        );
        
        System.out.println("Original names:");
        employees.forEach(emp -> System.out.println(emp.getName()));
        
        System.out.println("\nFormatted names (proper case):");
        employees.forEach(emp -> {
            String formatted = Arrays.stream(emp.getName().split(" "))
                    .map(word -> word.substring(0, 1).toUpperCase() + 
                                word.substring(1).toLowerCase())
                    .reduce("", (a, b) -> a + " " + b).trim();
            System.out.println(emp.getName() + " -> " + formatted);
        });
    }
}

class Employee {
    private int id;
    private String name;
    private double salary;
    
    public Employee(int id, String name, double salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }
    
    public int getId() { return id; }
    public String getName() { return name; }
    public double getSalary() { return salary; }
    
    @Override
    public String toString() {
        return "Employee{id=" + id + ", name='" + name + "', salary=" + salary + "}";
    }
}
