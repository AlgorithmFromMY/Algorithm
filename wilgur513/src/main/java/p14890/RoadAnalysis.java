package p14890;

public class RoadAnalysis {
    private int slopeLength;
    private int prev;
    private int current;
    private int sameNumberLengthBeforeCurrent;

    public RoadAnalysis() {
    }

    public RoadAnalysis(int slopeLength) {
        this.slopeLength = slopeLength;
    }

    public void setSlopeLength(int length){
        slopeLength = length;
    }

    public boolean canThroughRoad(String road) {
        prev = Integer.valueOf(String.valueOf(road.charAt(0)));
        sameNumberLengthBeforeCurrent = 1;

        for(int i = 1; i < road.length(); i++){
            current = Integer.valueOf(String.valueOf(road.charAt(i)));

            if(isDiffOverTwoHeight(prev, current))
                return false;

            if(isSameNumber(prev, current)){
                sameNumberLengthBeforeCurrent++;
            }else {
                if(isCanNotSetSlope(sameNumberLength(i, road)))
                    return false;

                i += nextIndex();
                initSameNumberLengthBeforeCurrent();
            }

            prev = current;
        }

        return true;
    }

    private boolean isDiffOverTwoHeight(int prev, int current){
        return Math.abs(prev - current) >= 2;
    }

    private boolean isSameNumber(int prev, int current){
        return prev == current;
    }

    private boolean isCanNotSetSlope(int count){
        return count < slopeLength;
    }

    private int sameNumberLength(int i, String road){
        return isUpHill(prev, current) ? sameNumberLengthBeforeCurrent : sameNumberLengthAfterCurrent(i, road);
    }

    private int sameNumberLengthAfterCurrent(int start, String road){
        char c = road.charAt(start);
        int count = 1;

        for(int i = start + 1; i < road.length(); i++){
            if(c != road.charAt(i))
                break;

            count++;
        }

        return count;
    }

    private int nextIndex(){
        return isUpHill(prev, current) ? 0 : slopeLength - 1;
    }

    private void initSameNumberLengthBeforeCurrent(){
        sameNumberLengthBeforeCurrent = isUpHill(prev, current) ? 1 : 0;
    }

    private boolean isUpHill(int prev, int current){
        return prev < current;
    }
}
