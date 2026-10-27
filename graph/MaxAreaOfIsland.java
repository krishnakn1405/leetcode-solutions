// Max Area of Island

// You are given an m x n binary matrix grid. An island is a group of 1's (representing land) connected 4-directionally (horizontal or vertical.) You may assume all four edges of the grid are surrounded by water.

// The area of an island is the number of cells with a value 1 in the island.

// Return the maximum area of an island in grid. If there is no island, return 0.

// Example 1:
// Input: grid = [[0,0,1,0,0,0,0,1,0,0,0,0,0],[0,0,0,0,0,0,0,1,1,1,0,0,0],[0,1,1,0,1,0,0,0,0,0,0,0,0],[0,1,0,0,1,1,0,0,1,0,1,0,0],[0,1,0,0,1,1,0,0,1,1,1,0,0],[0,0,0,0,0,0,0,0,0,0,1,0,0],[0,0,0,0,0,0,0,1,1,1,0,0,0],[0,0,0,0,0,0,0,1,1,0,0,0,0]]
// Output: 6
// Explanation: The answer is not 11, because the island must be connected 4-directionally.

// Example 2:
// Input: grid = [[0,0,0,0,0,0,0,0]]
// Output: 0

class MaxAreaOfIsland {
    public int maxAreaOfIsland(int[][] grid) {
        
        if (grid == null || grid.length == 0) return 0;
        int maxArea = 0;
        for(int i=0; i<grid.length; i++) {
            for(int j=0; j<grid[i].length; j++) {
                if(grid[i][j] == 1) {
                    int area = dfs(grid, i, j);
                    maxArea = Math.max(maxArea, area);
                }
            }
        }

        return maxArea;
    }

    private int dfs(int[][] grid, int i, int j) {

        if(i<0 || i>=grid.length || j<0 || j>=grid[i].length || grid[i][j] == 0) {
            return 0;
        }

        grid[i][j] = 0; // Mark the cell as visited
        int area = 1; // Current cell
        // Explore 4-directionally
        area += dfs(grid, i+1, j);
        area += dfs(grid, i-1, j);
        area += dfs(grid, i, j+1);
        area += dfs(grid, i, j-1);
        return area;
    }

    public static void main(String[] args) {
        int[][] grid = {
            {0,0,1,0,0,0,0,1,0,0,0,0,0},
            {0,0,0,0,0,0,0,1,1,1,0,0,0},
            {0,1,1,0,1,0,0,0,0,0,0,0,0},
            {0,1,0,0,1,1,0,0,1,0,1,0,0},
            {0,1,0,0,1,1,0,0,1,1,1,0,0},
            {0,0,0,0,0,0,0,0,0,0,1,0,0},
            {0,0,0,0,0,0,0,1,1,1,0,0,0},
            {0,0,0,0,0,0,0,1,1,0,0,0,0}
        };

        MaxAreaOfIsland obj = new MaxAreaOfIsland();
        int result = obj.maxAreaOfIsland(grid);

        System.out.println("Maxarea of island: " + result);
    }
}