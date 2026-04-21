// Word Ladder

// A transformation sequence from word beginWord to word endWord using a dictionary wordList is a sequence of words beginWord -> s1 -> s2 -> ... -> sk such that:

// Every adjacent pair of words differs by a single letter.
// Every si for 1 <= i <= k is in wordList. Note that beginWord does not need to be in wordList.
// sk == endWord
// Given two words, beginWord and endWord, and a dictionary wordList, return the number of words in the shortest transformation sequence from beginWord to endWord, or 0 if no such sequence exists.

// Example 1:
// Input: beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","log","cog"]
// Output: 5
// Explanation: One shortest transformation sequence is "hit" -> "hot" -> "dot" -> "dog" -> cog", which is 5 words long.

// Example 2:
// Input: beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","log"]
// Output: 0
// Explanation: The endWord "cog" is not in wordList, therefore there is no valid transformation sequence.

import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;
import java.util.Arrays;

class Pair<K, V> {
    private K key;
    private V value;

    public Pair(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public K getKey() {
        return key;
    }

    public V getValue() {
        return value;
    }
}

class WordLadder {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        
        // Since all words are of same length
        int L = beginWord.length();

        // Dictionary to hold combination of words that can be formed
        // from any given word. By changing one letter at a time
        Map<String, List<String>> allComboDict = new HashMap<>();

        wordList.forEach(word -> {
            for(int i=0; i<L; i++) {
                // Key is  the generic word
                // Value is a list of words which have the same intermediate generic word.
                String newWord = word.substring(0, i) + '*' + word.substring(i+1, L);
                List<String> transformations = allComboDict.getOrDefault(newWord, new ArrayList<>());
                transformations.add(word);
                allComboDict.put(newWord, transformations);
            }
        });

        // Queue for BFS
        Queue<Pair<String, Integer>> Q = new LinkedList<>();
        Q.add(new Pair(beginWord, 1));

        // Visisted to make sure we don't repeat processing the same word.
        Map<String, Boolean> visited = new HashMap<>();
        visited.put(beginWord, true);

        while(!Q.isEmpty()) {
            Pair<String, Integer> node = Q.remove();
            String word = node.getKey();
            int level = node.getValue();
            for(int i=0; i<L; i++) {

                // Intermediate words for current word
                String newWord = word.substring(0, i) + '*' + word.substring(i+1, L);

                // Next states are all the words which share the same intermediate state
                for(String adjacentWord: allComboDict.getOrDefault(newWord, new ArrayList<>())) {
                    // If at any point if we find what we are looking for
                    // i.e. the end word - we can return with the answer
                    if(adjacentWord.equals(endWord)) {
                        return level + 1;
                    }

                    // Otherwise, add it to the BFS Queue, Also mark it visited
                    if(!visited.containsKey(adjacentWord)) {
                        visited.put(adjacentWord, true);
                        Q.add(new Pair(adjacentWord, level + 1));
                    }
                }
            }
        }

        return 0;
    }

    public static void main(String[] args) {
        
        WordLadder obj = new WordLadder();

        String beginWord = "hit";
        String endWord = "cog";

        // Input as array
        String[] wordArray = {"hot","dot","dog","lot","log","cog"};

        // Convert array to List
        List<String> wordList = Arrays.asList(wordArray);

        int result = obj.ladderLength(beginWord, endWord, wordList);

        System.out.println("Output: " + result);
    }
}




