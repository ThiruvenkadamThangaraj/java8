import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
public class Findduplicatecharactersandtheircounts {
    public static void main(String args[]){

       String str = "thriuvenkadam the great master mind";
       Map<Character,Long> counts = str.chars().mapToObj(c->(char)c).filter(ch->ch!=' ').collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
       counts.entrySet().stream().filter(c->c.getValue()>1).forEach(c->System.out.println(c.getValue()+" "+c.getKey()));
    }
    
}
