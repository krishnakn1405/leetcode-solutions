// Set Matrix Zeroes

// Given an m x n integer matrix matrix, if an element is 0, set its entire row and column to 0's.

// You must do it in place.

// Example 1:
// Input: matrix = [[1,1,1],[1,0,1],[1,1,1]]
// Output: [[1,0,1],[0,0,0],[1,0,1]]

// Example 2:
// Input: matrix = [[0,1,2,0],[3,4,5,2],[1,3,1,5]]
// Output: [[0,0,0,0],[0,4,5,0],[0,3,1,0]]


class SetMatrixZeroes {
    public void setZeroes(int[][] matrix) {
        
        Boolean firstcol = false;
        int r = matrix.length;
        int c = matrix[0].length;

        for(int i=0; i<r; i++) {
            if(matrix[i][0] == 0) {
                firstcol = true;
            }
            for(int j=1; j<c; j++) {
                if(matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }

        for(int i=1; i<r; i++) {
            for(int j=1; j<c; j++) {
                if(matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }

        if(matrix[0][0] == 0) {
            for(int j=0; j<c; j++) {
                matrix[0][j] = 0;
            }
        }

        if(firstcol) {
            for(int i=0; i<r; i++) {
                matrix[i][0] = 0;
            }
        }
    }

    public static void main(String[] args) {

        int[][] matrix = {
            {1, 1, 1},
            {1, 0, 1},
            {1, 1, 1}
        };

        System.out.println("Input Matrix:");
        printMatrix(matrix);

        SetMatrixZeroes obj = new SetMatrixZeroes();
        obj.setZeroes(matrix);

        System.out.println("\nOutput Matrix:");
        printMatrix(matrix);
    }

    public static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int num : row) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }
}



