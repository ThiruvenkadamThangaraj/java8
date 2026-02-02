import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

// Find most frequent character in all Employee42 names
public class EmployeeString42_MostFrequentChar {
    public static void main(String[] args) {
        List<Employee42> employees = Arrays.asList(
            new Employee42(1, "Alice", "IT"),
            new Employee42(2, "Bob", "HR"),
            new Employee42(3, "Amanda", "Finance")
        );
        
        String allNames = employees.stream()
                .map(Employee42::getName)
                .reduce("", String::concat)
                .toLowerCase();
        
        Map<Character, Long> frequency = allNames.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(
                    Function.identity(),
                    Collectors.counting()
                ));
        
        System.out.println("Character frequency in all names:");
        frequency.entrySet().stream()
                .sorted(Map.Entry.<Character, Long>comparingByValue().reversed())
                .limit(5)
                .forEach(entry -> 
                    System.out.println(entry.getKey() + ": " + entry.getValue()));
    }
}

class Employee42 {
    private int id;
    private String name;
    private String department;
    
    public Employee42(int id, String name, String department) {
        this.id = id;
        this.name = name;
        this.department = department;
    }
    
    public int getId() { return id; }
    public String getName() { return name; }
    public String getDepartment() { return department; }
    
    @Override
    public String toString() {
        return "Employee42{id=" + id + ", name='" + name + "', dept='" + department + "'}";
    }
}
