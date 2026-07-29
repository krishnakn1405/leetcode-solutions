// Palindromic Substrings

// Given a string s, return the number of palindromic substrings in it.

// A string is a palindrome when it reads the same backward as forward.

// A substring is a contiguous sequence of characters within the string.

// Example 1:
// Input: s = "abc"
// Output: 3
// Explanation: Three palindromic strings: "a", "b", "c".

// Example 2:
// Input: s = "aaa"
// Output: 6
// Explanation: Six palindromic strings: "a", "a", "a", "aa", "aa", "aaa".


class PalindromicSubstrings {
    public int countSubstrings(String s) {
        
        int ans = 0;

        for(int i=0; i<s.length(); i++) {
            ans += checkPalindrome(s, i, i);
            ans += checkPalindrome(s, i, i+1);
        }

        return ans;
    }

    public int checkPalindrome(String s, int left, int right) {
        int count = 0;

        while(left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
            count++;
        }

        return count;
    }

    public static void main(String[] args) {
        String s = "abc";

        PalindromicSubstrings obj = new PalindromicSubstrings();
        int result = obj.countSubstrings(s);

        System.out.println("Input: s = \"" + s + "\"");
        System.out.println("Output: " + result);
    }

}
