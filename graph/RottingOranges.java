// Rotting Oranges

// You are given an m x n grid where each cell can have one of three values:

// 0 representing an empty cell,
// 1 representing a fresh orange, or
// 2 representing a rotten orange.
// Every minute, any fresh orange that is 4-directionally adjacent to a rotten orange becomes rotten.

// Return the minimum number of minutes that must elapse until no cell has a fresh orange. If this is impossible, return -1.

// Example 1:
// Input: grid = [[2,1,1],[1,1,0],[0,1,1]]
// Output: 4

// Example 2:
// Input: grid = [[2,1,1],[0,1,1],[1,0,1]]
// Output: -1
// Explanation: The orange in the bottom left corner (row 2, column 0) is never rotten, because rotting only happens 4-directionally.

// Example 3:
// Input: grid = [[0,2]]
// Output: 0
// Explanation: Since there are already no fresh oranges at minute 0, the answer is just 0.

import java.util.Queue;
import java.util.LinkedList;

class RottingOranges {
    public int orangesRotting(int[][] grid) {
        
        if(grid == null || grid.length == 0) return -1;

        int m = grid.length, n = grid[0].length;
        int freshCount = 0;
        Queue<int[]> rottenQueue = new LinkedList<>();

        // Count fresh oranges and enqueue rotten oranges
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if(grid[i][j] == 1) {
                    freshCount++;
                } else if (grid[i][j] == 2) {
                    rottenQueue.offer(new int[]{i, j});
                }
            }
        }

        if(freshCount == 0) return 0; // No fresh oranges

        int minutes = 0;
        int[][] directions = {{1,0}, {-1,0}, {0,1}, {0,-1}}; // 4-directional

        // BFS
        while(!rottenQueue.isEmpty()) {
            int size = rottenQueue.size();
            for(int i=0; i<size; i++) {
                int[] rotten = rottenQueue.poll();
                for(int[] dir: directions) {
                    int x = rotten[0] + dir[0];
                    int y = rotten[1] + dir[1];
                    if(x >= 0 && x < m && y >= 0 && y < n && grid[x][y] == 1) {
                        grid[x][y] = 2; // Turn fresh orange to rotten
                        freshCount--;
                        rottenQueue.offer(new int[]{x, y});
                    }
                }
            }
            minutes++; // Increment timer after each level of BFS
        }

        return freshCount == 0 ? minutes - 1: -1; // Adjust for extra increment
    }

    public static void main(String[] args) {
        RottingOranges obj = new RottingOranges();

        // ✅ Input array
        int[][] grid = {
            {2, 1, 1},
            {1, 1, 0},
            {0, 1, 1}
        };

        int result = obj.orangesRotting(grid);

        // ✅ Output
        System.out.println("Output: " + result);
    }
}

