package com.DSA.Graph;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// In this code we consider the graph to be input as nested array matrix starting from 1
//public class Provinces {
//    private static final Queue<Integer> q= new LinkedList<>();
//    static int counter = 0;
//    private static boolean[] visited;
//
//    public static int province(int[][] graph){
//        int provinces = 0;
//        visited= new boolean[graph.length];
//        for (int i = 0; i < graph.length; i++) {
//            if (!visited[i]){
//                bfs(graph,i);
//                provinces++;
//            }
//        }
//        return provinces;
//
//    }
//    public static void bfs(int[][] graph, int start){
//        int l = graph.length;
//        visited[start] = true;
//        q.add(start);
//        counter++;
//        while (!q.isEmpty()){
//            int root = q.remove();
//            for (int i=0; i<graph[root].length;i++){
//                if (!visited[i] && graph[root][i]==1){
//                    q.add(i);
//                    visited[i] = true;
//                    counter++;
//                }
//            }
//        }
//    }
//    public static void main(String[] args) {
//        // adjacency matrix
//        int[][] adj = {{1,1,0},{1,1,0},{0,0,1}};
//
//        System.out.println(province(adj));
//    }
//}

class Provinces {
    private boolean[] visited;
    public int province(int[][] isConnected) {
        visited = new boolean[isConnected.length];
        int numPro = 0;
        for(int i=0; i<isConnected.length; i++){
            if(!visited[i]){
                bfs(isConnected, i);
                numPro++;
            }
        }
        return numPro;
    }
    public void bfs(int[][] graph, int start){
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        visited[start] = true;
        while(!q.isEmpty()){
            int node = q.remove();
            for(int i=0; i<graph[node].length; i++){
                if(graph[node][i]==1 && !visited[i]){
                    q.add(i);
                    visited[i] = true;
                }
            }
        }
    }
        public static void main(String[] args) {
        // adjacency matrix
        int[][] adj = {{1,0,0},{0,1,0},{0,0,1}};
        Provinces obj1 = new Provinces();
        System.out.println(obj1.province(adj));
    }
}