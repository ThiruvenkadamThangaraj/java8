import java.util.*;
import java.util.stream.Collectors;

// Complex Employee50 string operations combined
public class EmployeeString50_ComplexOperations {
    public static void main(String[] args) {
        List<Employee50> employees = Arrays.asList(
            new Employee50(1, "Alice Johnson", "IT", "New York"),
            new Employee50(2, "Bob Smith", "HR", "Boston"),
            new Employee50(3, "Charlie Brown", "IT", "Chicago"),
            new Employee50(4, "David Wilson", "Finance", "Dallas"),
            new Employee50(5, "Eve Anderson", "IT", "Atlanta")
        );
        
        System.out.println("All employees:");
        employees.forEach(System.out::println);
        
        // 1. Group by department and sort names
        System.out.println("\n--- Employees by Department (sorted) ---");
        employees.stream()
                .collect(Collectors.groupingBy(Employee50::getDepartment))
                .forEach((dept, empList) -> {
                    System.out.println("\n" + dept + ":");
                    empList.stream()
                            .sorted(Comparator.comparing(Employee50::getName))
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

class Employee50 {
    private int id;
    private String name;
    private String department;
    private String city;
    
    public Employee50(int id, String name, String department, String city) {
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
        return "Employee50{id=" + id + ", name='" + name + 
               "', dept='" + department + "', city='" + city + "'}";
    }
}
