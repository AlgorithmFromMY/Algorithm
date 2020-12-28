package p2536;

public class Bus{
    private int[] from, to;

    public Bus(int[] from, int[] to) {
        this.from = from;
        this.to = to;
    }

    public boolean canArrive(int y, int x){
        if(isVerticalMove()){
            return x == from[1] && isInRange(y, from[0], to[0]);
        }

        return y == from[0] && isInRange(x, from[1], to[1]);
    }

    public boolean canExchange(Bus bus){
        if(isVerticalMove() && bus.isVerticalMove()){
            return from[1] == bus.from[1] && !(maxY() < bus.minY() || minY() > bus.maxY());
        }else if(!isVerticalMove() && !bus.isVerticalMove()){
            return from[0] == bus.from[0] && !(maxX() < bus.minX() || minX() > bus.maxX());
        }else if(isVerticalMove() && !bus.isVerticalMove()){
            return isInRange(bus.from[0], minY(), maxY()) && isInRange(from[1], bus.minX(), bus.maxX());
        }

        return isInRange(bus.from[1], minX(), maxX()) && isInRange(from[0], bus.minY(), bus.maxY());
    }

    private boolean isInRange(int value, int a, int b) {
        return a > b ? (b <= value && value <= a) : (a <= value && value <= b);
    }

    public boolean isVerticalMove(){
        return from[1] == to[1];
    }

    private int maxY(){
        return from[0] > to[0] ? from[0] : to[0];
    }

    private int minY(){
        return from[0] > to[0] ? to[0] : from[0];
    }

    private int maxX(){
        return from[1] > to[1] ? from[1] : to[1];
    }

    private int minX(){
        return from[1] > to[1] ? to[1] : from[1];
    }
}
