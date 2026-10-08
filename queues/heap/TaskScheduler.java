// Task Scheduler

// You are given an array of CPU tasks, each labeled with a letter from A to Z, and a number n. Each CPU interval can be idle or allow the completion of one task. Tasks can be completed in any order, but there's a constraint: there has to be a gap of at least n intervals between two tasks with the same label.

// Return the minimum number of CPU intervals required to complete all tasks.

// Example 1:
// Input: tasks = ["A","A","A","B","B","B"], n = 2
// Output: 8
// Explanation: A possible sequence is: A -> B -> idle -> A -> B -> idle -> A -> B.
// After completing task A, you must wait two intervals before doing A again. The same applies to task B. In the 3rd interval, neither A nor B can be done, so you idle. By the 4th interval, you can do A again as 2 intervals have passed.

// Example 2:
// Input: tasks = ["A","C","A","B","D","B"], n = 1
// Output: 6
// Explanation: A possible sequence is: A -> B -> C -> D -> A -> B.
// With a cooling interval of 1, you can repeat a task after just one other task.

// Example 3:
// Input: tasks = ["A","A","A", "B","B","B"], n = 3
// Output: 10
// Explanation: A possible sequence is: A -> B -> idle -> idle -> A -> B -> idle -> idle -> A -> B.
// There are only two types of tasks, A and B, which need to be separated by 3 intervals. This leads to idling twice between repetitions of these tasks.

import java.util.Map;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.List;
import java.util.ArrayList;

class TaskScheduler {
    public int leastInterval(char[] tasks, int n) {
        
        // Step 1: Count the frequency of each task
        Map<Character, Integer> freqMap = new HashMap<>();
        for(char task: tasks) {
            freqMap.put(task, freqMap.getOrDefault(task, 0) + 1);
        }

        // Step 2: Build a max heap based on the frequency
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a,b) -> b-a);
        maxHeap.addAll(freqMap.values());

        // Step 3: Process tasks
        int time = 0;
        while(!maxHeap.isEmpty()) {
            List<Integer> temp = new ArrayList<>();
            for(int i=0; i<n+1; i++) {
                if(!maxHeap.isEmpty()) {
                    temp.add(maxHeap.poll());
                }
            }

            for(int freq: temp) {
                if(--freq > 0) {
                    maxHeap.add(freq);
                }
            }

            // Step 4: Update time
            time += maxHeap.isEmpty() ? temp.size() : n+1;
        }

        return time;
    }

    public static void main(String[] args) {
        TaskScheduler scheduler = new TaskScheduler();

        char[] tasks = {'A', 'A', 'A', 'B', 'B', 'B'};
        int n = 2;

        int result = scheduler.leastInterval(tasks, n);

        System.out.println("Output: " + result);
    }

}
