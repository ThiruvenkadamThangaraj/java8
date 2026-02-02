import java.util.*;

// Filter employees by multiple string fields
public class EmployeeString35_FilterMultipleStringFields {
    public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(
            new Employee(1, "Alice", "IT", "New York"),
            new Employee(2, "Bob", "HR", "Boston"),
            new Employee(3, "Andrew", "IT", "Austin"),
            new Employee(4, "Amanda", "Finance", "Atlanta")
        );
        
        System.out.println("All employees:");
        employees.forEach(System.out::println);
        
        System.out.println("\nEmployees in IT AND name starts with 'A':");
        employees.stream()
                .filter(emp -> emp.getDepartment().equals("IT"))
                .filter(emp -> emp.getName().startsWith("A"))
                .forEach(System.out::println);
        
        System.out.println("\nEmployees in cities starting with 'A':");
        employees.stream()
                .filter(emp -> emp.getCity().startsWith("A"))
                .forEach(System.out::println);
    }
}

class Employee {
    private int id;
    private String name;
    private String department;
    private String city;
    
    public Employee(int id, String name, String department, String city) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.city = city;
    }
    
    public int getId() { return id; }
    public String getName() { return name; }
    public String getDepartment() { return department; }
    public String getCity() { return city; }
    
    @Override
    public String toString() {
        return "Employee{id=" + id + ", name='" + name + 
               "', dept='" + department + "', city='" + city + "'}";
    }
}
