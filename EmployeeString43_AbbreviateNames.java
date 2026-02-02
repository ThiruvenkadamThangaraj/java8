import java.util.*;

// Abbreviate Employee43 names
public class EmployeeString43_AbbreviateNames {
    public static void main(String[] args) {
        List<Employee43> employees = Arrays.asList(
            new Employee43(1, "Christopher Alexander", 50000),
            new Employee43(2, "Bob", 60000),
            new Employee43(3, "Alexandria Marie Johnson", 55000)
        );
        
        System.out.println("Abbreviated names:");
        employees.forEach(emp -> {
            String abbreviated = emp.getName().length() > 15 
                ? emp.getName().substring(0, 15) + "..." 
                : emp.getName();
            System.out.println(emp.getName() + " -> " + abbreviated);
        });
    }
}

class Employee43 {
    private int id;
    private String name;
    private double salary;
    
    public Employee43(int id, String name, double salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }
    
    public int getId() { return id; }
    public String getName() { return name; }
    public double getSalary() { return salary; }
    
    @Override
    public String toString() {
        return "Employee43{id=" + id + ", name='" + name + "', salary=" + salary + "}";
    }
}
