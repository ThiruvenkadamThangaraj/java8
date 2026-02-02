import java.util.*;
import java.util.stream.Collectors;

// Parallel stream processing
public class Program20_ParallelStream {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        
        System.out.println("Numbers: " + numbers);
        
        // Sequential processing
        long startSeq = System.currentTimeMillis();
        List<Integer> seqResult = numbers.stream()
                .map(n -> n * 2)
                .collect(Collectors.toList());
        long endSeq = System.currentTimeMillis();
        
        System.out.println("Sequential result: " + seqResult);
        System.out.println("Time: " + (endSeq - startSeq) + "ms");
        
        // Parallel processing
        long startPar = System.currentTimeMillis();
        List<Integer> parResult = numbers.parallelStream()
                .map(n -> n * 2)
                .collect(Collectors.toList());
        long endPar = System.currentTimeMillis();
        
        System.out.println("\nParallel result: " + parResult);
        System.out.println("Time: " + (endPar - startPar) + "ms");
    }
}
