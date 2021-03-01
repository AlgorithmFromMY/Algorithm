package p12100;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

abstract public class Slider {
    protected int n;
    private long[] newRow;
    private int index;

    public long[][] slide(long[][] map) {
        n = map.length;
        List<long[]> newMap = IntStream.range(0, n)
                                    .mapToObj(i -> slideLineOfMap(map, i))
                                    .collect(Collectors.toList());

        return rotateToMaintainSameDirection(newMap);
    }

    private long[] slideLineOfMap(long[][] map, int line) {
        return slideElement(queueOfLine(map, line));
    }

    private long[] slideElement(Queue<Long> queue) {
        newRow = new long[n];
        index = 0;

        while(!queue.isEmpty()) {
            handleEachElement(queue);
        }

        return newRow;
    }

    private void handleEachElement(Queue<Long> queue) {
        long value = queue.remove();

        if(isFirstElement()) {
            handleFirstElement(value);
        } else {
            handleRemainElement(queue, value);
        }
    }

    private boolean isFirstElement() {
        return index == 0;
    }

    private void handleFirstElement(long value) {
        newRow[index++] = value;
    }

    private void handleRemainElement(Queue<Long> queue, long value) {
        if(isSameWithPrevValue(value)) {
            handleSameWithPrevValue(queue, value);
        } else {
            handleDifferentWithPrevValue(value);
        }
    }

    private boolean isSameWithPrevValue(long value) {
        return newRow[index - 1] == value;
    }

    private void handleSameWithPrevValue(Queue<Long> queue, long value) {
        newRow[index - 1] += value;

        if(!queue.isEmpty()) {
            newRow[index++] = queue.remove();
        }
    }

    private void handleDifferentWithPrevValue(long value) {
        newRow[index++] = value;
    }

    public abstract Queue<Long> queueOfLine(long[][] map, int line);
    public abstract long[][] rotateToMaintainSameDirection(List<long[]> map);
}
