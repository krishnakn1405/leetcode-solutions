// Moving Average from Data Stream

// Given a stream of integers and a window size, calculate the moving average of all integers in the sliding window.

// Implement the MovingAverage class:

// • MovingAverage (int size) Initializes the object with the size of the window size.
// • double next(int val) Returns the moving average of the last size values of the stream. 

// Example 1: 
// Input 
// ["MovingAverage", "next", "next", "next", "next"] 
// [[3], [1], [10], [3], [5]] 
// Output 
// [null, 1.0, 5.5, 4.66667, 6.0]

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.ArrayList;
import java.util.List;

class MovingAverage {

	int size, windowSum = 0, count = 0;
	Deque<Integer> queue = new ArrayDeque<Integer>();
	
	public MovingAverage(int size) {
		this.size = size;
	}

	public double next(int val) {
		++count;
		queue.add(val);
		int tail = count > size ? (int)queue.poll() : 0;
		
		windowSum = windowSum - tail + val;

		return windowSum * 1.0 / Math.min(size, count);
	}
}

public class MovingAverageFromDataStream {
    public static void main(String[] args) {

        // Input:
        // ["MovingAverage", "next", "next", "next", "next"]
        // [[3], [1], [10], [3], [5]]

        List<Object> output = new ArrayList<>();

        MovingAverage ma = new MovingAverage(3);
        output.add(null); // constructor output

        output.add(ma.next(1));
        output.add(ma.next(10));
        output.add(ma.next(3));
        output.add(ma.next(5));

        System.out.println(output);
    }

}
