// Open the Lock

// You have a lock in front of you with 4 circular wheels. Each wheel has 10 slots: '0', '1', '2', '3', '4', '5', '6', '7', '8', '9'. The wheels can rotate freely and wrap around: for example we can turn '9' to be '0', or '0' to be '9'. Each move consists of turning one wheel one slot.

// The lock initially starts at '0000', a string representing the state of the 4 wheels.

// You are given a list of deadends dead ends, meaning if the lock displays any of these codes, the wheels of the lock will stop turning and you will be unable to open it.

// Given a target representing the value of the wheels that will unlock the lock, return the minimum total number of turns required to open the lock, or -1 if it is impossible.

// Example 1:
// Input: deadends = ["0201","0101","0102","1212","2002"], target = "0202"
// Output: 6
// Explanation: A sequence of valid moves would be "0000" -> "1000" -> "1100" -> "1200" -> "1201" -> "1202" -> "0202".
// Note that a sequence like "0000" -> "0001" -> "0002" -> "0102" -> "0202" would be invalid, because the wheels of the lock become stuck after the display becomes the dead end "0102".

// Example 2:
// Input: deadends = ["8888"], target = "0009"
// Output: 1
// Explanation: We can turn the last wheel in reverse to move from "0000" -> "0009".

// Example 3:
// Input: deadends = ["8887","8889","8878","8898","8788","8988","7888","9888"], target = "8888"
// Output: -1
// Explanation: We cannot reach the target without getting stuck.

import java.util.Arrays;
import java.util.HashSet;
import java.util.Queue;
import java.util.ArrayDeque;
import java.util.Set;

class OpenTheLock {
    public int openLock(String[] deadends, String target) {
        
        Set<String> dead = new HashSet<>(Arrays.asList(deadends));
        if(dead.contains("0000")) return -1;
        if("0000".equals(target)) return 0;

        Queue<String> q = new ArrayDeque<>();
        Set<String> seen = new HashSet<>();
        q.offer("0000");
        seen.add("0000");

        int steps = 0;

        while(!q.isEmpty()) {
            
            int size = q.size();
            for(int s=0; s<size; s++) {
                String cur = q.poll();
                if(dead.contains(cur)) continue; // skip blocked states
                if(cur.equals(target)) return steps; // reached in minimum moves

                // generate neighbors by turning each wheel +/- 1
                char[] cs = cur.toCharArray();
                for(int i=0; i<4; i++) {

                    char orig = cs[i];
                    int d = orig - '0';

                    // turn up
                    cs[i] = (char) ('0' + ((d+1) % 10));
                    String up = new String(cs);
                    if(!dead.contains(up) && seen.add(up)) q.offer(up);

                    // turn down
                    cs[i] = (char) ('0' + ((d+9) % 10)); // (d-1+10)%10
                    String down = new String(cs);
                    if(!dead.contains(down) && seen.add(down)) q.offer(down);
                    cs[i] = orig; // restore for next wheel
                }
            }
            steps++;
        }
        return -1;
    }

    public static void main(String[] args) {

        String[] deadends = {
            "0201",
            "0101",
            "0102",
            "1212",
            "2002"
        };

        String target = "0202";

        OpenTheLock obj = new OpenTheLock();

        int output = obj.openLock(deadends, target);

        System.out.println("Output: " + output);
    }
}

