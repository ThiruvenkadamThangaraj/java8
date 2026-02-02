

// Check Employee31 name equality with equals() vs ==
public class EmployeeString31_StringEqualityComparison {
    public static void main(String[] args) {
        Employee31 emp1 = new Employee31(1, "Alice", 50000);
        Employee31 emp2 = new Employee31(2, "Alice", 60000);
        Employee31 emp3 = new Employee31(3, new String("Alice"), 55000);
        
        System.out.println("String equality comparisons:");
        
        // Using equals
        System.out.println("emp1.name.equals(emp2.name): " + 
            emp1.getName().equals(emp2.getName()));
        
        // Using ==
        System.out.println("emp1.name == emp2.name: " + 
            (emp1.getName() == emp2.getName()));
        
        System.out.println("emp1.name == emp3.name: " + 
            (emp1.getName() == emp3.getName()));
        
        // Using intern
        System.out.println("emp1.name == emp3.name.intern(): " + 
            (emp1.getName() == emp3.getName().intern()));
    }
}

class Employee31 {
    private int id;
    private String name;
    private double salary;
    
    public Employee31(int id, String name, double salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }
    
    public int getId() { return id; }
    public String getName() { return name; }
    public double getSalary() { return salary; }
    
    @Override
    public String toString() {
        return "Employee31{id=" + id + ", name='" + name + "', salary=" + salary + "}";
    }
}
