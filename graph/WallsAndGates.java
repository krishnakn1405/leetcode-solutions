// Walls and Gates/Islands and Treasure

// You are given a m×n 2D grid initialized with these three possible values:

// -1 - A water cell that can not be traversed.
// 0 - A treasure chest.
// INF - A land cell that can be traversed. We use the integer 2^31 - 1 = 2147483647 to represent INF.
// Fill each land cell with the distance to its nearest treasure chest. If a land cell cannot reach a treasure chest then the value should remain INF.

// Assume the grid can only be traversed up, down, left, or right.

// Modify the grid in-place.

// Example 1:
// Input: [
//  [2147483647,-1,0,2147483647],
//  [2147483647,2147483647,2147483647,-1],
//  [2147483647,-1,2147483647,-1],
//  [0,-1,2147483647,2147483647]
// ]

// Output: [
//  [3,-1,0,1],
//  [2,2,1,-1],
//  [1,-1,2,-1],
//  [0,-1,3,4]
// ]

//Example 2:
// Input: [
//  [0,-1],
//  [2147483647,2147483647]
// ]

// Output: [
//  [0,-1],
//  [1,2]
// ]

import java.util.LinkedList;
import java.util.Queue;
import java.util.Arrays;

public class WallsAndGates {

	private static final int INF = 2147483647;
	private static final int[] DIRS = {0, 1, 0, -1, 0}; // 4-directional (right, down, left, up)

	public void wallsAndGates(int[][] rooms) {
		if(rooms == null || rooms.length == 0 || rooms[0].length == 0) return;

		int m = rooms.length, n = rooms[0].length;
		Queue<int[]> queue = new LinkedList<>();

		// Add gates to the queue
		for(int i=0; i<m; i++) {
			for(int j=0; j<n; j++) {
				if(rooms[i][j] == 0) {
					queue.offer(new int[]{i, j});
				}
			}
		}

		// BFS from each gate
		while(!queue.isEmpty()) {
			
			int[] gate = queue.poll();
			int row = gate[0];
			int col = gate[1];

			for(int i=0; i<4; i++) { // Explore 4 directions
				
				int newRow = row + DIRS[i];
				int newCol = col + DIRS[i+1];

				// Check boundaries and if the cell is an empty room
				if (newRow >= 0 && newRow < m && newCol >= 0 && newCol < n 
        && rooms[newRow][newCol] == INF) {
					rooms[newRow][newCol] = rooms[row][col] + 1; // Update distance
					queue.offer(new int[]{newRow, newCol});
				}
			}
		}
	}

    // 🔽 MAIN METHOD
    public static void main(String[] args) {

        int INF = 2147483647;

        int[][] rooms = {
                {INF, -1, 0, INF},
                {INF, INF, INF, -1},
                {INF, -1, INF, -1},
                {0, -1, INF, INF}
        };

        WallsAndGates obj = new WallsAndGates();
        obj.wallsAndGates(rooms);

        // Print output
        System.out.println("Output:");
        for (int[] row : rooms) {
            System.out.println(Arrays.toString(row));
        }
    }
} 




