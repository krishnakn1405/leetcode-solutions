// Number of Connected Components in an Undirected Graph

// You have an undirected graph of n nodes labeled from 0 to n - 1. You are given an integer n and an array edges where edges[i] = [aᵢ, bᵢ] indicates that there is an edge between aᵢ and bᵢ in the graph.

// Return the number of connected components in the graph.

// Example 1:
// Input: n = 5, edges = [[0,1],[1,2],[3,4]]
// Output: 2

// Example 2:
// Input: n = 5, edges = [[0,1],[1,2],[2,3],[3,4]]
// Output: 1

import java.util.List;
import java.util.ArrayList;

class NumberOfConnectedComponentsInAnUndirectedGraph {
    public int countComponents(int n, int[][] edges) {

        int counter = 0;
        int[] visited = new int[n];

        List<Integer>[] adjList = new ArrayList[n];
        for(int i=0;i<n;i++) {
            adjList[i] = new ArrayList<Integer>();
        }

        for(int i=0; i<edges.length; i++) {
            adjList[edges[i][0]].add(edges[i][1]);
            adjList[edges[i][1]].add(edges[i][0]);
        }

        for(int i=0; i<n; i++) {
            if(visited[i] == 0) {
                counter++;
                dfs(adjList, visited, i);
            }
        }

        return counter;
    }

    public void dfs(List<Integer>[] adjList, int[] visited, int node) {
        visited[node] = 1;

        for(int i=0; i<adjList[node].size(); i++) {
            if(visited[adjList[node].get(i)] == 0) {
                dfs(adjList, visited, adjList[node].get(i));
            }
        }
    }

    public static void main(String[] args) {
        int n = 5;

        int[][] edges = {
            {0, 1},
            {1, 2},
            {3, 4}
        };

        NumberOfConnectedComponentsInAnUndirectedGraph obj =
            new NumberOfConnectedComponentsInAnUndirectedGraph();

        int result = obj.countComponents(n, edges);

        System.out.println("Number of connected components in an undirected graph: " + result);
    }
}
