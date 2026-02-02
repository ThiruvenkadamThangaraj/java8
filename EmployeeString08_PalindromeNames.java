import java.util.*;

// Find employees with palindrome names
public class EmployeeString08_PalindromeNames {
    public static void main(String[] args) {
        List<Employee08> employees = Arrays.asList(
            new Employee08(1, "Bob", "IT"),
            new Employee08(2, "Anna", "HR"),
            new Employee08(3, "Charlie", "Finance"),
            new Employee08(4, "Hannah", "IT"),
            new Employee08(5, "David", "HR")
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

class Employee08 {
    private int id;
    private String name;
    private String department;
    
    public Employee08(int id, String name, String department) {
        this.id = id;
        this.name = name;
        this.department = department;
    }
    
    public int getId() { return id; }
    public String getName() { return name; }
    public String getDepartment() { return department; }
    
    @Override
    public String toString() {
        return "Employee08{id=" + id + ", name='" + name + "', dept='" + department + "'}";
    }
}
