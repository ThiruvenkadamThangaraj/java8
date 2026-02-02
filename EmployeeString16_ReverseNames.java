import java.util.*;

// Reverse Employee16 names
public class EmployeeString16_ReverseNames {
    public static void main(String[] args) {
        List<Employee16> employees = Arrays.asList(
            new Employee16(1, "Alice", 50000),
            new Employee16(2, "Bob", 60000),
            new Employee16(3, "Charlie", 55000)
        );
        
        System.out.println("Original employees:");
        employees.forEach(System.out::println);
        
        System.out.println("\nReversed names:");
        employees.stream()
                .map(emp -> emp.getName() + " -> " + 
                    new StringBuilder(emp.getName()).reverse().toString())
                .forEach(System.out::println);
    }
}

class Employee16 {
    private int id;
    private String name;
    private double salary;
    
    public Employee16(int id, String name, double salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }
    
    public int getId() { return id; }
    public String getName() { return name; }
    public double getSalary() { return salary; }
    
    @Override
    public String toString() {
        return "Employee16{id=" + id + ", name='" + name + "', salary=" + salary + "}";
    }
}
