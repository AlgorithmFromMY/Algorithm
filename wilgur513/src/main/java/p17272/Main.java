package p17272;

import java.util.Scanner;

class Matrix{
    private static final int MOD = 1_000_000_007;
    private int size;
    private long[][] matrix;

    public Matrix(int size) {
        this.size = size;
        matrix = new long[size][size];
    }

    public void setValue(int row, int col, long value){
        matrix[row][col] = value;
    }

    public long getValue(int row, int col){
        return matrix[row][col];
    }

    public Matrix power(long arg){
        if(arg == 1)
            return this;

        Matrix result = power(arg / 2);
        return arg % 2 == 1 ? result.multiply(result).multiply(this) : result.multiply(result);
    }

    private Matrix multiply(Matrix arg){
        Matrix result = new Matrix(size);

        for(int row = 0; row < size; row++){
            for(int col = 0; col < size; col++){
                for(int i = 0; i < size; i++) {
                    result.matrix[row][col] += (matrix[row][i] * arg.matrix[i][col]) % MOD;
                    result.matrix[row][col] %= MOD;
                }
            }
        }

        return result;
    }
}

public class Main {
    static Scanner scanner = new Scanner(System.in);
    static long n;
    static int m;

    public static void main(String[] args) {
        inputData();
        solve();
    }

    private static void inputData() {
        n = scanner.nextLong();
        m = scanner.nextInt();
    }

    private static void solve() {
        Matrix matrix = makeFirstMatrix();
        matrix = matrix.power(n);
        System.out.println(matrix.getValue(0, 0));
    }

    private static Matrix makeFirstMatrix(){
        Matrix result = new Matrix(m);

        result.setValue(0, 0, 1);
        result.setValue(0, m - 1, 1);
        for(int i = 1; i < Main.m - 1; i++)
            result.setValue(0, 1, 0);

        for(int i = 1; i < Main.m; i++)
            result.setValue(i, i - 1, 1);

        return result;
    }
}
