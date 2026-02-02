import java.util.*;

// Count vowels in employee names
public class EmployeeString20_CountVowelsInNames {
    public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(
            new Employee(1, "Alice", "IT"),
            new Employee(2, "Bob", "HR"),
            new Employee(3, "Education", "Finance")
        );
        
        System.out.println("Vowel count in employee names:");
        employees.forEach(emp -> {
            long vowelCount = emp.getName().toLowerCase().chars()
                    .filter(c -> "aeiou".indexOf(c) != -1)
                    .count();
            System.out.println(emp.getName() + ": " + vowelCount + " vowels");
        });
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
