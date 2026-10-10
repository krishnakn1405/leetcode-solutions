// Find Median from Data Stream

// The median is the middle value in an ordered integer list. If the size of the list is even, there is no middle value, and the median is the mean of the two middle values.

// For example, for arr = [2,3,4], the median is 3.
// For example, for arr = [2,3], the median is (2 + 3) / 2 = 2.5.
// Implement the MedianFinder class:

// MedianFinder() initializes the MedianFinder object.
// void addNum(int num) adds the integer num from the data stream to the data structure.
// double findMedian() returns the median of all elements so far. Answers within 10-5 of the actual answer will be accepted.

// Example 1:
// Input
// ["MedianFinder", "addNum", "addNum", "findMedian", "addNum", "findMedian"]
// [[], [1], [2], [], [3], []]

// Output
// [null, null, null, 1.5, null, 2.0]

// Explanation
// MedianFinder medianFinder = new MedianFinder();
// medianFinder.addNum(1);    // arr = [1]
// medianFinder.addNum(2);    // arr = [1, 2]
// medianFinder.findMedian(); // return 1.5 (i.e., (1 + 2) / 2)
// medianFinder.addNum(3);    // arr[1, 2, 3]
// medianFinder.findMedian(); // return 2.0

import java.util.PriorityQueue;
import java.util.Arrays;

class FindMedianFromDataStream {

    private PriorityQueue<Integer> lo = new PriorityQueue<>((a, b) -> b - a); // max heap
    private PriorityQueue<Integer> hi = new PriorityQueue<>(); // min heap

    public FindMedianFromDataStream() {}
    
    // Adds a number into the data structure
    public void addNum(int num) {
        lo.offer(num); // add to max heap

        hi.offer(lo.poll()); // balancing step

        if(lo.size() < hi.size()) { // maintain size property
            lo.offer(hi.poll());
        }
    }
    
    public double findMedian() {
        return lo.size() > hi.size() ? lo.peek() : (lo.peek() + hi.peek()) * 0.5;
    }


    public static void main(String[] args) {
        String[] operations = {
            "MedianFinder", "addNum", "addNum",
            "findMedian", "addNum", "findMedian"
        };

        int[][] values = {
            {}, {1}, {2}, {}, {3}, {}
        };

        FindMedianFromDataStream mf = null;
        Object[] output = new Object[operations.length];

        for (int i = 0; i < operations.length; i++) {
            switch (operations[i]) {
                case "MedianFinder":
                    mf = new FindMedianFromDataStream();
                    output[i] = null;
                    break;

                case "addNum":
                    mf.addNum(values[i][0]);
                    output[i] = null;
                    break;

                case "findMedian":
                    output[i] = mf.findMedian();
                    break;
            }
        }

        System.out.println(Arrays.toString(output));
    }

}

