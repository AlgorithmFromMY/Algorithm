package p2478;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n;
    static int[] values;

    public static void main(String[] args) throws IOException {
        inputData();
        solve();
    }

    private static void inputData() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.valueOf(reader.readLine());
        values = new int[n];

        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        for(int i = 0; i < n; i++){
            values[i] = Integer.valueOf(tokenizer.nextToken());
        }
    }
    private static void solve() {
        int[] range = findReverseRange();

        int secondK = range[0] > range[1] ? n - range[0] : n;
        moveRight(secondK);

        int p = range[0] > range[1] ? 0 : range[0];
        int q = range[0] > range[1] ? range[1] + secondK : range[1];
        reverse(p, q);

        int oneIndex = findOneIndex();
        int firstK = n - oneIndex;
        moveRight(firstK);

        System.out.println(firstK);
        System.out.println((p + 1) + " " + (q + 1));
        System.out.println(secondK);
    }

    private static int[] findReverseRange(){
        int start = -1;
        int end = -1;

        for(int i = 0; i < n; i++){
            if(isReverse(i)){
                if(start == -1) {
                    start = i;
                    end = i;

                    while(end < n - 1 && isReverse(end + 1)){
                        end++;
                    }

                    i = end;
                }else{
                    start = i;
                    break;
                }
            }
        }

        return new int[]{start, end};
    }

    private static boolean isReverse(int index){
        int prev = index == 0 ? values[n - 1] : values[index - 1];
        int next = index == n - 1 ? values[0] : values[index + 1];

        return !isPrev(prev, values[index]) && !isNext(next, values[index]);
    }

    private static boolean isPrev(int prev, int value){
        return (value == 1 && prev == n) || prev + 1 == value;
    }

    private static boolean isNext(int next, int value){
        return (value == n && next == 1) || value + 1 == next;
    }

    private static void moveRight(int k){
        int[] newValues = new int[n];

        for(int i = 0; i < n - k; i++){
            newValues[i + k] = values[i];
        }

        for(int i = n - k; i < n; i++){
            newValues[i - n + k] = values[i];
        }

        values = newValues;
    }

    private static void reverse(int p, int q) {
        int[] newValues = new int[n];

        for(int i = 0; i < p; i++){
            newValues[i] = values[i];
        }

        for(int i = p; i <= q; i++){
            newValues[i] = values[q + p - i];
        }

        for(int i = q + 1; i < n; i++){
            newValues[i] = values[i];
        }

        values = newValues;
    }

    private static int findOneIndex(){
        for(int i = 0; i < n; i++)
            if(values[i] == 1)
                return i;

        throw new AssertionError();
    }
}
