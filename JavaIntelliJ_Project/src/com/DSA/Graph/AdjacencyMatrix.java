package com.DSA.Graph;
import java.util.Scanner;

public class AdjacencyMatrix {
    static int[][] graph;
    // in this we will be representing a graph in matrix format where num of sub arrays in arrays will be considered as rows and their indices as columns
    public static void graph(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter number of nodes in your graph");
        int n = scanner.nextInt();

        graph = new int[n][n];

        while (true){
            System.out.println("Enter edge in sequence: source destination");
            int s = scanner.nextInt();
            int d = scanner.nextInt();
            try {
                if (s > n-1 || d > n-1) {
                    throw new InvalidNodeError("Enter valid nodes again");
                }
            }catch (InvalidNodeError e){
                System.out.println(e.getMessage());;     //
                continue;
            }


            graph[s][d] = 1;
            graph[d][s] = 1; // only if graph is undirected

            System.out.print("Do you want to enter more: Y/N");
            String response = scanner.next();
            System.out.println();

            if (response.equalsIgnoreCase("n")){
                System.out.print("[");
                for (int i = 0; i < graph.length; i++) {
                    System.out.print("[");
                    for (int j = 0; j < graph.length; j++) {
                        System.out.print(graph[i][j]+", ");
                    }
                    System.out.println("]");
                }
                System.out.println("]");

                break;
            }
        }
    }
    public static void main(String[] args) {
        graph();
    }
}


class InvalidNodeError extends Exception{
    public InvalidNodeError(String message){
        super(message);
    }
}
