// Employee Free Time

// You are given a list of schedules for employees. Each employee has a list of non-overlapping working intervals.

// Return the common free time for all employees.

// A free interval is an interval where all employees are free.

// Example:
// Input:
// schedule = [
//     [[1,2], [5,6]],
//     [[1,3]],
//     [[4,10]]
// ]
// Output:
// [[3,4]]

// Explanation:
// Employee 1:  [1,2]      [5,6]
// Employee 2:  [1,3]
// Employee 3:  [4,10]
// Common free time:
//              [3,4]

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

class Interval {
    int start;
    int end;

    Interval(int start, int end) {
        this.start = start;
        this .end = end;
    }
}

public class EmployeeFreeTime {

    public List<Interval> employeeFreeTime(List<List<Interval>> schedule) {

        List<Interval> result = new ArrayList<>();
        PriorityQueue<Interval> pq = new PriorityQueue<>((a,b) -> a.start - b.start);

        // Add all intervals to the priority queue
        for(List<Interval> intervals: schedule) {
            pq.addAll(intervals);
        }

        Interval prev = pq.poll();
        while(!pq.isEmpty()) {
            Interval curr = pq.poll();
            if(prev.end < curr.start) {
                // There is a gap between prev and curr, which is a common free time
                result.add(new Interval(prev.end, curr.start));
                prev = curr;
            } else {
                // Overlapping intervals, update the end time if needed
                prev.end = Math.max(prev.end, curr.end);
            }
        }

        return result;
    }


    public static void main(String[] args) {

        // Input:
        // schedule = [
        //     [[1,2], [5,6]],
        //     [[1,3]],
        //     [[4,10]]
        // ]

        List<List<Interval>> schedule = new ArrayList<>();

        List<Interval> employee1 = new ArrayList<>();
        employee1.add(new Interval(1, 2));
        employee1.add(new Interval(5, 6));

        List<Interval> employee2 = new ArrayList<>();
        employee2.add(new Interval(1, 3));

        List<Interval> employee3 = new ArrayList<>();
        employee3.add(new Interval(4, 10));

        schedule.add(employee1);
        schedule.add(employee2);
        schedule.add(employee3);

        // Call method
        EmployeeFreeTime obj = new EmployeeFreeTime();
        List<Interval> result = obj.employeeFreeTime(schedule);

        // Print output in array format
        System.out.print("Output: [");

        for (int i = 0; i < result.size(); i++) {
            Interval interval = result.get(i);

            System.out.print("[" + interval.start + "," + interval.end + "]");

            if (i < result.size() - 1) {
                System.out.print(", ");
            }
        }

        System.out.println("]");
    }
}