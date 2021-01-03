package p2667;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    static int n;
    static int[][] map;

    public static void main(String[] args) throws IOException {
        inputData();
        solve();
    }

    private static void inputData() throws IOException {
        initSize();
        initMap();
    }

    private static void initSize() throws IOException {
        n = Integer.valueOf(reader.readLine());
    }

    private static void initMap() throws IOException {
        map = new int[n][n];

        for(int y = 0; y < n; y++){
            String s = reader.readLine();

            for(int x = 0; x < n; x++){
                map[y][x] = s.charAt(x) == '1' ? -1 : 0;
            }
        }
    }

    private static void solve() {
        int complex = 1;

        while(!isAssignAllComplex())
            assignComplex(complex++);

        displayAllComplexSize(complexesSize(complex - 1));
    }

    private static boolean isAssignAllComplex() {
        for(int y = 0; y < n; y++)
            for(int x = 0; x < n; x++)
                if(map[y][x] == -1)
                    return false;

        return true;
    }

    private static void assignComplex(int complex) {
        int[] dx = {0, 0, -1, 1};
        int[] dy = {1, -1, 0, 0};
        Queue<int[]> queue = findFirstApartment(complex);

        while(!queue.isEmpty()){
            int[] here = queue.remove();
            int y = here[0];
            int x = here[1];

            for(int i = 0; i < 4; i++){
                int nextY = y + dy[i];
                int nextX = x + dx[i];

                if(isValidRange(nextY, nextX) && map[nextY][nextX] == -1){
                    queue.add(new int[]{nextY, nextX});
                    map[nextY][nextX] = complex;
                }
            }
        }
    }

    private static Queue<int[]> findFirstApartment(int complex){
        Queue<int[]> queue = new LinkedList<>();

        for(int y = 0; y < n; y++){
            for(int x = 0; x < n; x++){
                if(map[y][x] == -1) {
                    queue.add(new int[]{y, x});
                    map[y][x] = complex;
                    return queue;
                }
            }
        }

        return queue;
    }

    private static boolean isValidRange(int y, int x){
        return (0 <= y && y < n) && (0 <= x && x < n);
    }

    private static int[] complexesSize(int maxComplex){
        int[] complexes = new int[maxComplex];

        for(int complex = 1; complex <= maxComplex; complex++)
            complexes[complex - 1] = complexSize(complex);

        Arrays.sort(complexes);

        return complexes;
    }

    private static int complexSize(int complex) {
        int result = 0;

        for(int y = 0; y < n; y++)
            for(int x = 0; x < n; x++)
                if(map[y][x] == complex)
                    result++;

        return result;
    }

    private static void displayAllComplexSize(int[] complexes) {
        System.out.println(complexes.length);

        for(int complex : complexes)
            System.out.println(complex);
    }
}
