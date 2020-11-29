package p1114;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int l, k, c;
    static Integer[] pos;

    public static void main(String[] args) throws IOException {
        inputData();
        solve();
    }

    private static void inputData() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        l = Integer.valueOf(tokenizer.nextToken());
        k = Integer.valueOf(tokenizer.nextToken());
        c = Integer.valueOf(tokenizer.nextToken());;

        pos = new Integer[k + 2];
        tokenizer = new StringTokenizer(reader.readLine());

        pos[0] = 0;
        pos[k + 1] = l;

        for(int i = 1; i <= k; i++) {
            pos[i] = Integer.valueOf(tokenizer.nextToken());
        }

        Arrays.sort(pos);
    }

    private static void solve() {
        int len = longLogLength();
        int position1 = lengthPos(len);

        System.out.println(len + " " + position1);
    }

    private static int longLogLength(){
        int high = l;
        int low = 0;

        while(high != low){
            int mid = (high + low) / 2;

            if(isCanDivide(mid))
                high = mid;
            else
                low = mid + 1;
        }

        return high;
    }

    private static int lengthPos(int max) {
        Arrays.sort(pos, Collections.reverseOrder());

        int number = 0;
        int prev;
        int next = 0;

        while(true){
            prev = next;
            next = nextIndex(next, max);

            if(next == pos.length - 1)
                break;

            number++;
        }

        return number < c ? pos[k] : pos[prev];
    }

    private static boolean isCanDivide(int max) {
        int index = 0;
        int number = 0;

        while(true){
            if(!hasNextIndex(index, max))
                return false;

            index = nextIndex(index, max);

            if(index == pos.length - 1)
                break;

            number++;
        }

        return number <= c;
    }

    private static boolean hasNextIndex(int index, int max){
        return Math.abs(pos[index + 1] - pos[index]) <= max;
    }

    private static int nextIndex(int start, int max){
        for(int i = start + 1; i < pos.length; i++){
            if(Math.abs(pos[i] - pos[start]) > max)
                return i - 1;
        }

        return pos.length - 1;
    }
}

