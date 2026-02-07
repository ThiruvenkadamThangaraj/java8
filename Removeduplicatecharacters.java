import java.util.Map;
import java.util.stream.Collectors;

public class Removeduplicatecharacters {
    
    public static void main(String args[]){
        String str = "removeDuplicateCharacters";

     String removeDuplicates = str.chars().distinct().mapToObj(c->String.valueOf((char)c)).collect(Collectors.joining());
     System.out.println(removeDuplicates);
    }
}
