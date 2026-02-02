import java.util.*;

// Find employees with palindrome names
public class EmployeeString08_PalindromeNames {
    public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(
            new Employee(1, "Bob", "IT"),
            new Employee(2, "Anna", "HR"),
            new Employee(3, "Charlie", "Finance"),
            new Employee(4, "Hannah", "IT"),
            new Employee(5, "David", "HR")
        );
        
        System.out.println("All employees:");
        employees.forEach(System.out::println);
        
        System.out.println("\nEmployees with palindrome names:");
        employees.stream()
                .filter(emp -> isPalindrome(emp.getName()))
                .forEach(System.out::println);
    }
    
    static boolean isPalindrome(String name) {
        String lower = name.toLowerCase();
        return lower.equals(new StringBuilder(lower).reverse().toString());
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
