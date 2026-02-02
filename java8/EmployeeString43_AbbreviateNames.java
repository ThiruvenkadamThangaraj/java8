import java.util.*;

// Abbreviate employee names
public class EmployeeString43_AbbreviateNames {
    public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(
            new Employee(1, "Christopher Alexander", 50000),
            new Employee(2, "Bob", 60000),
            new Employee(3, "Alexandria Marie Johnson", 55000)
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
