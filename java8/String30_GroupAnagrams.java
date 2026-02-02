import java.util.*;
import java.util.stream.Collectors;

// Group anagrams together
public class String30_GroupAnagrams {
    public static void main(String[] args) {
        String[] words = {"eat", "tea", "tan", "ate", "nat", "bat"};
        
        System.out.println("Words: " + Arrays.toString(words));
        
        Map<String, List<String>> groups = Arrays.stream(words)
                .collect(Collectors.groupingBy(word -> {
                    char[] chars = word.toCharArray();
                    Arrays.sort(chars);
                    return new String(chars);
                }));
        
        System.out.println("\nAnagram groups:");
        groups.values().forEach(group -> System.out.println(group));
    }
}
