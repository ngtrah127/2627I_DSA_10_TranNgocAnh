import java.io.*;
import java.util.*;

public class SimpleTextEditor {

    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder("");
        Scanner sc = new Scanner(System.in);
        Stack<String> stack = new Stack<String>();
        int n = sc.nextInt();
        for (int i = 0; i<n ; i++){
            int type = sc.nextInt();
            if (type == 1){
                stack.push(sb.toString());
                String s = sc.next();
                sb.append(s);
            }
            else if (type == 2){
                stack.push(sb.toString());
                int m = sc.nextInt();
                sb.delete(sb.length() - m, sb.length());
            }
            else if (type == 3){
                int m = sc.nextInt();
                System.out.println(sb.charAt(m - 1));
            }
            else if (type == 4){
                if (!stack.isEmpty()){
                    sb = new StringBuilder(stack.pop());
                }
            }
        }
    }
}