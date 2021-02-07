package p1976;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    static int n, m;
    static boolean[][] graph;
    static List<Integer> path;
    static int[][] reachable;

    public static void main(String[] args) throws IOException {
        inputData();
        solve();
    }

    private static void inputData() throws IOException {
        n = Integer.parseInt(reader.readLine());
        m = Integer.parseInt(reader.readLine());
        graph = new boolean[n][n];

        for(int from = 0; from < n; from++) {
            StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
            for(int to = 0; to < n; to++) {
                boolean value = Integer.parseInt(tokenizer.nextToken()) == 1;
                graph[from][to] = value;
            }
        }

        path = new ArrayList<>();
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        for(int i = 0; i < m; i++) {
            path.add(Integer.parseInt(tokenizer.nextToken()) - 1);
        }

        reachable = new int[n][n];
        for(int i = 0; i < n; i++){
            Arrays.fill(reachable[i], -1);
        }
    }

    private static void solve() {
        boolean result = true;

        for(int i = 0; i < path.size() - 1; i++) {
            int from = path.get(i);
            int to = path.get(i + 1);
            result &= calculateCanReachable(from, to);
        }

        System.out.println(result ? "YES" : "NO");
    }

    private static boolean calculateCanReachable(int from, int to) {
        Queue<Integer> queue = prepareQueue(from);
        boolean[] visited = prepareVisited(from);

        while(!queue.isEmpty()) {
            if(queue.peek() == to){
                return true;
            }

            queue.addAll(reachableNextNode(visited, queue.peek()));
            visited = checkVisitedNode(visited, queue.peek());
            queue.poll();
        }

        return false;
    }

    private static Queue<Integer> prepareQueue(int from) {
        LinkedList<Integer> list = new LinkedList<>();
        list.add(from);
        return list;
    }

    private static boolean[] prepareVisited(int from) {
        boolean[] visited = new boolean[n];
        visited[from] = true;
        return visited;
    }

    private static List<Integer> reachableNextNode(boolean[] visited, int here) {
        return IntStream
                .range(0, n)
                .filter(nextNode -> canReachNotVisitedNode(visited, here, nextNode))
                .boxed()
                .collect(Collectors.toList());
    }

    private static boolean canReachNotVisitedNode(boolean[] visited, int here, int next) {
        return graph[here][next] && !visited[next];
    }

    private static boolean[] checkVisitedNode(boolean[] visited, int here) {
        boolean[] newVisited = visited.clone();
        for(int node : reachableNextNode(visited, here)) {
            newVisited[node] = true;
        }
        return newVisited;
    }
}
