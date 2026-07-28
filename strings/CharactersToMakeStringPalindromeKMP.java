// Characters to Make String Palindrome

// Given a string, find the minimum number of characters to add at the beginning (or sometimes at the end, depending on the interviewer) to make it a palindrome.

// Example
// Input: abcd
// Output: 3

// Java Solution: The O(n) solution uses the KMP (Knuth-Morris-Pratt) algorithm

public class CharactersToMakeStringPalindromeKMP {

    static int[] computeLPS(String pattern) {

        int[] lps = new int[pattern.length()];

        int len = 0;
        int i = 1;

        while (i < pattern.length()) {

            if (pattern.charAt(i) == pattern.charAt(len)) {
                len++;
                lps[i] = len;
                i++;
            } else {

                if (len != 0) {
                    len = lps[len - 1];
                } else {
                    lps[i] = 0;
                    i++;
                }
            }
        }

        return lps;
    }

    static int minCharsToAdd(String s) {

        String rev = new StringBuilder(s).reverse().toString();

        String temp = s + "$" + rev;

        int[] lps = computeLPS(temp);

        return s.length() - lps[lps.length - 1];
    }

    public static void main(String[] args) {

        String s = "AACECAAAA";

        System.out.println(minCharsToAdd(s));
    }

}
