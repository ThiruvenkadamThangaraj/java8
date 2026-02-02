import java.util.*;
import java.util.stream.Collectors;

// Partition employees by name length
public class EmployeeString25_PartitionByNameLength {
    public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(
            new Employee(1, "Alice", 50000),
            new Employee(2, "Bo", 60000),
            new Employee(3, "Christopher", 55000),
            new Employee(4, "Sam", 65000)
        );
        
        System.out.println("All employees:");
        employees.forEach(System.out::println);
        
        Map<Boolean, List<Employee>> partitioned = employees.stream()
                .collect(Collectors.partitioningBy(
                    emp -> emp.getName().length() > 5
                ));
        
        System.out.println("\nNames longer than 5 characters:");
        partitioned.get(true).forEach(System.out::println);
        
        System.out.println("\nNames 5 or fewer characters:");
        partitioned.get(false).forEach(System.out::println);
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
