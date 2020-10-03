package p1446;

import java.util.List;

class DistanceCalculator {
    private final static int INF = 987654321;
    private final List<ShortCut> shortCuts;
    private final CalculatorMemory memory;
    private final int destination;

    public DistanceCalculator(int destination, List<ShortCut> shortCuts) {
        this.destination = destination;
        this.shortCuts = shortCuts;
        memory = new CalculatorMemory();
    }

    public int getMinDistance(int departure) {
        if (isSatisfyBaseCondition(departure))
            return baseValue(departure);

        if (!memory.hasValue(departure)) {
            int result = Math.min(notUseShortCut(departure), useShortCut(departure));
            memory.store(departure, result);
        }

        return memory.get(departure);
    }

    private boolean isSatisfyBaseCondition(int departure) {
        return isArrive(departure) || isOverDestination(departure);
    }

    private boolean isArrive(int departure) {
        return departure == destination;
    }

    private boolean isOverDestination(int departure) {
        return departure > destination;
    }

    private int baseValue(int departure) {
        if (isArrive(departure))
            return 0;
        else if (isOverDestination(departure))
            return INF;

        throw new AssertionError("Not Reach Here");
    }

    private int notUseShortCut(int departure) {
        return getMinDistance(departure + 1) + 1;
    }

    private int useShortCut(int departure) {
        int result = INF;

        for (ShortCut shortCut : shortCuts)
            if (isCanUseShortCut(shortCut, departure)) {
                result = Math.min(result, getMinDistance(shortCut.to) + shortCut.distance);
            }

        return result;
    }

    private boolean isCanUseShortCut(ShortCut shortCut, int departure) {
        return shortCut.from == departure;
    }
}
