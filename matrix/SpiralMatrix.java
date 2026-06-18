// Spiral Matrix

// Example 1:
// Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
// Output: [1,2,3,6,9,8,7,4,5]

// Example 2:
// Input: matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
// Output: [1,2,3,4,8,12,11,10,9,5,6,7]

import java.util.List;
import java.util.ArrayList;

class SpiralMatrix {
    public List<Integer> spiralOrder(int[][] matrix) {
        
        int visited = 101;
        int rows = matrix.length;
        int columns = matrix[0].length;

        int row = 0, col = 0;

        int[][] directions = {{0,1}, {1,0}, {0,-1}, {-1,0}};

        int currentdirection = 0, changeddirection = 0;

        List<Integer> ans = new ArrayList<>();
        ans.add(matrix[0][0]);
        matrix[0][0] = visited;
        while(changeddirection < 2) {
            while(row + directions[currentdirection][0] >= 0 &&
                    row + directions[currentdirection][0] < rows &&
                    col + directions[currentdirection][1] >= 0 &&
                    col + directions[currentdirection][1] < columns &&
                    matrix[row + directions[currentdirection][0]][col + directions[currentdirection][1]] != visited) {

                        changeddirection = 0;
                        row = row + directions[currentdirection][0];
                        col = col + directions[currentdirection][1];

                        ans.add(matrix[row][col]);
                        matrix[row][col] = visited;
            }
            currentdirection = (currentdirection + 1) % 4;
            changeddirection++;
        }

        return ans;
    }

    public static void main(String[] args) {

        int[][] matrix = {
            {1, 2, 3, 4},
            {5, 6, 7, 8},
            {9, 10, 11, 12}
        };

        SpiralMatrix obj = new SpiralMatrix();

        List<Integer> result = obj.spiralOrder(matrix);

        System.out.println("Input:");
        System.out.println("[[1,2,3,4],[5,6,7,8],[9,10,11,12]]");

        System.out.println("\nOutput:");
        System.out.println(result);
    }
}


