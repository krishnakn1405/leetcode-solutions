// Number of Provinces

// There are n cities. Some of them are connected, while some are not. If city a is connected directly with city b, and city b is connected directly with city c, then city a is connected indirectly with city c.

// A province is a group of directly or indirectly connected cities and no other cities outside of the group.

// You are given an n x n matrix isConnected where isConnected[i][j] = 1 if the ith city and the jth city are directly connected, and isConnected[i][j] = 0 otherwise.

// Return the total number of provinces.

// Example 1:
// Input: isConnected = [[1,1,0],[1,1,0],[0,0,1]]
// Output: 2

// Example 2:
// Input: isConnected = [[1,0,0],[0,1,0],[0,0,1]]
// Output: 3

import java.util.Queue;
import java.util.LinkedList;

class NumberOfProvinces {

    public int findCircleNum(int[][] isConnected) {
        
        int n = isConnected.length;
        boolean[] visited = new boolean[n];
        int provinces = 0;

        for(int i=0; i<n; i++) {
            if(!visited[i]) {
                bfs(isConnected, visited, i);
                provinces++;
            }
        }

        return provinces;
    }

    private void bfs(int[][] isConnected, boolean[] visited, int start) {

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        visited[start] = true;

        while(!queue.isEmpty()) {
            int city = queue.poll();
            for(int i=0; i<isConnected.length; i++) {
                if(isConnected[city][i] == 1 && !visited[i]) {
                    visited[i] = true;
                    queue.offer(i);
                }
            }
        }
    }

    public static void main(String[] args) {
        int[][] isConnected = {
            {1, 0, 0},
            {0, 1, 0},
            {0, 0, 1}
        };

        NumberOfProvinces obj = new NumberOfProvinces();
        int result = obj.findCircleNum(isConnected);

        System.out.println("Number of provinces: " + result);
    }
}