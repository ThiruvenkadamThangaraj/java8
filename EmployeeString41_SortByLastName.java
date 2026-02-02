import java.util.*;

// Sort employees by last name (from full name)
public class EmployeeString41_SortByLastName {
    public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(
            new Employee(1, "John Smith", 50000),
            new Employee(2, "Alice Adams", 60000),
            new Employee(3, "Bob Williams", 55000),
            new Employee(4, "Charlie Brown", 65000)
        );
        
        System.out.println("Original:");
        employees.forEach(System.out::println);
        
        System.out.println("\nSorted by last name:");
        employees.stream()
                .sorted(Comparator.comparing(emp -> {
                    String[] parts = emp.getName().split(" ");
                    return parts.length > 1 ? parts[1] : parts[0];
                }))
                .forEach(System.out::println);
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
