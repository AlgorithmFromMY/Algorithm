package p14890;

public class RoadParser {
    private final String[] road;
    private int index;

    public RoadParser(String[] road) {
        this.road = road;
        index = 0;
    }

    public boolean hasNext() {
        return index < road.length * 2;
    }

    public String next() {
        String result = "";

        if(index < road.length)
            result = row();
        else
            result = col();

        index++;
        return result;
    }

    private String row(){
        return road[index];
    }

    private String col(){
        StringBuilder builder = new StringBuilder();
        int row = index % road.length;

        for(int i = 0; i < road.length; i++){
            builder.append(road[i].charAt(row));
        }

        return builder.toString();
    }

}
