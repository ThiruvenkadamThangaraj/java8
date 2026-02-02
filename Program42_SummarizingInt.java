import java.util.*;
import java.util.stream.Collectors;

// Collectors.summarizingInt() example
public class Program42_SummarizingInt {
    public static void main(String[] args) {
        List<Product> products = Arrays.asList(
            new Product("Laptop", 1200),
            new Product("Phone", 800),
            new Product("Tablet", 500),
            new Product("Watch", 300)
        );
        
        IntSummaryStatistics stats = products.stream()
                .collect(Collectors.summarizingInt(Product::getPrice));
        
        System.out.println("Price Statistics:");
        System.out.println("Count: " + stats.getCount());
        System.out.println("Sum: " + stats.getSum());
        System.out.println("Min: " + stats.getMin());
        System.out.println("Max: " + stats.getMax());
        System.out.println("Average: " + stats.getAverage());
    }
}

class Product {
    private String name;
    private int price;
    
    public Product(String name, int price) {
        this.name = name;
        this.price = price;
    }
    
    public String getName() { return name; }
    public int getPrice() { return price; }
}
