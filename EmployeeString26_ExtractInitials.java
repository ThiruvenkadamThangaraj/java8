import java.util.*;

// Extract initials from Employee26 names
public class EmployeeString26_ExtractInitials {
    public static void main(String[] args) {
        List<Employee26> employees = Arrays.asList(
            new Employee26(1, "John Smith", 50000),
            new Employee26(2, "Alice Bob", 60000),
            new Employee26(3, "Charlie David Eve", 55000)
        );
        
        System.out.println("Employee26 initials:");
        employees.forEach(emp -> {
            String initials = Arrays.stream(emp.getName().split(" "))
                    .map(word -> String.valueOf(word.charAt(0)))
                    .reduce("", String::concat);
            System.out.println(emp.getName() + " -> " + initials);
        });
    }
}

class Employee26 {
    private int id;
    private String name;
    private double salary;
    
    public Employee26(int id, String name, double salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }
    
    public int getId() { return id; }
    public String getName() { return name; }
    public double getSalary() { return salary; }
    
    @Override
    public String toString() {
        return "Employee26{id=" + id + ", name='" + name + "', salary=" + salary + "}";
    }
}
