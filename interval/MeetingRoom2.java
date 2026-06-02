// Meeting Rooms II

// Given an array of meeting time intervals intervals where intervals[i] = [start_i, end_i], return the minimum number of conference rooms required.
 
// Example 1:
// Input: intervals = [[0,30],[5,10],[15,20]]
// Output: 2
 
// Example 2:
// Input: intervals = [[7,10],[2,4]]
// Output: 1

import java.util.Arrays;

class MeetingRoom2 {
    public int minMeetingRooms(int[][] intervals) {

        if(intervals.length == 0) {
            return 0;
        }

        int[] start = new int[intervals.length];
        int[] end = new int[intervals.length];

        for(int i=0; i<intervals.length; i++) {
            start[i] = intervals[i][0];
            end[i] = intervals[i][1];
        }

        Arrays.sort(start);
        Arrays.sort(end);

        int startptr = 0;
        int endptr = 0;

        int result = 0;

        while(startptr < start.length) {
            
            if(start[startptr] >= end[endptr]) {
                result--;
                endptr++;
            }
            result++;
            startptr++;
        }
        
        return result;
    }

    public static void main(String[] args) {
        MeetingRoom2 obj = new MeetingRoom2();

        int[][] intervals = {
            {0, 30},
            {5, 10},
            {15, 20}
        };

        int rooms = obj.minMeetingRooms(intervals);

        System.out.println("Minimum meeting rooms required: " + rooms);
    }
}




