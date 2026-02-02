

// Calculate name similarity percentage
public class EmployeeString45_NameSimilarityPercentage {
    public static void main(String[] args) {
        Employee emp1 = new Employee(1, "Alice", 50000);
        Employee emp2 = new Employee(2, "Alicia", 60000);
        Employee emp3 = new Employee(3, "Bob", 55000);
        
        System.out.println("Name similarity percentages:");
        
        double similarity1 = calculateSimilarity(emp1.getName(), emp2.getName());
        System.out.println(emp1.getName() + " vs " + emp2.getName() + ": " + 
            String.format("%.2f%%", similarity1));
        
        double similarity2 = calculateSimilarity(emp1.getName(), emp3.getName());
        System.out.println(emp1.getName() + " vs " + emp3.getName() + ": " + 
            String.format("%.2f%%", similarity2));
    }
    
    static double calculateSimilarity(String s1, String s2) {
        int maxLen = Math.max(s1.length(), s2.length());
        if (maxLen == 0) return 100.0;
        
        int distance = levenshteinDistance(s1, s2);
        return ((maxLen - distance) * 100.0) / maxLen;
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

class Employee {
    private int id;
    private String name;
    private double salary;
    
    public Employee(int id, String name, double salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }
    
    public int getId() { return id; }
    public String getName() { return name; }
    public double getSalary() { return salary; }
    
    @Override
    public String toString() {
        return "Employee{id=" + id + ", name='" + name + "', salary=" + salary + "}";
    }
}
