package Stack;
import java.util.Scanner;
import java.util.StringTokenizer;


public class ComputeRPN {

    public static void main(String[] args) {
        MyStack stack = new MyStack();
        Scanner in = new Scanner(System.in);
        String rpn = in.nextLine();
        StringTokenizer st = new StringTokenizer(rpn);
        while(st.hasMoreTokens()) {
        String t = st.nextToken();
        System.out.println(t);
        }
        in.close();
        }
    
}
