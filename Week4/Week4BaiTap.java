import java.util.Arrays;
import java.util.Scanner;

public class Week4BaiTap {
    public static void main ( String args[]){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int a[] = new int[n];
        for (int i = 0; i<n ; i++){
            a[i] = sc.nextInt();
        }
        Arrays.sort(a);
        int hIndex = 0;
        for (int i = 0; i< a.length; i++ ){
            int count = n-i;
            if (a[i] >= count){
                hIndex = count;
                break;
            }
        }
        System.out.println(hIndex);
    }
}