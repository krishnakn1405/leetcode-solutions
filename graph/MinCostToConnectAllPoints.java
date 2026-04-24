// Min Cost to Connect All Points

// You are given an array points representing integer coordinates of some points on a 2D-plane, where points[i] = [xi, yi].

// The cost of connecting two points [xi, yi] and [xj, yj] is the manhattan distance between them: |xi - xj| + |yi - yj|, where |val| denotes the absolute value of val.

// Return the minimum cost to make all points connected. All points are connected if there is exactly one simple path between any two points.

// Example 1:
// Input: points = [[0,0],[2,2],[3,10],[5,2],[7,0]]
// Output: 20
// Explanation: 
// We can connect the points as shown above to get the minimum cost of 20.
// Notice that there is a unique path between every pair of points.

// Example 2:
// Input: points = [[3,12],[-2,5],[-4,1]]
// Output: 18

import java.util.PriorityQueue;

class MinCostToConnectAllPoints {
    public int minCostConnectPoints(int[][] points) {
        
        int n = points.length;
        PriorityQueue<Point> pq = new PriorityQueue<>((a,b) -> a.distance - b.distance);
        boolean[] inMST = new boolean[n]; // Whether a point is already in the MST

        // Start with the first point
        pq.offer(new Point(0, 0));

        int minCost = 0;
        int pointsConnected = 0;
        while(pointsConnected < n) {
            Point current = pq.poll();
            if(inMST[current.index]) {
                continue; // Skip if the point is already in the MST
            }
            inMST[current.index] = true;
            minCost += current.distance;
            pointsConnected++;

            // Update the priority queue with distances to the new point in the MST
            for(int i=0; i<n; i++) {
                if(!inMST[i]) {
                    int distance = Math.abs(points[current.index][0] - points[i][0]) + Math.abs(points[current.index][1] - points[i][1]);
                    pq.offer(new Point(i, distance));
                }
            }
        }

        return minCost;
    }

    static class Point {
        int index;
        int distance;

        Point(int index, int distance) {
            this.index = index;
            this.distance = distance;
        }
    }

    // 🔹 MAIN METHOD
    public static void main(String[] args) {

        int[][] points = {
            {0, 0},
            {2, 2},
            {3, 10},
            {5, 2},
            {7, 0}
        };

        MinCostToConnectAllPoints obj = new MinCostToConnectAllPoints();
        int result = obj.minCostConnectPoints(points);

        System.out.println("Minimum Cost: " + result);
    }
}



