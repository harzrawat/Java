package com.DSA.Graph;

import com.sitare.Multithreading.CurrentThreadMethods.Main;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.*;

public class AdjacencyList {

    static List<ArrayList<Integer>> adjlst = new ArrayList<>();

    public static void graph(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter number of nodes in graph");
        int nodes = scanner.nextInt();
        for (int i = 0; i < nodes; i++) {
            adjlst.add(new ArrayList<>());

            while(true) {
                System.out.println("Enter destination node for node: "+i);
                int dest = scanner.nextInt();
                if (dest < nodes) {
                    adjlst.get(i).add(dest);
                }else {
                    System.out.println("This node is not supposed be there in graph");
                    continue;
                }

                System.out.println("Do you want to continue for node "+ i + ": Y/N");
                String response = scanner.next();
                if (response.equalsIgnoreCase("n")){
                    System.out.println(adjlst);
                    break;
                }
            }
        }

    }

    public static void mapGraph(){
        Map<Integer, List<Integer>> adjlst = new HashMap<>();
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter number of total nodes: ");
        int n = scanner.nextInt();
        System.out.println();

        for (int i = 0; i < n; i++) {
            adjlst.putIfAbsent(i,new ArrayList<>());
            System.out.print("Enter number of connections to be entered for node "+i+": ");
            int num = scanner.nextInt();
            System.out.println();

            for (int j = 0; j < num; j++) {
                System.out.print("Enter destination node: ");
                int dest = scanner.nextInt();
                adjlst.putIfAbsent(dest,new ArrayList<>());
                adjlst.get(i).add(dest);
                adjlst.get(dest).add(i);    // when graph is undirectional
                System.out.println();
            }
        }
        System.out.println(adjlst);
    }
    public static void main(String[] args) {
//        graph();
        mapGraph();
    }
}
