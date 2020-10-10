package p2606;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Graph{
    int size;
    List<Integer>[] adj;
    boolean[] visited;

    public Graph(int size) {
        this.size = size;
        adj = new List[size];
        visited = new boolean[size];

        for(int i = 0; i < size; i++)
            adj[i] = new ArrayList<>();
    }

    public void addEdge(int v1, int v2){
        adj[v1].add(v2);
        adj[v2].add(v1);
    }

    public void dfs(int from){
        visited[from] = true;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(from);

        while(!queue.isEmpty()){
            int here = queue.remove();

            for(int there : adj[here]){
                if(!visited[there]){
                    queue.add(there);
                    visited[there] = true;
                }
            }
        }
    }

    public int numOfVirus(){
        int result = 0;

        for(int i = 1; i < size; i++)
            if(visited[i])
                result++;

        return result;
    }
}

public class Main {
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    static Graph graph;

    public static void main(String[] args) throws IOException {
        initGraph();
        solve();
    }

    private static void initGraph() throws IOException {
        int n = Integer.valueOf(reader.readLine());
        graph = new Graph(n);

        n = Integer.valueOf(reader.readLine());

        for(int i = 0; i < n; i++){
            StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
            graph.addEdge(Integer.valueOf(tokenizer.nextToken()) - 1, Integer.valueOf(tokenizer.nextToken()) - 1);
        }
    }

    private static void solve() {
        graph.dfs(0);
        System.out.println(graph.numOfVirus());
    }
}
