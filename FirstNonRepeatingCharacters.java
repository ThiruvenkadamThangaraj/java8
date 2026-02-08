import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FirstNonRepeatingCharacters {

    public static Character firstNonRepeatingCharStream(String input){

		Map<Character,Long> nonRepeatingCharacterStream=input.chars().mapToObj(c->(char)c).collect(Collectors.groupingBy(Function.identity(),LinkedHashMap::new,Collectors.counting()));
		return nonRepeatingCharacterStream.entrySet().stream().filter(entry->entry.getValue()==1).map(Map.Entry::getKey).findFirst().orElse(null);
        


    
    }
	

	public static void main(String[] args) {
		String input = "swiss";
//		Character result = firstNonRepeatingChar(input);
		Character resultStream = firstNonRepeatingCharStream(input);

	

		if (resultStream == null) {
			System.out.println("No non-repeating character found (stream).");
		} else {
			System.out.println("First non-repeating character (stream): " + resultStream);
		}
	}
}
