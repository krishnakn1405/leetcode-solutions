// Design Add and Search Words Data Structure

// Design a data structure that supports adding new words and finding if a string matches any previously added string.

// Implement the WordDictionary class:

// WordDictionary() Initializes the object.
// void addWord(word) Adds word to the data structure, it can be matched later.
// bool search(word) Returns true if there is any string in the data structure that matches word or false otherwise. word may contain dots '.' where dots can be matched with any letter.
 

// Example:
// Input
// ["WordDictionary","addWord","addWord","addWord","search","search","search","search"]
// [[],["bad"],["dad"],["mad"],["pad"],["bad"],[".ad"],["b.."]]
// Output: [null,null,null,null,false,true,true,true]

// Explanation
// WordDictionary wordDictionary = new WordDictionary();
// wordDictionary.addWord("bad");
// wordDictionary.addWord("dad");
// wordDictionary.addWord("mad");
// wordDictionary.search("pad"); // return False
// wordDictionary.search("bad"); // return True
// wordDictionary.search(".ad"); // return True
// wordDictionary.search("b.."); // return True

import java.util.Map;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.List;

class TrieNode {
    Map<Character, TrieNode> children = new HashMap();
    boolean word = false;
    public TrieNode() {}
}

class DesignAddAndSearchWordsDataStructure {

    TrieNode trie;

    public DesignAddAndSearchWordsDataStructure() {
        trie = new TrieNode();    
    }
    
    public void addWord(String word) {
        TrieNode node = trie;
        for(char ch: word.toCharArray()) {
            if(!node.children.containsKey(ch)) {
                node.children.put(ch, new TrieNode());
            }
            node = node.children.get(ch);
        }
        node.word = true;
    }

    public boolean searchInNode(String word, TrieNode node) {
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);

            if (ch == '.') {
                for (char x : node.children.keySet()) {
                    TrieNode child = node.children.get(x);
                    if (searchInNode(word.substring(i + 1), child)) {
                        return true;
                    }
                }
                return false;
            }

            if (!node.children.containsKey(ch)) {
                return false;
            } else {
                node = node.children.get(ch);
            }
        }

        return node.word;
    }

    public boolean search(String word) {
        return searchInNode(word, trie);
    }

    public static void main(String[] args) {

        String[] operations = {
            "WordDictionary", "addWord", "addWord", "addWord",
            "search", "search", "search", "search"
        };

        String[][] arguments = {
            {}, {"bad"}, {"dad"}, {"mad"},
            {"pad"}, {"bad"}, {".ad"}, {"b.."}
        };

        DesignAddAndSearchWordsDataStructure obj = null;

        List<Object> output = new ArrayList<>();

        for (int i = 0; i < operations.length; i++) {

            switch (operations[i]) {

                case "WordDictionary":
                    obj = new DesignAddAndSearchWordsDataStructure();
                    output.add(null);
                    break;

                case "addWord":
                    obj.addWord(arguments[i][0]);
                    output.add(null);
                    break;

                case "search":
                    output.add(obj.search(arguments[i][0]));
                    break;
            }
        }

        System.out.println(output);
    }

}

