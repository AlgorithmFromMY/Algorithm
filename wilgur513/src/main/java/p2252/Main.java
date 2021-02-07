package p2252;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    static int[] inputCount;
    static List<Integer>[] graph;
    static int n, m;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        inputData();
        solve();
    }

    private static void inputData() throws IOException {
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        n = Integer.parseInt(tokenizer.nextToken());
        m = Integer.parseInt(tokenizer.nextToken());

        graph = new List[n];
        inputCount = new int[n];
        visited = new boolean[n];

        for(int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        for(int i = 0; i < m; i++) {
            tokenizer = new StringTokenizer(reader.readLine());
            int a = Integer.parseInt(tokenizer.nextToken()) - 1;
            int b = Integer.parseInt(tokenizer.nextToken()) - 1;

            inputCount[b]++;
            graph[a].add(b);
        }
    }

    private static void solve() {
        Queue<Integer> notHasInputNode = findNotHasInputNode();
        boolean[] isFind = new boolean[n];

        while(!notHasInputNode.isEmpty()) {
            for(int node : notHasInputNode) {
                removeNodeFromGraph(node);
                System.out.print((node + 1) + " ");
                isFind[node] = true;
            }

            notHasInputNode = findNotHasInputNode();
        }

        for(int i = 0; i < n; i++) {
            if(!isFind[i]){
                System.out.print((i + 1) + " ");
            }
        }
    }

    private static LinkedList<Integer> findNotHasInputNode() {
        LinkedList<Integer> result = new LinkedList<>();
        for(int i = 0; i < n; i++){
            if(inputCount[i] == 0 && !visited[i]) {
                visited[i] = true;
                result.add(i);
            }
        }
        return result;
    }

    private static void removeNodeFromGraph(int node) {
        for(int to : graph[node]) {
            inputCount[to]--;
            visited[node] = true;
        }
    }
}
