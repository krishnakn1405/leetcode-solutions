// Number of Islands

// Given an m x n 2D binary grid grid which represents a map of '1's (land) and '0's (water), return the number of islands.

// An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.

// Example 1:
// Input: grid = [
//   ["1","1","1","1","0"],
//   ["1","1","0","1","0"],
//   ["1","1","0","0","0"],
//   ["0","0","0","0","0"]
// ]
// Output: 1

// Example 2:
// Input: grid = [
//   ["1","1","0","0","0"],
//   ["1","1","0","0","0"],
//   ["0","0","1","0","0"],
//   ["0","0","0","1","1"]
// ]
// Output: 3

class NumberOfIslands {
    public int numIslands(char[][] grid) {
        
        int row = grid.length;
        int col = grid[0].length;

        int island = 0;

        for(int i=0; i<row; i++) {
            for(int j=0; j<col; j++) {
                if(grid[i][j] == '1') {
                    island++;
                    dfs(i, j, grid);
                }
            }
        }

        return island;
    }

    public void dfs(int row, int col, char[][] grid) {

        int newRow = grid.length;
        int newCol = grid[0].length;

        int[][] directions = new int[][]{{0,1}, {1,0}, {0,-1}, {-1,0}};

        if(row<0 || col<0 || row>= newRow | col>=newCol || grid[row][col] == '0') {
            return;
        }

        grid[row][col] = '0';

        for(int[] dir: directions) {
            dfs(row+dir[0], col+dir[1], grid);
        }
    }

    public static void main(String[] args) {
        char[][] grid = {
            {'1', '1', '0', '0', '0'},
            {'1', '1', '0', '0', '0'},
            {'0', '0', '1', '0', '0'},
            {'0', '0', '0', '1', '1'}
        };

        NumberOfIslands obj = new NumberOfIslands();
        int result = obj.numIslands(grid);

        System.out.println("Number of islands: " + result);
    }
}