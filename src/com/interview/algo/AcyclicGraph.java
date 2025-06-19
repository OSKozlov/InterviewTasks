package com.interview.algo;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class AcyclicGraph {

    private int vertices;
    private List<List<Integer>> adjList;

    public AcyclicGraph(int vertices) {
        this.vertices = vertices;
        adjList = new ArrayList<>();

        for(int i = 0; i < vertices; i++) {
            adjList.add(new ArrayList<>());
        }
    }

    public void addEdge(int from, int to) {
        adjList.get(from).add(to);
    }

    public boolean isAcyclic() {
        Set<Integer> visited = new HashSet<>();
        Set<Integer> recStack = new HashSet<>();

        for(int i = 0; i < vertices; i++) {
            if (!visited.contains(i)) {
                if (hasCycleDFS(i, visited, recStack)) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean hasCycleDFS(int vertex, Set<Integer> visited, Set<Integer> recStack) {
        visited.add(vertex);
        recStack.add(vertex);

        for (int neighbor : adjList.get(vertex)) {
            if (!visited.contains(neighbor)) {
                if (hasCycleDFS(neighbor, visited, recStack)) {
                    return true;
                }
            } else if (recStack.contains(neighbor)) {
                return true; // Cycle is found
            }
        }

        recStack.remove(vertex);
        return false;
    }

    public static void main(String[] args) {
        // Example 1: Acyclic graph
        AcyclicGraph acyclic = new AcyclicGraph(4);
        acyclic.addEdge(0, 1);
        acyclic.addEdge(0, 2);
        acyclic.addEdge(1, 3);
        acyclic.addEdge(2, 3);
        System.out.println("Acyclic graph: " + acyclic.isAcyclic()); // true

        // Example 2: Cyclic graph
        AcyclicGraph cyclic = new AcyclicGraph(4);
        cyclic.addEdge(0, 1);
        cyclic.addEdge(1, 2);
        cyclic.addEdge(2, 3);
        cyclic.addEdge(3, 1); // Cycle 1 -> 2 -> 3 -> 1
        System.out.println("Cyclic graph: " + cyclic.isAcyclic()); // false
    }
}
