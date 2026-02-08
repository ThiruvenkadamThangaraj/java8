public class LongestPrefix {
    public static void main(String[] args) {
        String[] words = new String[]{"flowing", "flow", "flowwer"};
        String prefix = words[0];
        
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            while (word.indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
            }
        }
        
        if (!prefix.equals("")) {
            System.out.println(prefix);
        } else {
            System.out.println("There is no longest common prefix");
        }
    }
}
