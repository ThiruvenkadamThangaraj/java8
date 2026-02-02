import java.util.*;

// Search employees with fuzzy matching
public class EmployeeString46_FuzzySearch {
    public static void main(String[] args) {
        List<Employee46> employees = Arrays.asList(
            new Employee46(1, "Alice", "IT"),
            new Employee46(2, "Alicia", "HR"),
            new Employee46(3, "Bob", "Finance"),
            new Employee46(4, "Amanda", "IT")
        );
        
        String searchTerm = "Ali";
        int threshold = 3; // max edit distance
        
        System.out.println("All employees:");
        employees.forEach(System.out::println);
        
        System.out.println("\nFuzzy search for '" + searchTerm + 
                         "' (max distance: " + threshold + "):");
        employees.stream()
                .filter(emp -> levenshteinDistance(
                    emp.getName().toLowerCase(), 
                    searchTerm.toLowerCase()) <= threshold)
                .forEach(System.out::println);
    }
    
    static int levenshteinDistance(String s1, String s2) {
        int[][] dp = new int[s1.length() + 1][s2.length() + 1];
        for (int i = 0; i <= s1.length(); i++) dp[i][0] = i;
        for (int j = 0; j <= s2.length(); j++) dp[0][j] = j;
        
        for (int i = 1; i <= s1.length(); i++) {
            for (int j = 1; j <= s2.length(); j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j - 1], 
                                Math.min(dp[i - 1][j], dp[i][j - 1])) + 1;
                }
            }
        }
        return dp[s1.length()][s2.length()];
    }
}

class Employee46 {
    private int id;
    private String name;
    private String department;
    
    public Employee46(int id, String name, String department) {
        this.id = id;
        this.name = name;
        this.department = department;
    }
    
    public int getId() { return id; }
    public String getName() { return name; }
    public String getDepartment() { return department; }
    
    @Override
    public String toString() {
        return "Employee46{id=" + id + ", name='" + name + "', dept='" + department + "'}";
    }
}
