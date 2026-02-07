import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
public class anagrams {
    
    public static void main(String args[]){
        String str = "listen";
        String str1 = "silent";
        String str2="hello";
        String str3="world";


        boolean anagrams= areAnagrams(str,str1);
        boolean anagrams1= areAnagrams1(str2,str3);
        System.out.println(anagrams?true:false);
        System.out.println(anagrams1?true:false);
    }
    private static boolean areAnagrams(String string1,String string2){
        if(string1.length()!=string2.length())return false;

        char[]ca = string1.toLowerCase().toCharArray();
        char[] cb = string2.toLowerCase().toCharArray();
        
        Arrays.sort(ca);
        Arrays.sort(cb);
        return Arrays.equals(ca,cb);

    }
    
    private static boolean areAnagrams1(String a, String b) {
        if (a.length() != b.length()) return false;

        Map<Character, Long> countA = a.toLowerCase().chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        Map<Character, Long> countB = b.toLowerCase().chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        return countA.equals(countB);
    }
}
