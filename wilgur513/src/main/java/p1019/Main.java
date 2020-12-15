package p1019;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static int start = 1;
    static int end;
    static long[] result = new long[10];

    public static void main(String[] args) {
        inputData();
        solve();
    }

    private static void inputData() {
        end = new Scanner(System.in).nextInt();
    }

    private static void solve() {
        int point = 1;

        while(start <= end) {
            makeStartNumEndWithZero(point);
            if(start > end) break;
            makeEneNumEndWithNine(point);

            start /= 10;
            end /= 10;

            addNumberOfCount(point);
            point *= 10;
        }

        display();
    }

    private static void makeStartNumEndWithZero(int point) {
        while(start % 10 != 0 && start <= end){
            addNumberOfCount(start, point);
            start++;
        }
    }

    private static void makeEneNumEndWithNine(int point) {
        while(end % 10 != 9 && start <= end){
            addNumberOfCount(end, point);
            end--;
        }
    }

    private static void addNumberOfCount(int point){
        for(int value = 0; value < 10; value++)
            result[value] += (end - start + 1) * point;
    }

    private static void addNumberOfCount(int number, int point) {
        while(number > 0){
            result[number % 10] += point;
            number /= 10;
        }
    }

    private static void display() {
        Arrays.stream(result).mapToObj(r -> r + " ").forEach(System.out::print);
    }
}
