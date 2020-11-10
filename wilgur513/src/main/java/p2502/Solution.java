package p2502;

public class Solution {
    private int k;
    private int a;
    private int b;

    public Solution(int k) {
        this.k = k;
    }

    public void solve(int alpha, int beta) {
        for(int v = 1; k - alpha * v > 0; v++){
            if(canDivideByBeta(v, alpha, beta)){
                a = v;
                b = b(alpha, beta);
                break;
            }
        }
    }

    public int getA() {
        return a > b ? b : a;
    }

    public int getB() {
        return a > b ? a : b;
    }

    private boolean canDivideByBeta(int value, int alpha, int beta){
        return (k - alpha * value) % beta == 0;
    }

    private int b(int alpha, int beta){
        return (k - alpha * a) / beta;
    }
}
