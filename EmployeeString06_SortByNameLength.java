import java.util.*;

// Sort employees by name length
public class EmployeeString06_SortByNameLength {
    public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(
            new Employee(1, "Christopher", 50000),
            new Employee(2, "Bob", 60000),
            new Employee(3, "Alexandria", 55000),
            new Employee(4, "Sam", 65000)
        );
        
        System.out.println("Original:");
        employees.forEach(System.out::println);
        
        System.out.println("\nSorted by name length (ascending):");
        employees.stream()
                .sorted(Comparator.comparing(emp -> emp.getName().length()))
                .forEach(System.out::println);
        
        System.out.println("\nSorted by name length (descending):");
        employees.stream()
                .sorted(Comparator.comparing((Employee emp) -> emp.getName().length()).reversed())
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
