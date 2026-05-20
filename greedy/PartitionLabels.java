// Partition Labels

// You are given a string s. We want to partition the string into as many parts as possible so that each letter appears in at most one part. For example, the string "ababcc" can be partitioned into ["abab", "cc"], but partitions such as ["aba", "bcc"] or ["ab", "ab", "cc"] are invalid.

// Note that the partition is done so that after concatenating all the parts in order, the resultant string should be s.

// Return a list of integers representing the size of these parts.

// Example 1:
// Input: s = "ababcbacadefegdehijhklij"
// Output: [9,7,8]
// Explanation:
// The partition is "ababcbaca", "defegde", "hijhklij".
// This is a partition so that each letter appears in at most one part.
// A partition like "ababcbacadefegde", "hijhklij" is incorrect, because it splits s into less parts.

// Example 2:
// Input: s = "eccbbbbdec"
// Output: [10]

import java.util.ArrayList;
import java.util.List;

class PartitionLabels {
    public List<Integer> partitionLabels(String s) {
        
        // Step 1: Store the last occurrence of each character
        int[] lastOccurrence = new int[26]; // Since the input is lowercase English letters
        for(int i=0; i<s.length(); i++) {
            lastOccurrence[s.charAt(i) - 'a'] = i;
        }

        // Step 2: Iterate through the string to determine partitions
        List<Integer> result = new ArrayList<>();
        int partitionEnd = 0;
        int partitionStart = 0;

        for(int i=0; i<s.length(); i++) {
            partitionEnd = Math.max(partitionEnd, lastOccurrence[s.charAt(i) - 'a']);

            // When we reach the end of the current partition
            if(i == partitionEnd) {
                result.add(partitionEnd - partitionStart + 1);
                partitionStart = i+1; // Move to the next partition
            }
        }

        return result;
    }


    public static void main(String[] args) {

        PartitionLabels obj = new PartitionLabels();

        String s = "ababcbacadefegdehijhklij";

        List<Integer> answer = obj.partitionLabels(s);

        System.out.println("Input: " + s);
        System.out.println("Output: " + answer);
    }

}



