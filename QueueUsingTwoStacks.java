import java.util.*;

public class QueueUsingTwoStacks {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Stack<Integer> s1 = new Stack<Integer>();
        Stack<Integer> s2 = new Stack<Integer>();

        int q = sc.nextInt();

        for (int i = 0; i < q; i++) {
            int type = sc.nextInt();

            if (type == 1) {
                int so = sc.nextInt();
                s1.push(so);
            }

            else if (type == 2) {
                if (s2.isEmpty()) {
                    while (!s1.isEmpty()) {
                        s2.push(s1.pop());
                    }
                }

                s2.pop();
            }

            else if (type == 3) {
                if (s2.isEmpty()) {
                    while (!s1.isEmpty()) {
                        s2.push(s1.pop());
                    }
                }
                System.out.println(s2.peek());
            }
        }
    }
}