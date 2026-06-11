// N-Queens

// The n-queens puzzle is the problem of placing n queens on an n x n chessboard such that no two queens attack each other.

// Given an integer n, return all distinct solutions to the n-queens puzzle. You may return the answer in any order.

// Each solution contains a distinct board configuration of the n-queens' placement, where 'Q' and '.' both indicate a queen and an empty space, respectively.

// Example 1:
// Input: n = 4
// Output: [[".Q..","...Q","Q...","..Q."],["..Q.","Q...","...Q",".Q.."]]
// Explanation: There exist two distinct solutions to the 4-queens puzzle as shown above

// Example 2:
// Input: n = 1
// Output: [["Q"]]

import java.util.ArrayList;
import java.util.List;

class NQueens {
    public List<List<String>> solveNQueens(int n) {
        char[][] board = new char[n][n];
        for(int i=0;i<n;i++) {
            for(int j=0; j<n; j++) {
                board[i][j] = '.';
            }
        }
        List<List<String>> result = new ArrayList<>();
        backtrack(board, 0, result);
        return result;
    }

    private void backtrack(char[][] board, int col, List<List<String>> result) {
        if(col == board.length) {
            result.add(construct(board));
            return;
        }

        for(int i=0; i<board.length; i++) {
            if(isValid(board, i, col)) {
                board[i][col] = 'Q';
                backtrack(board, col+1, result);
                board[i][col] = '.';
            }
        }
    }

    private boolean isValid(char[][] board, int row, int col) {

        for(int i=0;i<col; i++) {
            if(board[row][i] == 'Q') {
                return false;
            }
        }

        for(int i=row, j=col; i>=0 && j>=0; i--, j--) {
            if(board[i][j] == 'Q') {
                return false;
            }
        }

        for(int i=row, j=col; i<board.length && j>=0; i++, j--) {
            if(board[i][j] == 'Q') {
                return false;
            }
        }

        return true;
    }

    private List<String> construct(char[][] board) {
        List<String> result = new ArrayList<>();
        for(int i=0; i<board.length; i++) {
            String row = new String(board[i]);
            result.add(row);
        }
        return result;
    }

    public static void main(String[] args) {
        
        int n = 4;

        NQueens solution = new NQueens();
        List<List<String>> result = solution.solveNQueens(n);

        System.out.println(result);
    }
}



