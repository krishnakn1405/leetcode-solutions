// Palindrome Partitioning

// Given a string s, partition s such that every substring of the partition is a palindrome. Return all possible palindrome partitioning of s.

// Example 1:
// Input: s = "aab"
// Output: [["a","a","b"],["aa","b"]]

// Example 2:
// Input: s = "a"
// Output: [["a"]]

import java.util.List;
import java.util.ArrayList;

class PalindromePartitioning {
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        backtrack(result, new ArrayList<>(), s, 0);
        return result;
    }

    private void backtrack(List<List<String>> result, List<String> current, String s, int start) {

        if(start == s.length()) {
            result.add(new ArrayList<>(current));
            return;
        }

        for(int end=start; end<s.length(); end++) {
            if(isPalindrome(s, start, end)) {
                current.add(s.substring(start, end+1));
                backtrack(result, current, s, end + 1);
                current.remove(current.size() - 1);
            }
        }
    }

    private boolean isPalindrome(String s, int start, int end) {
        while(start<end) {
            if(s.charAt(start++) != s.charAt(end--)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "aab";

        PalindromePartitioning pp = new PalindromePartitioning();
        List<List<String>> result = pp.partition(s);

        System.out.println("Input: " + s);
        System.out.println("Output: " + result);
    }
}


