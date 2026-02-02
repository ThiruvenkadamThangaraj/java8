import java.util.*;

// Text justification - align text to given width
public class String50_TextJustification {
    public static void main(String[] args) {
        String[] words = {"This", "is", "an", "example", "of", "text", "justification."};
        int maxWidth = 16;
        
        System.out.println("Words: " + Arrays.toString(words));
        System.out.println("Max width: " + maxWidth);
        System.out.println("\nJustified text:");
        
        List<String> result = fullJustify(words, maxWidth);
        for (String line : result) {
            System.out.println("'" + line + "'");
        }
    }
    
    static List<String> fullJustify(String[] words, int maxWidth) {
        List<String> result = new ArrayList<>();
        int index = 0;
        
        while (index < words.length) {
            int count = words[index].length();
            int last = index + 1;
            
            while (last < words.length) {
                if (words[last].length() + count + 1 > maxWidth) break;
                count += words[last].length() + 1;
                last++;
            }
            
            StringBuilder sb = new StringBuilder();
            int numWords = last - index;
            
            if (last == words.length || numWords == 1) {
                for (int i = index; i < last; i++) {
                    sb.append(words[i]);
                    if (i < last - 1) sb.append(" ");
                }
                while (sb.length() < maxWidth) {
                    sb.append(" ");
                }
            } else {
                int spaces = (maxWidth - count) / (numWords - 1);
                int extra = (maxWidth - count) % (numWords - 1);
                
                for (int i = index; i < last - 1; i++) {
                    sb.append(words[i]);
                    sb.append(" ");
                    for (int j = 0; j < spaces; j++) {
                        sb.append(" ");
                    }
                    if (extra > 0) {
                        sb.append(" ");
                        extra--;
                    }
                }
                sb.append(words[last - 1]);
            }
            
            result.add(sb.toString());
            index = last;
        }
        
        return result;
    }
}
