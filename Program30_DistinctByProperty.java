import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

// Remove duplicates based on specific property
public class Program30_DistinctByProperty {
    public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(
            new Employee(1, "Alice"),
            new Employee(2, "Bob"),
            new Employee(3, "Alice"),
            new Employee(4, "Charlie")
        );
        
        System.out.println("Original:");
        employees.forEach(System.out::println);
        
        System.out.println("\nDistinct by name:");
        List<Employee> distinctByName = employees.stream()
                .filter(distinctByKey(Employee::getName))
                .collect(Collectors.toList());
        distinctByName.forEach(System.out::println);
    }
    
    public static <T> Predicate<T> distinctByKey(Function<? super T, ?> keyExtractor) {
        Set<Object> seen = ConcurrentHashMap.newKeySet();
        return t -> seen.add(keyExtractor.apply(t));
    }
}

class Employee {
    private int id;
    private String name;
    
    public Employee(int id, String name) {
        this.id = id;
        this.name = name;
    }
    
    public int getId() { return id; }
    public String getName() { return name; }
    
    @Override
    public String toString() {
        return "Employee{id=" + id + ", name='" + name + "'}";
    }
}
