import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

// Find employees with names having repeated characters
public class EmployeeString49_RepeatedCharacters {
    public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(
            new Employee(1, "Alice", "IT"),
            new Employee(2, "Bob", "HR"),
            new Employee(3, "Mississippi", "Finance"),
            new Employee(4, "Sam", "IT")
        );
        
        System.out.println("All employees:");
        employees.forEach(System.out::println);
        
        System.out.println("\nEmployees with repeated characters:");
        employees.stream()
                .filter(emp -> hasRepeatedChars(emp.getName()))
                .forEach(emp -> {
                    System.out.println(emp.getName() + ": " + 
                        getRepeatedChars(emp.getName()));
                });
    }
    
    static boolean hasRepeatedChars(String name) {
        return name.toLowerCase().chars()
                .boxed()
                .collect(Collectors.groupingBy(
                    Function.identity(),
                    Collectors.counting()))
                .values().stream()
                .anyMatch(count -> count > 1);
    }
    
    static String getRepeatedChars(String name) {
        return name.toLowerCase().chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(
                    Function.identity(),
                    Collectors.counting()))
                .entrySet().stream()
                .filter(e -> e.getValue() > 1)
                .map(e -> e.getKey() + "(" + e.getValue() + ")")
                .collect(Collectors.joining(", "));
    }
}

class Employee {
    private int id;
    private String name;
    private String department;
    
    public Employee(int id, String name, String department) {
        this.id = id;
        this.name = name;
        this.department = department;
    }
    
    public int getId() { return id; }
    public String getName() { return name; }
    public String getDepartment() { return department; }
    
    @Override
    public String toString() {
        return "Employee{id=" + id + ", name='" + name + "', dept='" + department + "'}";
    }
}
