package p3197;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static int r, c;
    private static char[][] map;
    private static int[][] pos;
    private static Queue<int[]> swanPath;
    private static List<int[]> nextSwanPath;
    private static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        inputData();
        solve();
    }

    private static void inputData() throws IOException {
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        r = Integer.valueOf(tokenizer.nextToken());
        c = Integer.valueOf(tokenizer.nextToken());
        map = new char[r][c];
        pos = new int[2][2];
        int index = 0;

        for(int y = 0; y < r; y++){
            String s = reader.readLine();

            for(int x = 0; x < c; x++){
                map[y][x] = s.charAt(x);

                if(map[y][x] == 'L') {
                    pos[index][0] = y;
                    pos[index][1] = x;
                    index++;
                }
            }
        }

        swanPath = new LinkedList<>();
        nextSwanPath = new ArrayList<>();
        visited = new boolean[r][c];
        nextSwanPath.add(pos[0]);
    }

    private static void solve() {
        int[] dy = {0, 0, -1, 1};
        int[] dx = {1, -1, 0, 0};
        Queue<int[]> queue = initQueue();

        int day = 0;

        while(true){
            int[] here = queue.remove();

            if(day != here[2]){
                if(isReach())
                    break;

                day = here[2];
            }

            for(int i = 0; i < 4; i++){
                int nextY = here[0] + dy[i];
                int nextX = here[1] + dx[i];
                int nextDay = here[2] + 1;

                if(isValid(nextY, nextX) && map[nextY][nextX] == 'X'){
                    queue.add(new int[]{nextY, nextX, nextDay});
                    map[nextY][nextX] = '.';
                }
            }
        }

        System.out.println(day + 1);
    }

    private static Queue<int[]> initQueue() {
        Queue<int[]> queue = new LinkedList<>();

        for(int y = 0; y < r; y++)
            for(int x = 0; x < c; x++)
                if(map[y][x] == '.' || map[y][x] == 'L'){
                    queue.add(new int[]{y, x, 0});
                }

        return queue;
    }

    private static boolean isReach(){
        int[] dx = {0, 0, 1, -1};
        int[] dy = {1, -1, 0, 0};

        for(int[] n : nextSwanPath)
            swanPath.add(n);

        nextSwanPath.clear();

        while(!swanPath.isEmpty()){
            int[] here = swanPath.remove();

            for(int i = 0; i < 4; i++){
                int nextY = here[0] + dy[i];
                int nextX = here[1] + dx[i];

                if(nextY == pos[1][0] && nextX == pos[1][1])
                    return true;

                if(isValid(nextY, nextX) && !visited[nextY][nextX]) {
                    visited[nextY][nextX] = true;

                    if(map[nextY][nextX] == '.' || map[nextY][nextX] =='L') {
                        swanPath.add(new int[]{nextY, nextX});
                    }else if(map[nextY][nextX] == 'X'){
                        nextSwanPath.add(new int[]{nextY, nextX});
                    }
                }
            }
        }

        return false;
    }

    private static boolean isValid(int y, int x){
        return (y >= 0 && y < r) && (x >= 0 && x < c);
    }
}
