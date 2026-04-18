// Pacific Atlantic Water Flow

// There is an m x n rectangular island that borders both the Pacific Ocean and Atlantic Ocean. The Pacific Ocean touches the island's left and top edges, and the Atlantic Ocean touches the island's right and bottom edges.

// The island is partitioned into a grid of square cells. You are given an m x n integer matrix heights where heights[r][c] represents the height above sea level of the cell at coordinate (r, c).

// The island receives a lot of rain, and the rain water can flow to neighboring cells directly north, south, east, and west if the neighboring cell's height is less than or equal to the current cell's height. Water can flow from any cell adjacent to an ocean into the ocean.

// Return a 2D list of grid coordinates result where result[i] = [ri, ci] denotes that rain water can flow from cell (ri, ci) to both the Pacific and Atlantic oceans.

// Example 1:
// Input: heights = [[1,2,2,3,5],[3,2,3,4,4],[2,4,5,3,1],[6,7,1,4,5],[5,1,1,2,4]]
// Output: [[0,4],[1,3],[1,4],[2,2],[3,0],[3,1],[4,0]]
// Explanation: The following cells can flow to the Pacific and Atlantic oceans, as shown below:
// [0,4]: [0,4] -> Pacific Ocean 
//       [0,4] -> Atlantic Ocean
// [1,3]: [1,3] -> [0,3] -> Pacific Ocean 
//       [1,3] -> [1,4] -> Atlantic Ocean
// [1,4]: [1,4] -> [1,3] -> [0,3] -> Pacific Ocean 
//       [1,4] -> Atlantic Ocean
// [2,2]: [2,2] -> [1,2] -> [0,2] -> Pacific Ocean 
//       [2,2] -> [2,3] -> [2,4] -> Atlantic Ocean
// [3,0]: [3,0] -> Pacific Ocean 
//       [3,0] -> [4,0] -> Atlantic Ocean
// [3,1]: [3,1] -> [3,0] -> Pacific Ocean 
//       [3,1] -> [4,1] -> Atlantic Ocean
// [4,0]: [4,0] -> Pacific Ocean 
//       [4,0] -> Atlantic Ocean
// Note that there are other possible paths for these cells to flow to the Pacific and Atlantic oceans.

// Example 2:
// Input: heights = [[1]]
// Output: [[0,0]]
// Explanation: The water can flow from the only cell to the Pacific and Atlantic oceans.

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

class PacificAtlanticWaterFlow {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        
        if(heights.length == 0 || heights[0].length == 0) {
            return new ArrayList<>();
        }

        int row = heights.length;
        int col = heights[0].length;

        boolean[][] pacificReachable = new boolean[row][col];
        boolean[][] atlanticReachable = new boolean[row][col];

        for(int i=0; i<row; i++) {
            dfs(i, 0, pacificReachable, heights);
            dfs(i, col-1, atlanticReachable, heights);
        }

        for(int i=0; i<col; i++) {
            dfs(0, i, pacificReachable, heights);
            dfs(row-1, i, atlanticReachable, heights);
        }

        List<List<Integer>> result = new ArrayList<>();

        for(int i=0; i<row; i++) {
            for(int j=0; j<col; j++) {
                if(pacificReachable[i][j] && atlanticReachable[i][j]) {
                    result.add(List.of(i, j));
                }
            }
        }

        return result;
    }

    public void dfs(int row, int col, boolean[][] reachable, int[][] heights) {

        int[][] directions = new int[][]{{0,1},{1,0},{-1,0},{0,-1}};

        reachable[row][col] = true;

        for(int[] dir: directions) {
            int newRow = row+dir[0];
            int newCol = col+dir[1];

            if(newRow < 0 || newRow >= heights.length || newCol < 0 || newCol >= heights[0].length) {
                continue;
            }

            if(reachable[newRow][newCol]) {
                continue;
            }

            if(heights[newRow][newCol] < heights[row][col]) {
                continue;
            }

            dfs(newRow, newCol, reachable, heights);
        }
    }

    // 🔽 MAIN METHOD
    public static void main(String[] args) {

        // Input array
        int[][] heights = {
            {1,2,2,3,5},
            {3,2,3,4,4},
            {2,4,5,3,1},
            {6,7,1,4,5},
            {5,1,1,2,4}
        };

        PacificAtlanticWaterFlow obj = new PacificAtlanticWaterFlow();

        // Call function
        List<List<Integer>> result = obj.pacificAtlantic(heights);

        // Print output as array
        System.out.print("[");
        for (int i = 0; i < result.size(); i++) {
            System.out.print(result.get(i));
            if (i != result.size() - 1) {
                System.out.print(",");
            }
        }
        System.out.println("]");
    }
}

