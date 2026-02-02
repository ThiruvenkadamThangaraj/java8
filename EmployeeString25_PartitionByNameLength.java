import java.util.*;
import java.util.stream.Collectors;

// Partition employees by name length
public class EmployeeString25_PartitionByNameLength {
    public static void main(String[] args) {
        List<Employee25> employees = Arrays.asList(
            new Employee25(1, "Alice", 50000),
            new Employee25(2, "Bo", 60000),
            new Employee25(3, "Christopher", 55000),
            new Employee25(4, "Sam", 65000)
        );
        
        System.out.println("All employees:");
        employees.forEach(System.out::println);
        
        Map<Boolean, List<Employee25>> partitioned = employees.stream()
                .collect(Collectors.partitioningBy(
                    emp -> emp.getName().length() > 5
                ));
        
        System.out.println("\nNames longer than 5 characters:");
        partitioned.get(true).forEach(System.out::println);
        
        System.out.println("\nNames 5 or fewer characters:");
        partitioned.get(false).forEach(System.out::println);
    }
}

class Employee25 {
    private int id;
    private String name;
    private double salary;
    
    public Employee25(int id, String name, double salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }
    
    public int getId() { return id; }
    public String getName() { return name; }
    public double getSalary() { return salary; }
    
    @Override
    public String toString() {
        return "Employee25{id=" + id + ", name='" + name + "', salary=" + salary + "}";
    }
}
