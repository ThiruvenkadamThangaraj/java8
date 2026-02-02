import java.util.*;
import java.util.stream.Collectors;

// Find employees with anagram names
public class EmployeeString17_AnagramNames {
    public static void main(String[] args) {
        List<Employee17> employees = Arrays.asList(
            new Employee17(1, "listen", "IT"),
            new Employee17(2, "silent", "HR"),
            new Employee17(3, "enlist", "Finance"),
            new Employee17(4, "Bob", "IT")
        );
        
        System.out.println("All employees:");
        employees.forEach(System.out::println);
        
        System.out.println("\nAnagram groups:");
        Map<String, List<Employee17>> anagramGroups = employees.stream()
                .collect(Collectors.groupingBy(
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

class Employee17 {
    private int id;
    private String name;
    private String department;
    
    public Employee17(int id, String name, String department) {
        this.id = id;
        this.name = name;
        this.department = department;
    }
    
    public int getId() { return id; }
    public String getName() { return name; }
    public String getDepartment() { return department; }
    
    @Override
    public String toString() {
        return "Employee17{id=" + id + ", name='" + name + "', dept='" + department + "'}";
    }
}
