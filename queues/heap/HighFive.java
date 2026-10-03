// High Five

// Given a list of the scores of different students, items, where items[i] = [ID_i, score_i] represents one score from a student with ID_i, calculate each student's top five average.

// Return the answer as an array of pairs result, where result[j] = [ID_j, topFiveAverage_j] represents the student with ID_j and their top five average. Sort result by ID_j in increasing order.

// A student's top five average is calculated by taking the sum of their top five scores and dividing it by 5 using integer division.

// Example 1:
// Input: items = [[1,91],[1,92],[2,93],[2,97],[1,60],[2,77],[1,65],[1,87],[1,100],[2,100],[2,76]]
// Output: [[1,87],[2,88]]
// Explanation: The student with ID = 1 got scores 91, 92, 60, 65, 87, and 100. Their top five average is (100 + 92 + 91 + 87 + 65) / 5 = 87. The student with ID = 2 got scores 93, 97, 77, 100, and 76. Their top five average is (100 + 97 + 93 + 77 + 76) / 5 = 88.6, but with integer division their average converts to 88.

import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;
import java.util.PriorityQueue;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

class HighFive {
    public int[][] highFive(int[][] items) {

        Map<Integer, Queue<Integer>> scores = new TreeMap<>();

        for(int[] item: items) {
            int id = item[0];
            int score = item[1];

            if(!scores.containsKey(id)) {
                scores.put(id, new PriorityQueue<>((a,b) -> b-a));
            }
            scores.get(id).add(score);
        }

        List<int[]> ans = new ArrayList<>();

        for(int id:scores.keySet()) {
            int sum=0;

            for(int i=0; i<5; i++) {
                sum = sum+scores.get(id).poll();
            }

            ans.add(new int[]{id, sum/5});
        }

        int[][] ansArray = new int[ans.size()][];

        return ans.toArray(ansArray);
    }

    public static void main(String[] args) {

        int[][] items = {
            {1, 91},
            {1, 92},
            {2, 93},
            {2, 97},
            {1, 60},
            {2, 77},
            {1, 65},
            {1, 87},
            {1, 100},
            {2, 100},
            {2, 76}
        };

        HighFive obj = new HighFive();

        int[][] output = obj.highFive(items);

        // Print output in [[1,87],[2,88]] format
        System.out.print("[");

        for (int i = 0; i < output.length; i++) {
            System.out.print("[" + output[i][0] + "," + output[i][1] + "]");

            if (i < output.length - 1) {
                System.out.print(",");
            }
        }

        System.out.println("]");
    }
}