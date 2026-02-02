import java.util.*;

// Check if employee names contain vowels
public class EmployeeString05_NamesContainVowels {
    public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(
            new Employee(1, "Alice", "IT"),
            new Employee(2, "Brr", "HR"),
            new Employee(3, "Sky", "Finance"),
            new Employee(4, "Bob", "IT")
        );
        
        System.out.println("Employees with vowels in name:");
        employees.stream()
                .filter(emp -> emp.getName().toLowerCase().chars()
                        .anyMatch(c -> "aeiou".indexOf(c) != -1))
                .forEach(System.out::println);
        
        System.out.println("\nEmployees without vowels in name:");
        employees.stream()
                .filter(emp -> emp.getName().toLowerCase().chars()
                        .noneMatch(c -> "aeiou".indexOf(c) != -1))
                .forEach(System.out::println);
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
