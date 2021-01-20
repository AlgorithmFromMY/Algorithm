package p2146;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n;
    static int[][] map;
    static int num = 1;
    static int[] dy = {0, 0, 1, -1};
    static int[] dx = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        inputData();
        solve();
    }

    private static void inputData() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.valueOf(reader.readLine());
        map = new int[n][n];

        for(int r = 0; r < n; r++){
            StringTokenizer tokenizer = new StringTokenizer(reader.readLine());

            for(int c = 0; c < n; c++){
                int value = Integer.valueOf(tokenizer.nextToken());
                map[r][c] = value == 1 ? -1 : value;
            }
        }
    }

    private static void solve() {
        allocLandNum();
        System.out.println(minBridgeLength());
    }

    private static void allocLandNum() {
        while(!isAllAlloc()){
            int[] pos = findNotAlloc();
            allocLand(pos, num++);
        }
    }

    private static boolean isAllAlloc() {
        for(int[] row : map){
            for(int col : row){
                if(col == -1)
                    return false;
            }
        }

        return true;
    }

    private static int[] findNotAlloc() {
        for(int y = 0; y < n; y++) {
            for (int x = 0; x < n; x++) {
                if(map[y][x] == -1)
                    return new int[]{y, x};
            }
        }

        throw new AssertionError();
    }

    private static void allocLand(int[] pos, int num) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(pos);
        map[pos[0]][pos[1]] = num;

        while(!queue.isEmpty()){
            int[] here = queue.remove();

            for(int i = 0; i < 4; i++){
                int ny = here[0] + dy[i];
                int nx = here[1] + dx[i];

                if(isValid(ny, nx) && map[ny][nx] == -1) {
                    map[ny][nx] = num;
                    queue.add(new int[]{ny, nx});
                }
            }
        }
    }

    private static boolean isValid(int y, int x) {
        return (0 <= y && y < n) && (0 <= x && x < n);
    }

    private static int minBridgeLength() {
        int result = Integer.MAX_VALUE;

        for(int land = 1; land < num; land++){
            result = Math.min(result, minBridgeLength(land));
        }

        return result;
    }

    private static int minBridgeLength(int land) {
        Queue<int[]> queue = findLand(land);
        boolean[][] visited = new boolean[n][n];

        while(!queue.isEmpty()){
            int[] pos = queue.remove();

            for(int i = 0; i < 4; i++){
                int ny = pos[0] + dy[i];
                int nx = pos[1] + dx[i];
                int length = pos[2] + 1;

                if(isValid(ny, nx) && !visited[ny][nx]){
                    visited[ny][nx] = true;

                    if(map[ny][nx] == 0){
                        queue.add(new int[]{ny, nx, length});
                    }else if(map[ny][nx] != land){
                        return pos[2];
                    }
                }
            }
        }

        throw new AssertionError();
    }

    private static Queue<int[]> findLand(int land) {
        Queue<int[]> queue = new LinkedList<>();

        for(int y = 0; y < n; y++){
            for(int x = 0; x < n; x++){
                if(map[y][x] == land){
                    queue.add(new int[]{y, x, 0});
                }
            }
        }

        return queue;
    }
}
