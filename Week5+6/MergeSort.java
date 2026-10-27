import java.io.*;
class MergeSort{
    public static void merge(int[] arr, int l, int m, int r){
        int n1 = m - l + 1;
        int n2 = r - m ;
        int[] leftArray = new int[n1];
        int[] rightArray = new int[n2];
        for (int i = 0; i < n1; i++){
            leftArray[i] = arr[l + i];
        }
        for (int i = 0; i < n2; i++){
            rightArray[i] = arr[m + i + 1];
        }
        int i = 0;
        int j = 0;
        int k = l;
        while (i < n1 && j < n2){
            if(leftArray[i] < rightArray[j]){
                arr[k]= leftArray[i];
                i++;
            }
            else{
                arr[k]= rightArray[j];
                j++;
            }
            k++;
        }
        while (i<n1){
            arr[k] = leftArray[i];
            i++;
            k++;
        }
        while (j < n2){
            arr[k] = rightArray[j];
            j++;
            k++;
        }
    }
    public static void mergeSort(int[] arr, int l, int r){
        if (l<r){
            int m = l + (r-l)/2;
            mergeSort(arr, l , m);
            mergeSort(arr,m+1, r);
            merge(arr,l,m,r);
        }
    }
    public static void main(String args[]){

        int arr[] = {38, 27, 43, 10};

        mergeSort(arr, 0, arr.length - 1);

        int n = arr.length;
        for (int i = 0; i < n; ++i)
            System.out.print(arr[i] + " ");
        System.out.println();
    }
}