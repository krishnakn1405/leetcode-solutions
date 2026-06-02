// Remove Interval

// A set of real numbers can be represented as the union of several disjoint intervals, where each interval is in the form [a, b). A real number x is in the set if one of its intervals [a, b) contains x (i.e. a \le x < b).

// You are given a sorted list of disjoint intervals intervals representing a set of real numbers as described above, where intervals[i] = [a_i, b_i] represents the interval [a_i, b_i). You are also given another interval toBeRemoved.

// Return the set of real numbers with the interval toBeRemoved removed from intervals. In other words, return the set of real numbers such that every x in the set is in intervals but not in toBeRemoved. Your answer should be a sorted list of disjoint intervals as described above.

// Example 1:
// Input: intervals = [[0,2],[3,4],[5,7]], toBeRemoved = [1,6]
// Output: [[0,1],[6,7]]

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class RemoveInterval {
    public List<List<Integer>> removeInterval(int[][] intervals, int[] toBeRemoved) {
        
        List<List<Integer>> result = new ArrayList<>();

        for(int[] interval: intervals) {
            // If there are no overlaps, add the interval to the list as is
            if(interval[0] > toBeRemoved[1] || interval[1] < toBeRemoved[0]) {
                result.add(Arrays.asList(interval[0], interval[1]));
            } else {
                // Is there a left interval we need to keep?
                if(interval[0] < toBeRemoved[0]) {
                    result.add(Arrays.asList(interval[0], toBeRemoved[0]));
                }

                // Is there a right interval we need to keep
                if(interval[1] > toBeRemoved[1]) {
                    result.add(Arrays.asList(toBeRemoved[1], interval[1]));
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {

        int[][] intervals = {
            {0, 2},
            {3, 4},
            {5, 7}
        };

        int[] toBeRemoved = {1, 6};

        RemoveInterval obj = new RemoveInterval();

        List<List<Integer>> result = obj.removeInterval(intervals, toBeRemoved);

        System.out.println("Output:");
        for (List<Integer> interval : result) {
            System.out.println(interval);
        }
    }
}




