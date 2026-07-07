// Group Anagrams

// Given an array of strings strs, group the anagrams together. You can return the answer in any order.

// Example 1:
// Input: strs = ["eat","tea","tan","ate","nat","bat"]
// Output: [["bat"],["nat","tan"],["ate","eat","tea"]]

// Explanation:
// There is no string in strs that can be rearranged to form "bat".
// The strings "nat" and "tan" are anagrams as they can be rearranged to form each other.
// The strings "ate", "eat", and "tea" are anagrams as they can be rearranged to form each other.

// Example 2:
// Input: strs = [""]
// Output: [[""]]

// Example 3:
// Input: strs = ["a"]
// Output: [["a"]]

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        
        if(strs.length == 0) {
            return new ArrayList<>();
        }

        Map<String, List> ansMap = new HashMap<>();

        int[] count = new int[26];

        for(String s:strs) {
            Arrays.fill(count, 0);
            for(char c:s.toCharArray()) {
                count[c-'a']++;
            }

            StringBuilder sb = new StringBuilder("");

            for(int i=0; i<26; i++) {
                sb.append("#");
                sb.append(count[i]);
            }
            String key = sb.toString();
            if(!ansMap.containsKey(key)) {
                ansMap.put(key, new ArrayList());
            }
            ansMap.get(key).add(s);
        }

        return new ArrayList(ansMap.values());
    }


    public static void main(String[] args) {

        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};

        GroupAnagrams obj = new GroupAnagrams();

        List<List<String>> result = obj.groupAnagrams(strs);

        System.out.println("Input:");
        System.out.println(Arrays.toString(strs));

        System.out.println("\nOutput:");
        System.out.println(result);
    }
}



