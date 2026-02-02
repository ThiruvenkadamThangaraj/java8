import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(
                new Employee(1, "Charlie"),
                new Employee(3, "Alice"),
                new Employee(2, "Bob"),
                new Employee(1, "Alice"),
                new Employee(1, "Charlie"), // duplicate
                new Employee(2, "Bob") // duplicate
        );

        System.out.println("Original list:");
        employees.forEach(System.out::println);

        // Remove duplicates using distinct() - requires equals() and hashCode()
        System.out.println("\n--- Method 1: Using distinct() ---");
        List<Employee> uniqueEmployees = employees.stream()
                .distinct()
                .collect(Collectors.toList());
        System.out.println("Unique employees:");
        uniqueEmployees.forEach(System.out::println);

        // Remove duplicates based on id
        System.out.println("\n--- Method 2: Remove duplicates by ID ---");
        List<Employee> uniqueById = employees.stream()
                .collect(Collectors.toMap(
                        Employee::getId,
                        e -> e,
                        (existing, replacement) -> existing))
                .values()
                .stream()
                .collect(Collectors.toList());
        uniqueById.forEach(System.out::println);

        // Remove duplicates based on name
        System.out.println("\n--- Method 3: Remove duplicates by Name ---");
        List<Employee> uniqueByName = employees.stream()
                .collect(Collectors.toMap(
                        Employee::getName,
                        e -> e,
                        (existing, replacement) -> existing))
                .values()
                .stream()
                .collect(Collectors.toList());
        uniqueByName.forEach(System.out::println);

        // Remove duplicates based on both name and id
        System.out.println("\n--- Method 4: Remove duplicates by Name AND ID ---");
        List<Employee> uniqueByNameAndId = employees.stream()
                .collect(Collectors.toMap(
                        e -> e.getId() + "-" + e.getName(),
                        e -> e,
                        (existing, replacement) -> existing))
                .values()
                .stream()
                .collect(Collectors.toList());
        uniqueByNameAndId.forEach(System.out::println);

        // Using Set to remove duplicates
        System.out.println("\n--- Method 5: Using Set (requires equals/hashCode) ---");
        Set<Employee> uniqueSet = new LinkedHashSet<>(employees);
        System.out.println("Unique employees in Set:");
        uniqueSet.forEach(System.out::println);

        // ========== INTEGER DUPLICATE REMOVAL PROGRAM ==========
        System.out.println("\n\n========== INTEGER LIST - REMOVE DUPLICATES ==========");
        removeDuplicatesFromIntegers();

        // ========== SET OPERATIONS - COMMON & DUPLICATE ELEMENTS ==========
        System.out.println("\n\n========== SET OPERATIONS - COMMON & DUPLICATE ELEMENTS ==========");
        setOperations();
    }

    public static void removeDuplicatesFromIntegers() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 2, 4, 1, 5, 3, 6, 4, 1, 7, 5);
        
        System.out.println("Original integer list: " + numbers);
        
        // Method 1: Using distinct()
        System.out.println("\n--- Method 1: Using distinct() ---");
        List<Integer> uniqueNumbers = numbers.stream()
                .distinct()
                .collect(Collectors.toList());
        System.out.println("Unique numbers: " + uniqueNumbers);
        
        // Method 2: Using LinkedHashSet (maintains insertion order)
        System.out.println("\n--- Method 2: Using LinkedHashSet ---");
        Set<Integer> uniqueSet = new LinkedHashSet<>(numbers);
        System.out.println("Unique numbers: " + uniqueSet);
        
        // Method 3: Using HashSet (no order guarantee)
        System.out.println("\n--- Method 3: Using HashSet ---");
        Set<Integer> uniqueHashSet = new HashSet<>(numbers);
        System.out.println("Unique numbers: " + uniqueHashSet);
        
        // Method 4: Using TreeSet (sorted order)
        System.out.println("\n--- Method 4: Using TreeSet (sorted) ---");
        Set<Integer> uniqueSorted = new TreeSet<>(numbers);
        System.out.println("Unique numbers (sorted): " + uniqueSorted);
        
        // Method 5: distinct() with sorted
        System.out.println("\n--- Method 5: Using distinct() + sorted() ---");
        List<Integer> uniqueSortedList = numbers.stream()
                .distinct()
                .sorted()
                .collect(Collectors.toList());
        System.out.println("Unique numbers (sorted): " + uniqueSortedList);
        
        // Method 6: distinct() with custom sorting (descending)
        System.out.println("\n--- Method 6: Using distinct() + sorted(descending) ---");
        List<Integer> uniqueDescending = numbers.stream()
                .distinct()
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());
        System.out.println("Unique numbers (descending): " + uniqueDescending);
    }

    public static void setOperations() {
        // Create two sets with some common elements
        Set<Integer> set1 = new HashSet<>(Arrays.asList(1, 2, 3, 4, 5, 6));
        Set<Integer> set2 = new HashSet<>(Arrays.asList(4, 5, 6, 7, 8, 9));
        
        System.out.println("Set 1: " + set1);
        System.out.println("Set 2: " + set2);
        
        // Method 1: Find common elements (Intersection)
        System.out.println("\n--- Method 1: Common Elements (Intersection) ---");
        Set<Integer> commonElements = set1.stream()
                .filter(set2::contains)
                .collect(Collectors.toSet());
        System.out.println("Common elements: " + commonElements);
        
        // Method 2: Find common elements using retainAll
        System.out.println("\n--- Method 2: Common Elements (using retainAll) ---");
        Set<Integer> intersection = new HashSet<>(set1);
        intersection.retainAll(set2);
        System.out.println("Common elements: " + intersection);
        
        // Method 3: Union (All unique elements from both sets)
        System.out.println("\n--- Method 3: Union (All unique elements) ---");
        Set<Integer> union = new HashSet<>(set1);
        union.addAll(set2);
        System.out.println("Union: " + union);
        
        // Method 4: Union using Stream
        System.out.println("\n--- Method 4: Union using Stream ---");
        Set<Integer> unionStream = Set.of(set1, set2).stream()
                .flatMap(Set::stream)
                .collect(Collectors.toSet());
        System.out.println("Union: " + unionStream);
        
        // Method 5: Elements only in Set1 (Difference)
        System.out.println("\n--- Method 5: Elements only in Set1 ---");
        Set<Integer> onlyInSet1 = set1.stream()
                .filter(e -> !set2.contains(e))
                .collect(Collectors.toSet());
        System.out.println("Only in Set1: " + onlyInSet1);
        
        // Method 6: Elements only in Set2 (Difference)
        System.out.println("\n--- Method 6: Elements only in Set2 ---");
        Set<Integer> onlyInSet2 = set2.stream()
                .filter(e -> !set1.contains(e))
                .collect(Collectors.toSet());
        System.out.println("Only in Set2: " + onlyInSet2);
        
        // Method 7: Symmetric Difference (elements in either set but not in both)
        System.out.println("\n--- Method 7: Symmetric Difference ---");
        Set<Integer> symmetricDiff = new HashSet<>(set1);
        symmetricDiff.addAll(set2);
        Set<Integer> temp = new HashSet<>(set1);
        temp.retainAll(set2);
        symmetricDiff.removeAll(temp);
        System.out.println("Symmetric Difference: " + symmetricDiff);
        
        // Method 8: Using Lists to find duplicates between two lists
        System.out.println("\n--- Method 8: Find duplicates in Lists ---");
        List<Integer> list1 = Arrays.asList(1, 2, 3, 4, 5, 3, 2);
        List<Integer> list2 = Arrays.asList(3, 4, 5, 6, 7, 5, 4);
        System.out.println("List 1: " + list1);
        System.out.println("List 2: " + list2);
        
        Set<Integer> commonInLists = list1.stream()
                .filter(list2::contains)
                .collect(Collectors.toSet());
        System.out.println("Common elements: " + commonInLists);
    }
}

class Employee {
    private final int id;
    private final String name;

    public Employee(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Employee{id=" + id + ", name='" + name + "'}";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return id == employee.id && Objects.equals(name, employee.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }
}
