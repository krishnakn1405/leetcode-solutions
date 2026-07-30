// Longest Palindromic Substring

// Given a string s, return the longest palindromic substring in s.

// Example 1:
// Input: s = "babad"
// Output: "bab"
// Explanation: "aba" is also a valid answer.

// Example 2:
// Input: s = "cbbd"
// Output: "bb"

class LongestPalindromicSubstring {
    public String longestPalindrome(String s) {
        
        if(s == null || s.length() < 1) {
            return "";
        }

        int left = 0, right = 0;
        for(int i=0; i<s.length(); i++) {
            int len1 = checkPalindrome(s, i, i);
            int len2 = checkPalindrome(s, i, i+1);
            int len = Math.max(len1, len2);
            if(len > right - left) {
                left = i-(len-1)/2;
                right = i + len/2;
            }
        }

        return s.substring(left, right+1);

    }

    public int checkPalindrome(String s, int left, int right) {

        int L = left, R = right;

        while(L>=0 && R<s.length() && s.charAt(L) == s.charAt(R)) {
            L--;
            R++;
        }

        return R-L-1;
    }


    public static void main(String[] args) {

        LongestPalindromicSubstring obj = new LongestPalindromicSubstring();

        String s = "babad";

        System.out.println("Input: " + s);
        System.out.println("Output: " + obj.longestPalindrome(s));
    }

}
