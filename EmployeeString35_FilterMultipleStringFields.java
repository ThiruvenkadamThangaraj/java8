import java.util.*;

// Filter employees by multiple string fields
public class EmployeeString35_FilterMultipleStringFields {
    public static void main(String[] args) {
        List<Employee35> employees = Arrays.asList(
            new Employee35(1, "Alice", "IT", "New York"),
            new Employee35(2, "Bob", "HR", "Boston"),
            new Employee35(3, "Andrew", "IT", "Austin"),
            new Employee35(4, "Amanda", "Finance", "Atlanta")
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

class Employee35 {
    private int id;
    private String name;
    private String department;
    private String city;
    
    public Employee35(int id, String name, String department, String city) {
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
        return "Employee35{id=" + id + ", name='" + name + 
               "', dept='" + department + "', city='" + city + "'}";
    }
}
