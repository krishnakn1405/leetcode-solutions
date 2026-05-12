// Word Break

// Given a string s and a dictionary of strings wordDict, return true if s can be segmented into a space-separated sequence of one or more dictionary words.

// Note that the same word in the dictionary may be reused multiple times in the segmentation.

// Example 1:
// Input: s = "leetcode", wordDict = ["leet","code"]
// Output: true
// Explanation: Return true because "leetcode" can be segmented as "leet code".

// Example 2:
// Input: s = "applepenapple", wordDict = ["apple","pen"]
// Output: true
// Explanation: Return true because "applepenapple" can be segmented as "apple pen apple".
// Note that you are allowed to reuse a dictionary word.

// Example 3:
// Input: s = "catsandog", wordDict = ["cats","dog","sand","and","cat"]
// Output: false

import java.util.List;
import java.util.Set;
import java.util.HashSet;
import java.util.Arrays;

class WordBreak {
    public boolean wordBreak(String s, List<String> wordDict) {
        
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        Set<String> wordSet = new HashSet<>(wordDict);

        for(int i=1; i<=s.length(); i++) {
            for(int j=i-1; j>=0; j--) {
                if(dp[j] && wordSet.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }

        return dp[s.length()];
    }

    public static void main(String[] args) {

        WordBreak wb = new WordBreak();

        String s = "leetcode";
        List<String> wordDict = Arrays.asList("leet", "code");

        boolean result = wb.wordBreak(s, wordDict);

        System.out.println("Input String: " + s);
        System.out.println("Dictionary: " + wordDict);
        System.out.println("Can be segmented? " + result);
    }
}

