// Redundant Connection

// In this problem, a tree is an undirected graph that is connected and has no cycles.

// You are given a graph that started as a tree with n nodes labeled from 1 to n, with one additional edge added. The added edge has two different vertices chosen from 1 to n, and was not an edge that already existed. The graph is represented as an array edges of length n where edges[i] = [ai, bi] indicates that there is an edge between nodes ai and bi in the graph.

// Return an edge that can be removed so that the resulting graph is a tree of n nodes. If there are multiple answers, return the answer that occurs last in the input.

// Example 1:
// Input: edges = [[1,2],[1,3],[2,3]]
// Output: [2,3]

// Example 2:
// Input: edges = [[1,2],[2,3],[3,4],[1,4],[1,5]]
// Output: [1,4]

import java.util.Arrays;

class RedundantConnection {
    public int[] findRedundantConnection(int[][] edges) {
        
        // Initialize the parent array where parent[i] represents the parent of node i
        int[] parent = new int[edges.length + 1];
        for(int i=1; i<=edges.length; i++) {
            parent[i] = i; // Initially, each node is its own parent
        }

        // Iterate through the edges to find the redundant one
        for(int[] edge: edges) {

            int node1 = edge[0];
            int node2 = edge[1];

            // Find the roots of node1 and node2
            int root1 = find(parent, node1);
            int root2 = find(parent, node2);

            // If the roots are same, a cycle is detected, return the current edge
            if(root1 == root2) {
                return edge;
            }

            // Union the sets by making root1 the parent of root2
            parent[root2] = root1;
        }

        // If no cycle found (which should not happen in this problem), return an empty array
        return new int[0];
    }

    // Helper function to find the root of a node
    private static int find(int[] parent, int node) {
        while(node != parent[node]) {
            parent[node] = parent[parent[node]]; // Path compression for optimization
            node = parent[node];
        }
        return node;
    }

    public static void main(String[] args) {

        int[][] edges = {
            {1, 2},
            {2, 3},
            {3, 4},
            {1, 4},
            {1, 5}
        };

        RedundantConnection obj = new RedundantConnection();

        int[] result = obj.findRedundantConnection(edges);

        System.out.println(Arrays.toString(result));
    }
}