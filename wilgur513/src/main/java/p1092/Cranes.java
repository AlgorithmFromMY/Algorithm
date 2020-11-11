package p1092;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Cranes {
    private List<Crane> cranes;

    public Cranes() {
        cranes = new ArrayList<>();
    }

    public void add(Crane crane) {
        cranes.add(crane);
        Collections.sort(cranes, Collections.reverseOrder());
    }

    public boolean canTakeLuggage(int luggage) {
        return cranes.stream().anyMatch(c -> c.canTake(luggage));
    }

    public void take(int luggage) {
        findCrane(luggage).take();
    }

    public int requiredTime() {
        return mapToRequiredTime(cranes.stream()).max().getAsInt();
    }

    private Crane findCrane(int luggage) {
        if(allCraneHasSameRequiredTime(luggage))
            return cranes.get(0);

        return findIdleCrane(luggage);
    }

    private boolean allCraneHasSameRequiredTime(int luggage){
        return mapToRequiredTime(canTakenCranes(luggage))
                .distinct()
                .count() == 1;
    }

    private Crane findIdleCrane(int luggage) {
        final int minRequiredTime = mapToRequiredTime(canTakenCranes(luggage)).min().getAsInt();

        return canTakenCranes(luggage)
                .filter(c -> c.requiredTime() == minRequiredTime)
                .findFirst().get();
    }

    private Stream<Crane> canTakenCranes(int luggage){
        return cranes.stream().filter(c -> c.canTake(luggage));
    }

    private IntStream mapToRequiredTime(Stream<Crane> stream){
        return stream.mapToInt(Crane::requiredTime);
    }
}
