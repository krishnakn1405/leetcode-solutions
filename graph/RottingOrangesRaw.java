public class RottingOrangesRaw {

    public int orangesRotting(int[][] grid) {

        if (grid == null || grid.length == 0) return -1;

        int m = grid.length, n = grid[0].length;
        int freshCount = 0;

        // Manual queue
        int[][] queue = new int[m * n][2];
        int front = 0, rear = 0;

        // Initialize
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    freshCount++;
                } else if (grid[i][j] == 2) {
                    queue[rear][0] = i;
                    queue[rear][1] = j;
                    rear++;
                }
            }
        }

        if (freshCount == 0) return 0;

        int minutes = 0;
        int[][] directions = {{1,0}, {-1,0}, {0,1}, {0,-1}};

        // BFS using manual queue
        while (front < rear) {
            int size = rear - front;
            boolean rottedThisRound = false;

            for (int i = 0; i < size; i++) {
                int[] rotten = queue[front++];
                
                for (int[] dir : directions) {
                    int x = rotten[0] + dir[0];
                    int y = rotten[1] + dir[1];

                    if (x >= 0 && x < m && y >= 0 && y < n && grid[x][y] == 1) {
                        grid[x][y] = 2;
                        freshCount--;
                        
                        queue[rear][0] = x;
                        queue[rear][1] = y;
                        rear++;

                        rottedThisRound = true;
                    }
                }
            }

            if (rottedThisRound) minutes++;
        }

        return freshCount == 0 ? minutes : -1;
    }

    public static void main(String[] args) {
        RottingOranges obj = new RottingOranges();

        int[][] grid = {
            {2, 1, 1},
            {1, 1, 0},
            {0, 1, 1}
        };

        int result = obj.orangesRotting(grid);
        System.out.println("Output: " + result);
    }
}


