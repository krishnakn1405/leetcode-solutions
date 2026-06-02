// Insert Interval

// You are given an array of non-overlapping intervals intervals where intervals[i] = [starti, endi] represent the start and the end of the ith interval and intervals is sorted in ascending order by starti. You are also given an interval newInterval = [start, end] that represents the start and end of another interval.

// Insert newInterval into intervals such that intervals is still sorted in ascending order by starti and intervals still does not have any overlapping intervals (merge overlapping intervals if necessary).

// Return intervals after the insertion.

// Note that you don't need to modify intervals in-place. You can make a new array and return it.

// Example 1:
// Input: intervals = [[1,3],[6,9]], newInterval = [2,5]
// Output: [[1,5],[6,9]]

// Example 2:
// Input: intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
// Output: [[1,2],[3,10],[12,16]]
// Explanation: Because the new interval [4,8] overlaps with [3,5],[6,7],[8,10].

import java.util.Arrays;
import java.util.LinkedList;

class InsertInterval {
    public int[][] insert(int[][] intervals, int[] newInterval) {

        int newStart = newInterval[0];
        int newEnd = newInterval[1];
        int left = 0;
        int right = intervals.length;

        LinkedList<int[]> output = new LinkedList<int[]>();

        while(left<right && newStart>intervals[left][0]) {
            output.add(intervals[left]);
            left++;
        }

        int[] interval = new int[2];

        if(output.isEmpty() || output.getLast()[1] < newStart) {
            output.add(newInterval);
        } else {
            interval = output.removeLast();
            interval[1] = Math.max(interval[1], newEnd);
            output.add(interval);
        }

        while(left < right) {
            interval = intervals[left];
            left++;
            int start = interval[0], end = interval[1];

            if(output.getLast()[1] < start) {
                output.add(interval);
            } else {
                interval = output.removeLast();
                interval[1] = Math.max(interval[1], end);
                output.add(interval);
            }
        }

        return output.toArray(new int[output.size()][2]);
    }

    public static void main(String[] args) {

        InsertInterval obj = new InsertInterval();

        int[][] intervals = {
            {1, 2},
            {3, 5},
            {6, 7},
            {8, 10},
            {12, 16}
        };

        int[] newInterval = {4, 8};

        int[][] result = obj.insert(intervals, newInterval);

        System.out.println("Output:");

        System.out.print("[");

        for(int i = 0; i < result.length; i++) {

            System.out.print(Arrays.toString(result[i]));

            if(i != result.length - 1) {
                System.out.print(", ");
            }
        }

        System.out.println("]");
    }
}



