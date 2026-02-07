import java.util.stream.Collectors;

public class vowel_consonants {
    public static void main (String args[]){
        String str = "hello world";

        long vowel = str.chars().map(Character::toLowerCase).filter(ch->ch>='a' && ch<='z')
        .filter(ch->ch=='a'|| ch=='e'|| ch=='i' || ch=='o' || ch=='u')
        .count();
        System.out.println(vowel);

        long consonants = str.chars().map(Character::toLowerCase).filter(ch->ch>='a' && ch<='z')
        .filter(ch->ch!='a'|| ch!='e'|| ch!='i' || ch!='o' || ch!='u').count();
           System.out.println(consonants);
         str.chars().map(Character::toLowerCase).filter(ch->ch>='a' && ch<='z')
        .filter(ch->ch!='a'|| ch!='e'|| ch!='i' || ch!='o' || ch!='u').forEach(System.out::println);
           
           

}
}
