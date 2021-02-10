package p12100;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class UpSlider extends Slider {
    @Override
    public Queue<Long> queueOfLine(long[][] map, int x) {
        return IntStream.range(0, n)
                .mapToLong(y -> map[y][x])
                .filter(v -> v != 0)
                .boxed()
                .collect(Collectors.toCollection(LinkedList::new));
    }

    @Override
    public long[][] rotateToMaintainSameDirection(List<long[]> map) {
        long[][] newMap = new long[n][n];

        for(int y = 0; y < n; y++) {
            for(int x = 0; x < n; x++) {
                newMap[x][y] = map.get(y)[x];
            }
        }

        return newMap;
    }
}
