import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class InsertionSort2 {

    /*
     * Complete the 'insertionSort2' function below.
     *
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. INTEGER_ARRAY arr
     */

    public static void insertionSort2(int n, List<Integer> arr) {
        for ( int i = 0; i < arr.size() - 1; i++){
            if (arr.get(i+1) < arr.get(i)){
                int key = i + 1;
                int temp = arr.get(key);
                for (int j = i; j >= 0; j--){
                    if (arr.get(j) > temp){
                        arr.set(key,arr.get(j));
                        arr.set(j,temp);
                        key-=1;
                    }
                }
            }
            for (int x : arr){
                System.out.print(x + " ");
            }
            System.out.println();
        }

    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        InsertionSort2.insertionSort2(n, arr);

        bufferedReader.close();
    }
}

