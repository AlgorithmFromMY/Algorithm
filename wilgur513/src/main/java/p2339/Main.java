package p2339;

import java.util.Scanner;

public class Main {
    static int n;
    static int[][] map;

    public static void main(String[] args) {
        inputData();
        solve();
    }

    private static void inputData() {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        map = new int[n][n];

        for(int y = 0; y < n; y++){
            for(int x = 0; x < n; x++){
                map[y][x] = scanner.nextInt();
            }
        }
    }

    private static void solve() {
        int result = find(new int[]{0, 0}, new int[]{n - 1, n - 1}, false) +
                    find(new int[]{0, 0}, new int[]{n - 1, n - 1}, true);

        System.out.println(result == 0 ? -1 : result);
    }

    private static int find(int[] p1, int[] p2, boolean wasVertically){
        if(notHasImpurities(p1, p2))
            return jewelCount(p1, p2) == 1 ? 1 : 0;

        int result = 0;

        for(int y = p1[0]; y <= p2[0]; y++){
            for(int x = p1[1]; x <= p2[1]; x++){
                if(map[y][x] == 1){
                    if(wasVertically && notHasJewelInCol(x, p1[0], p2[0])){
                        result += find(p1, new int[]{p2[0], x - 1}, false) *
                                    find(new int[]{p1[0], x + 1}, p2, false);
                    }else if(!wasVertically && notHasJewelInRow(y, p1[1], p2[1])){
                        result += find(p1, new int[]{y - 1, p2[1]}, true) *
                                    find(new int[]{y + 1, p1[1]}, p2, true);
                    }
                }
            }
        }

        return result;
    }

    private static boolean notHasImpurities(int[] p1, int[] p2){
        for(int y = p1[0]; y <= p2[0]; y++){
            for(int x = p1[1]; x <= p2[1]; x++){
                if(map[y][x] == 1)
                    return false;
            }
        }

        return true;
    }

    private static boolean notHasJewelInCol(int x, int sy, int ey){
        return jewelCount(new int[]{sy, x}, new int[]{ey, x}) == 0;
    }

    private static boolean notHasJewelInRow(int y, int sx, int ex){
        return jewelCount(new int[]{y, sx}, new int[]{y, ex}) == 0;
    }

    private static int jewelCount(int[] p1, int[] p2) {
        int result = 0;

        for(int y = p1[0]; y <= p2[0]; y++){
            for(int x = p1[1]; x <= p2[1]; x++){
                if(map[y][x] == 2)
                    result++;
            }
        }

        return result;
    }
}
