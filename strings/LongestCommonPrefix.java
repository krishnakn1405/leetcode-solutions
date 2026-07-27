// Longest Common Prefix

// Write a function to find the longest common prefix string amongst an array of strings.

// If there is no common prefix, return an empty string "".

// Example 1:
// Input: strs = ["flower","flow","flight"]
// Output: "fl"

// Example 2:
// Input: strs = ["dog","racecar","car"]
// Output: ""
// Explanation: There is no common prefix among the input strings.

import java.util.Arrays;

class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        
        if(strs == null || strs.length == 0) return "";

        // Start with the first string in the array as the initial prefix
        String prefix = strs[0];

        // Compare the current prefix with each string in the array.
        for(int i=1; i<strs.length; i++) {
            // Narrow down the prefix with each comparision
            while(strs[i].indexOf(prefix) != 0) {
                // Shorten the prefix by one character from the end
                prefix = prefix.substring(0, prefix.length() - 1);

                // If the prefix becomes empty, there is no common prefix
                if(prefix.isEmpty()) return "";
            }
        }

        return prefix;
    }

    public static void main(String[] args) {
        String[] strs = {"flower", "flow", "flight"};

        LongestCommonPrefix lcp = new LongestCommonPrefix();
        String output = lcp.longestCommonPrefix(strs);

        System.out.println("Input: strs = " + Arrays.toString(strs));
        System.out.println("Output: \"" + output + "\"");
    }

}
