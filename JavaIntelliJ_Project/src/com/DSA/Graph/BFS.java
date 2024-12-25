package com.DSA.Graph;

import java.util.List;
import java.util.Map;
import java.util.*;

public class BFS {
    private static Queue<Integer> q = new LinkedList<>();
    private static List<Integer> visited = new ArrayList<>();
    public static void bfs(Map<Integer, List<Integer>> graph, int startNode){
//        for (int node: graph.get(startNode)){
//            q.add(node);
//        }
        // above for loop is replaced with single line addAll which adds each element into individual node separately in the queue
        q.addAll(graph.get(startNode));
        visited.add(startNode);
        visited.addAll(graph.get(startNode));
        System.out.print(startNode+", ");

        while (!q.isEmpty()){
            int node = q.remove();
            System.out.print(node+", ");
            for (int v: graph.get(node)){
                if (!visited.contains(v)) {     // add into queue only if not visited earlier to prevent repeated traversal
                    q.add(v);
                }
            }
            visited.addAll(graph.get(node));
        }
    }
    public static void main(String[] args) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        graph.put(1, Arrays.asList(2, 3));
        graph.put(2, Arrays.asList(1, 4, 5));
        graph.put(3, Arrays.asList(1, 6, 7));
        graph.put(4, List.of(2));
        graph.put(5, Arrays.asList(2));
        graph.put(6, Arrays.asList(3));
        graph.put(7, Arrays.asList(3));

        // Perform BFS starting from vertex 1
        System.out.println("BFS Traversal:");
        bfs(graph, 1);
    }
}
