import java.util.function.*;

// Functional interface examples
public class Program23_FunctionalInterface {
    public static void main(String[] args) {
        // Predicate - takes input, returns boolean
        Predicate<Integer> isEven = n -> n % 2 == 0;
        System.out.println("Is 4 even? " + isEven.test(4));
        
        // Function - takes input, returns output
        Function<String, Integer> stringLength = String::length;
        System.out.println("Length of 'Hello': " + stringLength.apply("Hello"));
        
        // Consumer - takes input, returns nothing
        Consumer<String> printer = s -> System.out.println("Value: " + s);
        printer.accept("Test");
        
        // Supplier - takes nothing, returns output
        Supplier<Double> randomSupplier = Math::random;
        System.out.println("Random: " + randomSupplier.get());
        
        // BiFunction - takes two inputs, returns output
        BiFunction<Integer, Integer, Integer> add = (a, b) -> a + b;
        System.out.println("5 + 3 = " + add.apply(5, 3));
    }
}
