package p2178;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    private static final int INF = 987654321;
    static int n, m;
    static int[][] map;
    static boolean[][] visited;
    static int[][] cache;

    public static void main(String[] args) throws IOException {
        inputData();
        solve();
    }

    private static void inputData() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        n = Integer.valueOf(tokenizer.nextToken());
        m = Integer.valueOf(tokenizer.nextToken());
        map = new int[n][m];
        cache = new int[n][m];
        visited = new boolean[n][m];

        for(int y = 0; y < n; y++){
            String s = reader.readLine();

            for(int x = 0; x < m; x++){
                map[y][x] = Integer.valueOf(s.substring(x, x + 1));
            }

            Arrays.fill(cache[y], -1);
        }
    }

    private static void solve() {
        System.out.println(minMoving());
    }

    private static int minMoving() {
        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, 0, 1});
        visited[0][0] = true;

        while(!queue.isEmpty()){
            int[] here = queue.remove();

            for(int i = 0; i < 4; i++){
                int nextY = here[0] + dy[i];
                int nextX = here[1] + dx[i];
                int nextCost = here[2] + 1;

                if(nextY == n - 1 && nextX == m - 1)
                    return nextCost;

                if(isValid(nextY, nextX) && !visited[nextY][nextX] && map[nextY][nextX] == 1){
                    queue.add(new int[]{nextY, nextX, nextCost});
                    visited[nextY][nextX] = true;
                }
            }
        }

        throw new AssertionError();
    }

    private static boolean isValid(int y, int x) {
        return (0 <= y && y < n) && (0 <= x && x < m);
    }
}
