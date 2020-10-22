import java.util.Scanner;

public class InverseSentence {
    public static void main(String[] args) {
        String[] s = new Scanner(System.in).nextLine().split(" ");
        StringBuilder sb = new StringBuilder();
        for(int i=s.length-1;i>-1;i--){
            sb.append(s[i]).append(" ");
        }
        sb.deleteCharAt(sb.length()-1);
        System.out.println(sb.toString());
    }
}
