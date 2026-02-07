import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FirstNonRepeatingCharacters {

	private static Character firstNonRepeatingChar(String input) {
		if (input == null || input.isEmpty()) {
			return null;
		}

		int[] counts = new int[256];
		char[] chars = input.toCharArray();

		for (char ch : chars) {
			if (ch < 256) {
				counts[ch]++;
			}
		}

		for (char ch : chars) {
			if (ch < 256 && counts[ch] == 1) {
				return ch;
			}
		}

		return null;
	}

	private static Character firstNonRepeatingCharStream(String input) {
		if (input == null || input.isEmpty()) {
			return null;
		}

		Map<Character, Long> counts = input.chars()
				.mapToObj(ch -> (char) ch)
				.collect(Collectors.groupingBy(
						Function.identity(),
						LinkedHashMap::new,
						Collectors.counting()));

		return counts.entrySet().stream()
				.filter(entry -> entry.getValue() == 1L)
				.map(Map.Entry::getKey)
				.findFirst()
				.orElse(null);
	}

	public static void main(String[] args) {
		String input = "swiss";
		Character result = firstNonRepeatingChar(input);
		Character resultStream = firstNonRepeatingCharStream(input);

		if (result == null) {
			System.out.println("No non-repeating character found.");
		} else {
			System.out.println("First non-repeating character: " + result);
		}

		if (resultStream == null) {
			System.out.println("No non-repeating character found (stream).");
		} else {
			System.out.println("First non-repeating character (stream): " + resultStream);
		}
	}
}
