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

class BalancedBrackets {

    /*
     * Complete the 'isBalanced' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts STRING s as parameter.
     */

    public static String isBalanced(String s) {
        Stack<Character> stack = new Stack<Character>();
        for (char c : s.toCharArray()){
            if(c == '{' || c == '[' || c == '('){
                stack.push(c);
            }else{
                if ( !stack.isEmpty()){
                    if (c=='}' && stack.peek()=='{'){
                        stack.pop();
                    }
                    else if (c == ')' && stack.peek() == '('){
                        stack.pop();
                    }
                    else if (c == ']' && stack.peek() == '['){
                        stack.pop();
                    }
                    else{
                        return "NO";
                    }
                }
                else {
                    return "NO";
                }
            }
        }
        if (stack.isEmpty() == true){
            return "YES";
        }else {
            return "NO";
        }
    }
}