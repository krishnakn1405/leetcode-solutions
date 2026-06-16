// Detect Squares

// You are given a stream of points on the X-Y plane. Design an algorithm that:

// Adds new points from the stream into a data structure. Duplicate points are allowed and should be treated as different points.
// Given a query point, counts the number of ways to choose three points from the data structure such that the three points and the query point form an axis-aligned square with positive area.
// An axis-aligned square is a square whose edges are all the same length and are either parallel or perpendicular to the x-axis and y-axis.

// Implement the DetectSquares class:

// DetectSquares() Initializes the object with an empty data structure.
// void add(int[] point) Adds a new point point = [x, y] to the data structure.
// int count(int[] point) Counts the number of ways to form axis-aligned squares with point point = [x, y] as described above.

// Example 1:
// Input
// ["DetectSquares", "add", "add", "add", "count", "count", "add", "count"]
// [[], [[3, 10]], [[11, 2]], [[3, 2]], [[11, 10]], [[14, 8]], [[11, 2]], [[11, 10]]]
// Output
// [null, null, null, null, 1, 0, null, 2]

// Explanation
// DetectSquares detectSquares = new DetectSquares();
// detectSquares.add([3, 10]);
// detectSquares.add([11, 2]);
// detectSquares.add([3, 2]);
// detectSquares.count([11, 10]); // return 1. You can choose:
                               //   - The first, second, and third points
// detectSquares.count([14, 8]);  // return 0. The query point cannot form a square with any points in the data structure.
// detectSquares.add([11, 2]);    // Adding duplicate points is allowed.
// detectSquares.count([11, 10]); // return 2. You can choose:
                               //   - The first, second, and third points
                               //   - The first, third, and fourth points

import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

class DetectSquares {

    // Map to store frequency of points: map of x-coordinate to (map of y-coordinate to frequency)
    private Map<Integer, Map<Integer, Integer>> pointsCount;

    public DetectSquares() {
        pointsCount = new HashMap<>();    
    }
    // Adds a new point[x, y] to the data structure
    public void add(int[] point) {
        int x = point[0], y = point[1];
        pointsCount.putIfAbsent(x, new HashMap<>());
        pointsCount.get(x).put(y, pointsCount.get(x).getOrDefault(y,0) + 1);
    }
    
    // Counts the number of ways to form axis-aligned squares with point [x1, y1]
    public int count(int[] point) {
        
        int x1 = point[0], y1 = point[1];
        int totalSquares = 0;

        // Check all points that share the same x-coordinate with the query point
        if(!pointsCount.containsKey(x1)) {
            return 0;
        }

        // Iterate over all y-coordinates for the current x1
        for(Map.Entry<Integer, Integer> entry: pointsCount.get(x1).entrySet()) {
            int y2 = entry.getKey();
            int countY2 = entry.getValue();

            // We need y2 to be different from y1 to form a square (side length of square)
            if(y2 == y1) {
                continue;
            }

            int sideLength =Math.abs(y2 - y1);

            // Check the two possible square points horizontally:
            // (x1 + sideLength, y1) and (x1 + sideLength, y2)
            totalSquares += countSquares(x1, y1, x1 + sideLength, y1, y2, countY2);

            // Check the two possible square points horizontally on the other side:
            // (x1 - sideLength, y1) and (x1 - sideLength, y2) 
            totalSquares += countSquares(x1, y1, x1 - sideLength, y1, y2, countY2);
        }

        return totalSquares;
    }

    // Helper function to count squares formed for the given coordiantes
    private int countSquares(int x1, int y1, int x3, int y3, int y2, int countY2) {
        if(pointsCount.containsKey(x3)) {
            Map<Integer, Integer> x3Points = pointsCount.get(x3);
            return x3Points.getOrDefault(y1, 0) * x3Points.getOrDefault(y2, 0) * countY2;
        }
        return 0;
    }

    public static void main(String[] args) {

        String[] operations = {
                "DetectSquares",
                "add",
                "add",
                "add",
                "count",
                "count",
                "add",
                "count"
        };

        int[][][] values = {
                {},
                {{3, 10}},
                {{11, 2}},
                {{3, 2}},
                {{11, 10}},
                {{14, 8}},
                {{11, 2}},
                {{11, 10}}
        };

        List<Object> output = new ArrayList<>();

        DetectSquares ds = null;

        for (int i = 0; i < operations.length; i++) {

            String op = operations[i];

            switch (op) {

                case "DetectSquares":
                    ds = new DetectSquares();
                    output.add(null);
                    break;

                case "add":
                    ds.add(values[i][0]);
                    output.add(null);
                    break;

                case "count":
                    output.add(ds.count(values[i][0]));
                    break;
            }
        }

        System.out.println(output);
    }

}




