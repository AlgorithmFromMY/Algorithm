package p2536;

import java.util.LinkedList;
import java.util.Queue;

public class Graph {
    private int size;
    private Bus[] buses;
    private boolean[] isRidden;

    public Graph(int size, Bus[] buses) {
        this.size = size;
        this.buses = buses;
        isRidden = new boolean[size];
    }

    public int minExchange(int[] from, int[] to){
        Queue<int[]> queue = firstCanRiddenBuses(from[0], from[1]);

        while(!queue.isEmpty()){
            int[] here = queue.remove();
            Bus currentBus = buses[here[0]];
            int exchangeCount = here[1];

            if(currentBus.canArrive(to[0], to[1]))
                return exchangeCount;

            for(int nextBusId = 0; nextBusId < size; nextBusId++){
                Bus nextBus = buses[nextBusId];

                if(!isRidden[nextBusId] && currentBus.canExchange(nextBus)){
                    queue.add(new int[]{nextBusId, exchangeCount + 1});
                    isRidden[nextBusId] = true;
                }
            }
        }

        throw new AssertionError();
    }

    private Queue<int[]> firstCanRiddenBuses(int y, int x){
        Queue<int[]> queue = new LinkedList<>();

        for(int i = 0; i < size; i++) {
            if (buses[i].canArrive(y, x)) {
                queue.add(new int[]{i, 1});
                isRidden[i] = true;
            }
        }

        return queue;
    }
}
