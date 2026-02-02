import java.util.*;
import java.util.stream.Collectors;

// Complex employee string operations combined
public class EmployeeString50_ComplexOperations {
    public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(
            new Employee(1, "Alice Johnson", "IT", "New York"),
            new Employee(2, "Bob Smith", "HR", "Boston"),
            new Employee(3, "Charlie Brown", "IT", "Chicago"),
            new Employee(4, "David Wilson", "Finance", "Dallas"),
            new Employee(5, "Eve Anderson", "IT", "Atlanta")
        );
        
        System.out.println("All employees:");
        employees.forEach(System.out::println);
        
        // 1. Group by department and sort names
        System.out.println("\n--- Employees by Department (sorted) ---");
        employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment))
                .forEach((dept, empList) -> {
                    System.out.println("\n" + dept + ":");
                    empList.stream()
                            .sorted(Comparator.comparing(Employee::getName))
                            .forEach(System.out::println);
                });
        
        // 2. Find employees in IT whose name contains "i"
        System.out.println("\n--- IT employees with 'i' in name ---");
        employees.stream()
                .filter(emp -> emp.getDepartment().equals("IT"))
                .filter(emp -> emp.getName().toLowerCase().contains("i"))
                .forEach(System.out::println);
        
        // 3. Create summary string
        String summary = employees.stream()
                .map(emp -> emp.getName().split(" ")[0])
                .collect(Collectors.joining(", ", "Team: [", "]"));
        System.out.println("\n" + summary);
        
        // 4. Statistics
        System.out.println("\n--- Name Statistics ---");
        IntSummaryStatistics stats = employees.stream()
                .mapToInt(emp -> emp.getName().length())
                .summaryStatistics();
        System.out.println("Average name length: " + stats.getAverage());
        System.out.println("Longest name length: " + stats.getMax());
        System.out.println("Shortest name length: " + stats.getMin());
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
