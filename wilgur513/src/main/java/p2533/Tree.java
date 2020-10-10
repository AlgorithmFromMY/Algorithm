package p2533;

import java.util.ArrayList;
import java.util.List;

public class Tree {
    private final int size;
    private List<Integer>[] adj;
    private Node[] nodes;
    private boolean[] isVisited;

    public Tree(int size) {
        this.size = size;
        initGraph();
        initNode();
    }

    public Node getRoot() {
        makeTree(0);
        return nodes[0];
    }

    public void relate(int vertex1, int vertex2) {
        adj[vertex1].add(vertex2);
        adj[vertex2].add(vertex1);
    }

    private void initGraph() {
        adj = new List[size];
        isVisited = new boolean[size];

        for(int i = 0; i < size; i++){
            adj[i] = new ArrayList<>();
        }
    }

    private void initNode() {
        nodes = new Node[size];

        for(int i = 0; i < size; i++) {
            nodes[i] = new Node(i);
        }
    }

    private void makeTree(int current) {
        isVisited[current] = true;

        for(int next : adj[current]){
            if(!isVisited[next]){
                nodes[current].addChild(nodes[next]);
                makeTree(next);
            }
        }
    }
}
