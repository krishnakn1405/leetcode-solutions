// Minimum Window Substring

// Given two strings s and t of lengths m and n respectively, return the minimum window substring of s such that every character in t (including duplicates) is included in the window. If there is no such substring, return the empty string "".

// The testcases will be generated such that the answer is unique.

// Example 1:
// Input: s = "ADOBECODEBANC", t = "ABC"
// Output: "BANC"
// Explanation: The minimum window substring "BANC" includes 'A', 'B', and 'C' from string t.

// Example 2:
// Input: s = "a", t = "a"
// Output: "a"
// Explanation: The entire string s is the minimum window.

// Example 3:
// Input: s = "a", t = "aa"
// Output: ""
// Explanation: Both 'a's from t must be included in the window. Since the largest window of s only has one 'a', return empty string.

import java.util.HashMap;
import java.util.Map;

class MinimumWindowSubstring {
    public String minWindow(String s, String t) {
        
        if(s.length() == 0 || t.length() == 0 || s.length() < t.length()) {
            return "";
        }

        Map<Character, Integer> mapT = new HashMap<>();

        for(int i=0; i<t.length(); i++) {
            mapT.put(t.charAt(i), mapT.getOrDefault(t.charAt(i), 0) + 1);
        }

        int required = mapT.size();
        int l = 0, r = 0;
        int create = 0;
        int[] ans = {-1, 0, 0};
        Map<Character, Integer> subStringMap = new HashMap<>();

        while(r<s.length()) {
            char c = s.charAt(r);
            int count = subStringMap.getOrDefault(c,0);
            subStringMap.put(c, count+1);

            if(mapT.containsKey(c) && subStringMap.get(c).intValue() == mapT.get(c).intValue()) {
                create++;
            }

            while(l<=r && required == create) {
                c = s.charAt(l);
                if(ans[0] == -1 || ans[0] >= r-l+1) {
                    ans[0] = r - l + 1;
                    ans[1] = l;
                    ans[2] = r;
                }

                subStringMap.put(c, subStringMap.get(c) - 1);
                if(mapT.containsKey(c) && subStringMap.get(c).intValue() < mapT.get(c).intValue()) {
                    create--;
                }
                l++;
            }
            r++;
        }

        if(ans[0] == -1) {
            return "";
        }

        return s.substring(ans[1], ans[2]+1);
    }

    public static void main(String[] args) {

        String s = "ADOBECODEBANC";
        String t = "ABC";

        MinimumWindowSubstring obj = new MinimumWindowSubstring();

        String result = obj.minWindow(s, t);

        System.out.println("Input:");
        System.out.println("s = " + s);
        System.out.println("t = " + t);

        System.out.println("\nOutput:");
        System.out.println(result);
    }

}


