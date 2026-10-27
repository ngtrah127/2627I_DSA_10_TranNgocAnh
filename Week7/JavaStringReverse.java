import java.util.*;

public class JavaStringReverse {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        boolean flag = true;
        for (int i = 0; i < s.length()/2; i++){
            if(s.charAt(i)!= s.charAt(s.length()-i-1)){
                flag = false;
                break;
            }
        }
        if(flag == false){
            System.out.println("No");
        }else{
            System.out.println("Yes");
        }
    }
}