// Surrounded Regions

// You are given an m x n matrix board containing letters 'X' and 'O', capture regions that are surrounded:

// Connect: A cell is connected to adjacent cells horizontally or vertically.
// Region: To form a region connect every 'O' cell.
// Surround: A region is surrounded if none of the 'O' cells in that region are on the edge of the board. Such regions are completely enclosed by 'X' cells.
// To capture a surrounded region, replace all 'O's with 'X's in-place within the original board. You do not need to return anything.

// Example 1:
// Input: board = [["X","X","X","X"],["X","O","O","X"],["X","X","O","X"],["X","O","X","X"]]
// Output: [["X","X","X","X"],["X","X","X","X"],["X","X","X","X"],["X","O","X","X"]]
// Explanation: In the above diagram, the bottom region is not captured because it is on the edge of the board and cannot be surrounded.

// Example 2:
// Input: board = [["X"]]
// Output: [["X"]]

import java.util.Arrays;

class SurroundedRegions {
    public void solve(char[][] board) {
        
        if(board == null || board.length == 0) return;
        int m = board.length, n = board[0].length;

        // Mark boundary-connected 'O's with 'T'
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if((i==0 || i==m-1 || j==0 || j==n-1) && board[i][j] == 'O') {
                    dfs(board, i, j);
                }
            }
        }

        // Capture surrounded regions and revert 'T' to 'O'
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if(board[i][j] == 'O') {
                    board[i][j] = 'X';
                } else if(board[i][j] == 'T') {
                    board[i][j] = 'O';
                }
            }
        }
    }

    private void dfs(char[][] board, int i, int j) {
        if(i<0 || i>=board.length || j<0 || j>=board[i].length || board[i][j] != 'O') {
            return;
        }

        board[i][j] = 'T'; // Mark as visited
        dfs(board, i+1, j);
        dfs(board, i-1, j);
        dfs(board, i, j+1);
        dfs(board, i, j-1);
    }

    // ✅ MAIN METHOD
    public static void main(String[] args) {

        char[][] board = {
            {'X','X','X','X'},
            {'X','O','O','X'},
            {'X','X','O','X'},
            {'X','O','X','X'}
        };

        SurroundedRegions obj = new SurroundedRegions();
        obj.solve(board);

        // Print output
        System.out.println("Output:");
        for (char[] row : board) {
            System.out.println(Arrays.toString(row));
        }
    }
}


