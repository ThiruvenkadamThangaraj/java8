import java.util.*;

// Check if employee names are substrings of each other
public class EmployeeString37_SubstringCheck {
    public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(
            new Employee(1, "Alexander", "IT"),
            new Employee(2, "Alex", "HR"),
            new Employee(3, "Bob", "Finance")
        );
        
        System.out.println("All employees:");
        employees.forEach(System.out::println);
        
        System.out.println("\nSubstring relationships:");
        for (int i = 0; i < employees.size(); i++) {
            for (int j = i + 1; j < employees.size(); j++) {
                Employee e1 = employees.get(i);
                Employee e2 = employees.get(j);
                
                if (e1.getName().contains(e2.getName())) {
                    System.out.println(e1.getName() + " contains " + e2.getName());
                } else if (e2.getName().contains(e1.getName())) {
                    System.out.println(e2.getName() + " contains " + e1.getName());
                }
            }
        }
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
