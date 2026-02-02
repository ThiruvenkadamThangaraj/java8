import java.util.*;

// Compare Employee28 names alphabetically
public class EmployeeString28_CompareNamesAlphabetically {
    public static void main(String[] args) {
        Employee28 emp1 = new Employee28(1, "Alice", 50000);
        Employee28 emp2 = new Employee28(2, "Bob", 60000);
        Employee28 emp3 = new Employee28(3, "Alice", 55000);
        
        System.out.println("Comparing Employee28 names:");
        
        int comparison1 = emp1.getName().compareTo(emp2.getName());
        System.out.println(emp1.getName() + " vs " + emp2.getName() + ": " + comparison1);
        
        int comparison2 = emp1.getName().compareTo(emp3.getName());
        System.out.println(emp1.getName() + " vs " + emp3.getName() + ": " + comparison2);
        
        int comparison3 = emp2.getName().compareTo(emp1.getName());
        System.out.println(emp2.getName() + " vs " + emp1.getName() + ": " + comparison3);
        
        System.out.println("\nUsing Comparator:");
        Comparator<Employee28> nameComparator = Comparator.comparing(Employee28::getName);
        System.out.println("Result: " + nameComparator.compare(emp1, emp2));
    }
}

class Employee28 {
    private int id;
    private String name;
    private double salary;
    
    public Employee28(int id, String name, double salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }
    
    public int getId() { return id; }
    public String getName() { return name; }
    public double getSalary() { return salary; }
    
    @Override
    public String toString() {
        return "Employee28{id=" + id + ", name='" + name + "', salary=" + salary + "}";
    }
}
