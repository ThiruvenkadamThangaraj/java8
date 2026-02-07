public class reverseString {
    public static void main (String args[]){
        // String str = "malayalam";
        // //str.chars().map(c->str.charAt(c).forEach(System.out.println()));
        // StringBuilder sb = new StringBuilder();
        // for(int i=0;i<str.length();i++){
        //     for(int j=str.length()-1;j>0;j--){
               
        //         if(str.charAt(i)!=str.charAt(j)){
        //               System.out.println("it is not a palidrom");
        //               break;
        //           }else{
        //              System.out.println("it is a  palidrom");
        //               break;
        //          }
        //     }
        //     //System.out.println(sb.append(str.charAt(i)));
        // }
       String str = "malayalam";
       String reversed = new StringBuilder(str).reverse().toString();
       System.out.println(str.equals(reversed)?"palidrom":"not palidrom");
    }
}
