package p12100;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RightSlider extends Slider {
    @Override
    public Queue<Long> queueOfLine(long[][] map, int y) {
        return IntStream.range(0, n)
                .map(i -> n - 1 - i)
                .mapToLong(x -> map[y][x])
                .filter(v -> v != 0)
                .boxed()
                .collect(Collectors.toCollection(LinkedList::new));
    }

    @Override
    public long[][] rotateToMaintainSameDirection(List<long[]> map) {
        long[][] newMap = new long[n][n];

        for(int y = 0; y < n; y++) {
            for(int x = 0; x < n; x++) {
                newMap[y][n - 1 - x] = map.get(y)[x];
            }
        }

        return newMap;
    }
}
