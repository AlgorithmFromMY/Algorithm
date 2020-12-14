package p3015;

import java.util.*;

public class Main {
    private static int[] people;

    public static void main(String[] args) {
        inputData();
        solve();
    }

    private static void inputData() {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        people = new int[n];

        for(int i = 0; i < n; i++)
            people[i] = scanner.nextInt();
    }

    private static void solve() {
        Stack<int[]> stack = new Stack<>();
        long result = 0;

        for(int person : people) {
            int same = 0;

            while(!stack.isEmpty() && stack.peek()[0] <= person){
                if(stack.peek()[0] == person)
                    same = stack.peek()[1];

                result += stack.peek()[1];
                stack.pop();
            }

            if(stack.size() > 0)
                result++;

            stack.push(new int[]{person, same + 1});
        }

        System.out.println(result);
    }
}
