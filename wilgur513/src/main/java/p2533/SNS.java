package p2533;

import java.util.Arrays;

public class SNS {
    private Tree tree;
    private int[][] cache;

    public SNS(int size) {
        tree = new Tree(size);
        cache = new int[size][2];

        for(int i = 0; i < size; i++)
            Arrays.fill(cache[i], -1);
    }

    public void relate(int user1, int user2) {
        tree.relate(user1, user2);
    }

    public int getMinEarlyAdapter() {
        Node root = tree.getRoot();
        return Math.min(earlyAdapter(root, true), earlyAdapter(root, false));
    }

    private int earlyAdapter(Node current, boolean isEarlyAdapter){
        if(cache[current.getValue()][index(isEarlyAdapter)] != -1)
            return cache[current.getValue()][index(isEarlyAdapter)];

        if(current.getChild().size() == 0)
            return isEarlyAdapter ? 1 : 0;

        int result = isEarlyAdapter ? childNotMostEarlyAdapter(current) + 1 : childMostEarlyAdapter(current);
        cache[current.getValue()][index(isEarlyAdapter)] = result;
        return result;
    }

    private int childMostEarlyAdapter(Node current){
        int result = 0;

        for(Node child : current.getChild())
            result += earlyAdapter(child, true);

        return result;
    }

    private int childNotMostEarlyAdapter(Node current){
        int result = 0;

        for(Node child : current.getChild())
            result += Math.min(earlyAdapter(child, true), earlyAdapter(child, false));

        return result;
    }

    private int index(boolean flag){
        return flag ? 1 : 0;
    }
}
