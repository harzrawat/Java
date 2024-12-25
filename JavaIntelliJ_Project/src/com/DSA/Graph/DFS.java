package com.DSA.Graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.*;

public class DFS {
    private static List<Integer> visited = new ArrayList<>();
    public static void dfs(Map<Integer, List<Integer>> graph, int startNode){

        if (visited.containsAll(graph.get(startNode))){
            System.out.print(startNode+", ");
            return;
        }
        visited.add(startNode);
        System.out.print(startNode+", ");


        for(int node: graph.get(startNode)){
            if (!visited.contains(node)){
                dfs(graph,node);
            }
        }
        return;
    }
    public static void main(String[] args) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        graph.put(1, Arrays.asList(2, 3));
        graph.put(2, Arrays.asList(1, 4, 5));
        graph.put(3, Arrays.asList(1, 6, 7));
        graph.put(4, Arrays.asList(2));
        graph.put(5, Arrays.asList(2));
        graph.put(6, Arrays.asList(3));
        graph.put(7, Arrays.asList(3));

        // Perform BFS starting from vertex 1
        System.out.println("BFS Traversal:");
        dfs(graph, 1);
    }
}
