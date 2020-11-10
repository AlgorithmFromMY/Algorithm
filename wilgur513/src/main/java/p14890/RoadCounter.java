package p14890;

public class RoadCounter {
    private RoadParser parser;
    private RoadAnalysis analysis;

    public RoadCounter(RoadParser parser, RoadAnalysis analysis) {
        this.parser = parser;
        this.analysis = analysis;
    }


    public int count() {
        int result = 0;

        while(parser.hasNext()){
            if(analysis.canThroughRoad(parser.next())){
                result++;
            }
        }

        return result;
    }
}
