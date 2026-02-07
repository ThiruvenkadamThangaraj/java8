import java.util.stream.IntStream;

public class StringReverseJava8 {
    public static void main(String[] args) {
        String input = "Hello";
        System.out.println("Original: " + input);
        System.out.println("Reversed: " + reverse(input));
    }

    private static String reverse(String input) {
        return IntStream.range(0, input.length())
                .map(i -> input.charAt(input.length() - i - 1))
                .collect(StringBuilder::new,
                        (sb, c) -> sb.append((char) c),
                        StringBuilder::append)
                .toString();
    }
}
