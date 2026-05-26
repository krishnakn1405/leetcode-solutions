// Meeting Rooms
 
// Given an array of meeting time intervals where intervals [start, end] determine if a person could attend all meetings.
 
// Example 1: 
// Input: intervals = [[0,30], [5, 10], [15,20]]
// Output: false 
 
// Example 2:
// Input: intervals = [[7,10], [2,4]]
// Output: true

import java.util.Arrays;

class MeetingRooms {
	
	public boolean canAttendMeetings(int[][] intervals) {
		
		Arrays.sort(intervals, (a,b) -> Integer.compare(a[0], b[0]));

		for(int i=0; i<intervals.length-1; i++) {
			if(intervals[i][1] > intervals[i+1][0]) {
				return false;
			}
		}

		return true;
	}

    public static void main(String[] args) {

        MeetingRooms obj = new MeetingRooms();

        int[][] intervals = {
            {0, 30},
            {5, 10},
            {15, 20}
        };

        boolean result = obj.canAttendMeetings(intervals);

        System.out.println("Can attend all meetings: " + result);
    }
}



