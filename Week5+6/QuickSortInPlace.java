import java.io.*;
import java.util.*;

public class QuickSortInPlace {
    public static int partition(List<Integer> arr, int low, int high){
        int pivot = arr.get(high);
        int i = low - 1;
        for (int j = low; j<= high - 1 ; j++){
            if ( arr.get(j) < pivot ){
                i++;
                Collections.swap(arr, i , j);
            }
        }
        Collections.swap(arr, i + 1, high);
        return i + 1;
    }
    public static void quickSort(List<Integer> arr, int low, int high){
        if(low < high){
            int pi = partition(arr, low, high);
            for (int i = 0; i < arr.size(); i++) {
                System.out.print(arr.get(i) + " ");
            }
            System.out.println();
            quickSort(arr,low,pi-1);
            quickSort(arr,pi+1,high);
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Integer> arr = new ArrayList<>();
        for (int i = 0; i< n ; i++ ){
            int k = sc.nextInt();
            arr.add(k);
        }
        quickSort(arr,0,n - 1);
    }
}
