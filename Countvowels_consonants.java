import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Countvowels_consonants {

    public static void main(String[] args) {
        String str = "Hello World";
        int vowels = 0;
        int consonants = 0;

        for (int i = 0; i < str.length(); i++) {
            char ch = Character.toLowerCase(str.charAt(i));
            if (ch >= 'a' && ch <= 'z') {
                if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
                    vowels++;
                } else {
                    consonants++;
                }
            }
        }
        String str1 = "Hello World";
        System.out.println("chars: " + str1.chars()
            .mapToObj(c -> String.valueOf((char) c))
            .collect(Collectors.joining(", ")));
        long vowels1 = str1.chars()
                .map(Character::toLowerCase)
                .filter(ch -> ch >= 'a' && ch <= 'z')
                .filter(ch -> ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u')
                .count();

        long consonants1 = str1.chars()
                .map(Character::toLowerCase)
                .filter(ch -> ch >= 'a' && ch <= 'z')
                .filter(ch -> ch != 'a' && ch != 'e' && ch != 'i' && ch != 'o' && ch != 'u')
                .count();

        System.out.println("Vowels: " + vowels);
        System.out.println("Consonants: " + consonants);

        System.out.println("Vowels: " + vowels1);
        System.out.println("Consonants: " + consonants1);
    }
}
