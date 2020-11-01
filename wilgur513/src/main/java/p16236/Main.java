package p16236;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    static int n;
    static int[][] map;
    static int sharkSize;
    static int eatCount;
    static int sharkY, sharkX;

    public static void main(String[] args) throws IOException {
        inputData();
        solve();
    }

    private static void inputData() throws IOException {
        n = Integer.valueOf(reader.readLine());
        map = new int[n][n];

        for(int y = 0; y < n; y++){
            StringTokenizer tokenizer = new StringTokenizer(reader.readLine());

            for(int x = 0; x < n; x++)
                map[y][x] = Integer.valueOf(tokenizer.nextToken());
        }

        initializeShark();
    }

    private static void initializeShark() {
        sharkSize = 2;
        eatCount = 0;

        for(int y = 0; y < n; y++)
            for(int x = 0; x < n; x++)
                if(map[y][x] == 9) {
                    sharkY = y;
                    sharkX = x;
                    map[y][x] = 0;
                }
    }

    private static void solve() {
        int result = 0;
        int[] nextFish = nextFish();

        while(nextFish != null){
            result += nextFish[0];
            eat(nextFish[1], nextFish[2]);
            nextFish = nextFish();
        }

        System.out.println(result);
    }

    private static int[] nextFish() {
        int[] dy = {-1, 0, 0, 1};
        int[] dx = {0, -1, 1, 0};
        boolean[][] visited = new boolean[n][n];

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, sharkY, sharkX});
        visited[sharkY][sharkX] = true;
        int[] nextFish = null;

        while(!queue.isEmpty()){
            int[] here = queue.remove();
            int distance = here[0];
            int y = here[1];
            int x = here[2];

            for(int i = 0; i < 4; i++){
                int nextY = y + dy[i];
                int nextX = x + dx[i];

                if(!isValid(nextY, nextX) || visited[nextY][nextX])
                    continue;

                if(canEat(map[nextY][nextX])) {
                    int[] fish = {distance + 1, nextY, nextX};

                    if(isPriorityFish(nextFish, fish))
                        nextFish = fish;
                }else if(canMove(map[nextY][nextX])){
                    queue.add(new int[]{distance + 1, nextY, nextX});
                    visited[nextY][nextX] = true;
                }
            }
        }

        return nextFish;
    }

    private static boolean isValid(int y, int x) {
        return y >= 0 && y < n && x >= 0 && x < n;
    }

    private static boolean canMove(int fish) {
        return sharkSize >= fish;
    }

    private static boolean canEat(int fish) {
        return fish != 0 && sharkSize > fish;
    }

    private static boolean isPriorityFish(int[] now, int[] other){
        if(now == null)
            return true;

        if(other[0] < now[0])
            return true;

        if(other[0] == now[0])
            return (other[1] < now[1]) || (other[1] == now[1] && other[2] < now[2]);

        return false;
    }

    private static void eat(int y, int x){
        map[y][x] = 0;
        eatCount++;
        sharkY = y;
        sharkX = x;

        if(canSizeUp()) {
            sizeUp();
        }
    }

    private static boolean canSizeUp() {
        return sharkSize == eatCount;
    }

    private static void sizeUp(){
        sharkSize++;
        eatCount = 0;
    }
}
