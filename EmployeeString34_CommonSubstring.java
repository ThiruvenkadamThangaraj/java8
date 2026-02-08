import java.util.*;

// Find common substring in Employee34 names
public class EmployeeString34_CommonSubstring {
    public static void main(String[] args) {
        List<Employee34> employees = Arrays.asList(
            new Employee34(1, "Johnson", "IT"),
            new Employee34(2, "Johnston", "HR"),
            new Employee34(3, "Johnstone", "Finance")
        );
        
        System.out.println("All employees:");
        employees.forEach(System.out::println);
        
        String first = employees.get(0).getName();
        String commonPrefix = first;
        
        for (int idx = 0; idx < employees.size(); idx++) {
            Employee34 emp = employees.get(idx);
            String name = emp.getName();
            int minLen = Math.min(commonPrefix.length(), name.length());
            int i = 0;
            while (i < minLen && commonPrefix.charAt(i) == name.charAt(i)) {
                i++;
            }
            commonPrefix = commonPrefix.substring(0, i);
        }
        
        System.out.println("\nCommon prefix: '" + commonPrefix + "'");
    }
}

class Employee34 {
    private int id;
    private String name;
    private String department;
    
    public Employee34(int id, String name, String department) {
        this.id = id;
        this.name = name;
        this.department = department;
    }
    
    public int getId() { return id; }
    public String getName() { return name; }
    public String getDepartment() { return department; }
    
    @Override
    public String toString() {
        return "Employee34{id=" + id + ", name='" + name + "', dept='" + department + "'}";
    }
}
