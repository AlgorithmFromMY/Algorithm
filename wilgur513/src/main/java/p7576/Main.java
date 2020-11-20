package p7576;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static int m, n;
    private static int[][] tomatoes;

    public static void main(String[] args) throws IOException {
        inputData();
        solve();
    }

    private static void inputData() throws IOException {
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        m = Integer.valueOf(tokenizer.nextToken());
        n = Integer.valueOf(tokenizer.nextToken());
        tomatoes = new int[n][m];

        for(int y = 0; y < n; y++){
            tokenizer = new StringTokenizer(reader.readLine());

            for(int x = 0; x < m; x++){
                tomatoes[y][x] = Integer.valueOf(tokenizer.nextToken());
            }
        }
    }

    private static void solve() {
        List<int[]> firstTomatoes = findFirstRipeTomatoes();

        if(firstTomatoes.size() == 0) {
            System.out.println(-1);
            return;
        }

        Queue<int[]> queue = new LinkedList<>();

        for(int[] tomatoes : firstTomatoes){
            queue.add(new int[]{tomatoes[0], tomatoes[1], 0});
        }

        int result = 0;

        while(!queue.isEmpty()){
            int[] here = queue.remove();

            for(int[] next : adjacent(here[0], here[1])){
                queue.add(new int[]{next[0], next[1], here[2] + 1});
                tomatoes[next[0]][next[1]] = 1;
                result = Math.max(result, here[2] + 1);
            }
        }

        if(ripeAllTomatoes())
            System.out.println(result);
        else
            System.out.println(-1);
    }

    private static List<int[]> findFirstRipeTomatoes(){
        List<int[]> firstTomatoes = new ArrayList<>();

        for(int y = 0; y < n; y++){
            for(int x = 0; x < m; x++){
                if(tomatoes[y][x] == 1)
                    firstTomatoes.add(new int[]{y, x});
            }
        }

        return firstTomatoes;
    }

    private static List<int[]> adjacent(int y, int x){
        List<int[]> adjacent = new ArrayList<>();
        int[] dx = {0, 0, 1, -1};
        int[] dy = {1, -1, 0, 0};

        for(int i = 0; i < 4; i++){
            int nextY = y + dy[i];
            int nextX = x + dx[i];

            if(isValid(nextY, nextX) && isNotRipe(nextY, nextX))
                adjacent.add(new int[]{nextY, nextX});
        }

        return adjacent;
    }

    private static boolean isValid(int y, int x){
        return (y >= 0 && y < n) && (x >= 0 && x < m);
    }

    private static boolean isNotRipe(int y, int x) {
        return tomatoes[y][x] == 0;
    }

    private static boolean ripeAllTomatoes() {
        for(int y = 0; y < n; y++)
            for(int x = 0; x < m; x++)
                if(tomatoes[y][x] == 0)
                    return false;

        return true;
    }
}
