import java.util.Optional;

// Optional class basics
public class Program21_OptionalBasics {
    public static void main(String[] args) {
        // Creating Optional
        Optional<String> nonEmpty = Optional.of("Hello");
        Optional<String> nullable = Optional.ofNullable(null);
        Optional<String> empty = Optional.empty();
        
        // isPresent and ifPresent
        System.out.println("nonEmpty present? " + nonEmpty.isPresent());
        nonEmpty.ifPresent(s -> System.out.println("Value: " + s));
        
        // orElse
        System.out.println("Empty value or default: " + empty.orElse("Default"));
        
        // orElseGet
        System.out.println("Empty value or supplier: " + 
            empty.orElseGet(() -> "Generated Default"));
        
        // map
        Optional<Integer> length = nonEmpty.map(String::length);
        System.out.println("Length: " + length.get());
        
        // filter
        Optional<String> filtered = nonEmpty.filter(s -> s.length() > 3);
        System.out.println("Filtered present? " + filtered.isPresent());
    }
}
