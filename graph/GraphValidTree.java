// Graph Valid Tree

// Given n nodes labeled from 0 to n - 1 and a list of undirected edges (each edge is a pair of nodes), write a function to check whether these edges make up a valid tree.

// Example 1:
// Input: n = 5, edges = [[0,1],[0,2],[0,3],[1,4]]
// Output: true

// Example 2:
// Input: n = 5, edges = [[0,1],[1,2],[2,3],[1,3],[1,4]]
// Output: false

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.HashSet;

class GraphValidTree {
    public boolean validTree(int n, int[][] edges) {

        if(edges.length != n-1) {
            return false;
        }

        List<List<Integer>> adjancencyList = new ArrayList<>();
        for(int i=0;i<n;i++) {
            adjancencyList.add(new ArrayList<>());
        }

        for(int[] edge:edges) {
            adjancencyList.get(edge[0]).add(edge[1]);
            adjancencyList.get(edge[1]).add(edge[0]);
        }

        Stack<Integer> stack = new Stack<>();
        HashSet<Integer> visited = new HashSet<>();

        stack.push(0);
        visited.add(0);

        while(!stack.isEmpty()) {
            int node = stack.pop();
            for(int neighbour:adjancencyList.get(node)) {
                if(visited.contains(neighbour)) {
                    continue;
                }

                visited.add(neighbour);
                stack.push(neighbour);
            }
        }

        if(visited.size() == n) {
            return true;
        }

        return false;
    }

    public static void main(String[] args) {

        int n = 5;

        int[][] edges = {
            {0, 1},
            {0, 2},
            {0, 3},
            {1, 4}
        };

        GraphValidTree obj = new GraphValidTree();

        boolean result = obj.validTree(n, edges);

        System.out.println(result);
    }
}