import java.util.*;

// Check if Employee37 names are substrings of each other
public class EmployeeString37_SubstringCheck {
    public static void main(String[] args) {
        List<Employee37> employees = Arrays.asList(
            new Employee37(1, "Alexander", "IT"),
            new Employee37(2, "Alex", "HR"),
            new Employee37(3, "Bob", "Finance")
        );
        
        System.out.println("All employees:");
        employees.forEach(System.out::println);
        
        System.out.println("\nSubstring relationships:");
        for (int i = 0; i < employees.size(); i++) {
            for (int j = i + 1; j < employees.size(); j++) {
                Employee37 e1 = employees.get(i);
                Employee37 e2 = employees.get(j);
                
                if (e1.getName().contains(e2.getName())) {
                    System.out.println(e1.getName() + " contains " + e2.getName());
                } else if (e2.getName().contains(e1.getName())) {
                    System.out.println(e2.getName() + " contains " + e1.getName());
                }
            }
        }
    }
}

class Employee37 {
    private int id;
    private String name;
    private String department;
    
    public Employee37(int id, String name, String department) {
        this.id = id;
        this.name = name;
        this.department = department;
    }
    
    public int getId() { return id; }
    public String getName() { return name; }
    public String getDepartment() { return department; }
    
    @Override
    public String toString() {
        return "Employee37{id=" + id + ", name='" + name + "', dept='" + department + "'}";
    }
}
