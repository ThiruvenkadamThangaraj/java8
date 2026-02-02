import java.util.*;

// Extract initials from employee names
public class EmployeeString26_ExtractInitials {
    public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(
            new Employee(1, "John Smith", 50000),
            new Employee(2, "Alice Bob", 60000),
            new Employee(3, "Charlie David Eve", 55000)
        );
        
        System.out.println("Employee initials:");
        employees.forEach(emp -> {
            String initials = Arrays.stream(emp.getName().split(" "))
                    .map(word -> String.valueOf(word.charAt(0)))
                    .reduce("", String::concat);
            System.out.println(emp.getName() + " -> " + initials);
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
