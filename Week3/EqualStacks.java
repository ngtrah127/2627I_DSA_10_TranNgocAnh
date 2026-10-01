import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'equalStacks' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY h1
     *  2. INTEGER_ARRAY h2
     *  3. INTEGER_ARRAY h3
     */
    public static int sum(Stack<Integer> stack){
        int sum =0;
        for (int x : stack){
            sum+=x;
        }
        return sum;
    }

    public static int equalStacks(List<Integer> h1, List<Integer> h2, List<Integer> h3) {
        Stack<Integer> s1 = new Stack<Integer>();
        Stack<Integer> s2 = new Stack<Integer>();
        Stack<Integer> s3 = new Stack<Integer>();
        for (int i = h1.size() - 1; i >= 0; i--){
            s1.push(h1.get(i));
        }
        for (int i = h2.size() - 1; i >= 0; i--){
            s2.push(h2.get(i));
        }
        for (int i = h3.size() - 1; i >= 0; i--){
            s3.push(h3.get(i));
        }
        int sum1 = sum(s1);
        int sum2 = sum(s2);
        int sum3 = sum(s3);
        while (!s1.isEmpty() && !s2.isEmpty() && !s3.isEmpty()){
            if (sum1 == sum2 && sum2 == sum3){
                return sum1;
            }

            if (sum1 >= sum2 && sum1 >= sum3){
                sum1-=s1.pop();
            }
            else if (sum2 >= sum1 && sum2 >= sum3){
                sum2-=s2.pop();
            }
            else if (sum3 >= sum1 && sum3 >= sum2){
                sum3-=s3.pop();
            }
        }
        return 0;
    }

}

public class EqualStacks {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n1 = Integer.parseInt(firstMultipleInput[0]);

        int n2 = Integer.parseInt(firstMultipleInput[1]);

        int n3 = Integer.parseInt(firstMultipleInput[2]);

        List<Integer> h1 = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        List<Integer> h2 = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        List<Integer> h3 = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        int result = Result.equalStacks(h1, h2, h3);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
