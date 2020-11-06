package p2502;

public class TransformFibonacci {
    private int first;
    private int second;
    private int[] cache;

    public TransformFibonacci(int first, int second) {
        this.first = first;
        this.second = second;

        cache = new int[30];
    }

    public int apply(int arg) {
        if(isZeroOrOneArg(arg))
            return baseValue(arg);

        if(cache[arg] == 0){
            cache[arg] = apply(arg - 1) + apply(arg - 2);
        }

        return cache[arg];
    }

    private boolean isZeroOrOneArg(int arg){
        return arg == 0 || arg == 1;
    }

    private int baseValue(int arg){
        return arg == 0 ? first : second;
    }
}
