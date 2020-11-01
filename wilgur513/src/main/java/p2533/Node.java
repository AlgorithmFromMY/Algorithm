package p2533;

import java.util.ArrayList;
import java.util.List;

public class Node {
    private int value;
    private List<Node> child;

    public Node(int value) {
        this.value = value;
        child = new ArrayList<>();
    }

    public int getValue() {
        return value;
    }

    public List<Node> getChild() {
        return child;
    }

    public void addChild(Node child) {
        this.child.add(child);
    }
}
