import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

// Remove duplicates based on specific property
public class Program30_DistinctByProperty {
    public static void main(String[] args) {
        List<Employee30> employees = Arrays.asList(
            new Employee30(1, "Alice"),
            new Employee30(2, "Bob"),
            new Employee30(3, "Alice"),
            new Employee30(4, "Charlie")
        );
        
        System.out.println("Original:");
        employees.forEach(System.out::println);
        
        System.out.println("\nDistinct by name:");
        List<Employee30> distinctByName = employees.stream()
                .filter(distinctByKey(Employee30::getName))
                .collect(Collectors.toList());
        distinctByName.forEach(System.out::println);
    }
    
    public static <T> Predicate<T> distinctByKey(Function<? super T, ?> keyExtractor) {
        Set<Object> seen = ConcurrentHashMap.newKeySet();
        return t -> seen.add(keyExtractor.apply(t));
    }
}

class Employee30 {
    private int id;
    private String name;
    
    public Employee30(int id, String name) {
        this.id = id;
        this.name = name;
    }
    
    public int getId() { return id; }
    public String getName() { return name; }
    
    @Override
    public String toString() {
        return "Employee30{id=" + id + ", name='" + name + "'}";
    }
}
