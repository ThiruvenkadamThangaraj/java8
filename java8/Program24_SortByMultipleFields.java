import java.util.*;
import java.util.stream.Collectors;

// Sort by multiple fields
public class Program24_SortByMultipleFields {
    public static void main(String[] args) {
        List<Person> people = Arrays.asList(
            new Person("Alice", 30),
            new Person("Bob", 25),
            new Person("Alice", 25),
            new Person("Charlie", 30)
        );
        
        System.out.println("Original:");
        people.forEach(System.out::println);
        
        System.out.println("\nSorted by name, then age:");
        List<Person> sorted = people.stream()
                .sorted(Comparator.comparing(Person::getName)
                        .thenComparing(Person::getAge))
                .collect(Collectors.toList());
        sorted.forEach(System.out::println);
    }
}

class Person {
    private String name;
    private int age;
    
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
    
    public String getName() { return name; }
    public int getAge() { return age; }
    
    @Override
    public String toString() {
        return "Person{name='" + name + "', age=" + age + "}";
    }
}
