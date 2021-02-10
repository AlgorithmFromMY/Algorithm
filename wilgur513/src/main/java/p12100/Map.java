package p12100;

import java.util.*;

public class Map {
    private static final Slider LEFT_SLIDER = new LeftSlider();
    private static final Slider RIGHT_SLIDER = new RightSlider();
    private static final Slider UP_SLIDER = new UpSlider();
    private static final Slider DOWN_SLIDER = new DownSlider();
    private static final int MAX_COUNT = 5;
    private long[][] map;

    public Map(long[][] map) {
        this.map = map;
    }

    public long getMaxValue() {
        return getMaxValueBySlide(0, map);
    }

    private long getMaxValueBySlide(int count, long[][] map){
        if(isMaxCount(count)) {
            return maxValueOfMap(map);
        }

        long result = maxValueOfMap(map);
        result = Math.max(result, getMaxValueBySlide(count + 1, LEFT_SLIDER.slide(map)));
        result = Math.max(result, getMaxValueBySlide(count + 1, RIGHT_SLIDER.slide(map)));
        result = Math.max(result, getMaxValueBySlide(count + 1, UP_SLIDER.slide(map)));
        result = Math.max(result, getMaxValueBySlide(count + 1, DOWN_SLIDER.slide(map)));
        return result;
    }

    private boolean isMaxCount(int count) {
        return count == MAX_COUNT;
    }

    private long maxValueOfMap(long[][] map) {
        return Arrays.stream(map)
                .map(this::maxValueOfRow)
                .max(Long::compareTo)
                .get();
    }

    private long maxValueOfRow(long[] row) {
        return Arrays.stream(row)
                .max()
                .getAsLong();
    }
}
