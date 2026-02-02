import java.util.*;

// Count vowels in Employee20 names
public class EmployeeString20_CountVowelsInNames {
    public static void main(String[] args) {
        List<Employee20> employees = Arrays.asList(
            new Employee20(1, "Alice", "IT"),
            new Employee20(2, "Bob", "HR"),
            new Employee20(3, "Education", "Finance")
        );
        
        System.out.println("Vowel count in Employee20 names:");
        employees.forEach(emp -> {
            long vowelCount = emp.getName().toLowerCase().chars()
                    .filter(c -> "aeiou".indexOf(c) != -1)
                    .count();
            System.out.println(emp.getName() + ": " + vowelCount + " vowels");
        });
    }
}

class Employee20 {
    private int id;
    private String name;
    private String department;
    
    public Employee20(int id, String name, String department) {
        this.id = id;
        this.name = name;
        this.department = department;
    }
    
    public int getId() { return id; }
    public String getName() { return name; }
    public String getDepartment() { return department; }
    
    @Override
    public String toString() {
        return "Employee20{id=" + id + ", name='" + name + "', dept='" + department + "'}";
    }
}
