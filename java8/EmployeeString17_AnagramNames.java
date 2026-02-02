import java.util.*;
import java.util.stream.Collectors;

// Find employees with anagram names
public class EmployeeString17_AnagramNames {
    public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(
            new Employee(1, "listen", "IT"),
            new Employee(2, "silent", "HR"),
            new Employee(3, "enlist", "Finance"),
            new Employee(4, "Bob", "IT")
        );
        
        System.out.println("All employees:");
        employees.forEach(System.out::println);
        
        System.out.println("\nAnagram groups:");
        Map<String, List<mGroups = employees.stream()
                .collect(java.util.stream.Collectors.groupingBy(
                    emp -> {
                        char[] chars = emp.getName().toLowerCase().toCharArray();
                        Arrays.sort(chars);
                        return new String(chars);
                    }
                ));
        
        anagramGroups.values().stream()
                .filter(group -> group.size() > 1)
                .forEach(group -> {
                    System.out.println("\nAnagram group:");
                    group.forEach(System.out::println);
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
