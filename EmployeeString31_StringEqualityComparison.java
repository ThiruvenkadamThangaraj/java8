

// Check employee name equality with equals() vs ==
public class EmployeeString31_StringEqualityComparison {
    public static void main(String[] args) {
        Employee emp1 = new Employee(1, "Alice", 50000);
        Employee emp2 = new Employee(2, "Alice", 60000);
        Employee emp3 = new Employee(3, new String("Alice"), 55000);
        
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
