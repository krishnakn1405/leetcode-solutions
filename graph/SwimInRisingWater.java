// Swim in Rising Water

// You are given an n x n integer matrix grid where each value grid[i][j] represents the elevation at that point (i, j).

// It starts raining, and water gradually rises over time. At time t, the water level is t, meaning any cell with elevation less than equal to t is submerged or reachable.

// You can swim from a square to another 4-directionally adjacent square if and only if the elevation of both squares individually are at most t. You can swim infinite distances in zero time. Of course, you must stay within the boundaries of the grid during your swim.

// Return the minimum time until you can reach the bottom right square (n - 1, n - 1) if you start at the top left square (0, 0).

// Example 1:
// Input: grid = [[0,2],[1,3]]
// Output: 3
// Explanation:
// At time 0, you are in grid location (0, 0).
// You cannot go anywhere else because 4-directionally adjacent neighbors have a higher elevation than t = 0.
// You cannot reach point (1, 1) until time 3.
// When the depth of water is 3, we can swim anywhere inside the grid.

// Example 2:
// Input: grid = [[0,1,2,3,4],[24,23,22,21,5],[12,13,14,15,16],[11,17,18,19,20],[10,9,8,7,6]]
// Output: 16
// Explanation: The final route is shown.
// We need to wait until time 16 so that (0, 0) and (4, 4) are connected.


class SwimInRisingWater {
    public int swimInWater(int[][] grid) {
        int n = grid.length;
        int left = grid[0][0], right=n*n-1;
        while(left<right) {
            int mid = left+(right-left) /2;
            if(canSwim(grid, mid)) {
                right = mid;
            } else {
                left=mid+1;
            }
        }

        return left;
    }

    private boolean canSwim(int[][] grid, int t) {
        int n = grid.length;
        boolean[][] visited = new boolean[n][n];
        return dfs(grid, visited, 0, 0, t);
    }

    private boolean dfs(int[][] grid, boolean[][] visited, int i, int j, int t) {
        int n = grid.length;
        if(i<0 || i>=n || j<0 || j>=n || visited[i][j] || grid[i][j]>t) {
            return false;
        }

        if(i==n-1 && j==n-1) {
            return true;
        }

        visited[i][j] = true;
        return dfs(grid, visited, i+1, j, t) ||
               dfs(grid, visited, i-1, j, t) ||
               dfs(grid, visited, i, j+1, t) ||
               dfs(grid, visited, i, j-1, t);
    }

    public static void main(String[] args) {
        int[][] grid = {
            {0, 1, 2, 3, 4},
            {24, 23, 22, 21, 5},
            {12, 13, 14, 15, 16},
            {11, 17, 18, 19, 20},
            {10, 9, 8, 7, 6}
        };

        SwimInRisingWater obj = new SwimInRisingWater();
        int result = obj.swimInWater(grid);

        System.out.println("Minimum time to swim: " + result);
    }
}


