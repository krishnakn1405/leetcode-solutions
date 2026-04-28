// Alien Dictionary

// There is a foreign language which uses the latin alphabet, but the order among letters is not "a", "b", "c" ... "z" as in English.

// You receive a list of non-empty strings words from the dictionary, where the words are sorted lexicographically based on the rules of this new language.

// Derive the order of letters in this language. If the order is invalid, return an empty string. If there are multiple valid order of letters, return any of them.

// A string a is lexicographically smaller than a string b if either of the following is true:

// The first letter where they differ is smaller in a than in b.
// a is a prefix of b and a.length < b.length.

// Example 1:
// Input: ["z","o"]
// Output: "zo"
// Explanation: From "z" and "o", we know 'z' < 'o', so return "zo".

// Example 2:
// Input: ["hrn","hrf","er","enn","rfnn"]
// Output: "hernf"
// Explanation:
// from "hrn" and "hrf", we know 'n' < 'f'
// from "hrf" and "er", we know 'h' < 'e'
// from "er" and "enn", we know 'r' < 'n'
// from "enn" and "rfnn" we know 'e' < 'r'
// so one possible solution is "hernf"

import java.util.Map;
import java.util.List;
import java.util.HashMap;
import java.util.ArrayList;

class AlienDictionary {

    public Map<Character, List<Character>> reversedList = new HashMap<>();
    public Map<Character, Boolean> seen = new HashMap<>();
    public StringBuilder result = new StringBuilder();

    public String alignOrder(String[] words) {

        for(String word: words) {
            for(char c:word.toCharArray()) {
                reversedList.putIfAbsent(c, new ArrayList<>());
            }
        }

        for(int i=0; i<words.length-1; i++) {
            String word1 = words[i];
            String word2 = words[i+1];

            if(word1.length() > word2.length() && word1.startsWith(word2)) {
                return "";
            }

            for(int j=0; j<Math.min(word1.length(), word2.length()); j++) {
                if(word1.charAt(j) != word2.charAt(j)) {
                    reversedList.get(word2.charAt(j)).add(word1.charAt(j));
                    break;
                }
            }
        }

        for(Character c: reversedList.keySet()) {
            boolean res= dfs(c);
            if(!res) return "";
        }

        if(result.length() < reversedList.size()) {
            return "";
        }

        return result.toString();
    }

    public boolean dfs(Character c) {
        if(seen.containsKey(c)) {
            return seen.get(c);
        }

        seen.put(c, false);

        for(Character next: reversedList.get(c)) {
            boolean res = dfs(next);
            if(!res) return false;
        }

        seen.put(c, true);
        result.append(c);
        return true;
    }

    public static void main(String[] args) {
        AlienDictionary obj = new AlienDictionary();
        String[] words = {"hrn","hrf","er","enn","rfnn"};
        String result = obj.alignOrder(words);
        System.out.println("Output: " + result);
    }


}


