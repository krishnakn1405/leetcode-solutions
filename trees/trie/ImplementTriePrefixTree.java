// Implement Trie (Prefix Tree)

// A trie (pronounced as "try") or prefix tree is a tree data structure used to efficiently store and retrieve keys in a dataset of strings. There are various applications of this data structure, such as autocomplete and spellchecker.

// Implement the Trie class:
// Trie() Initializes the trie object.
// void insert(String word) Inserts the string word into the trie.
// boolean search(String word) Returns true if the string word is in the trie (i.e., was inserted before), and false otherwise.
// boolean startsWith(String prefix) Returns true if there is a previously inserted string word that has the prefix prefix, and false otherwise.

// Example 1:
// Input
// ["Trie", "insert", "search", "search", "startsWith", "insert", "search"]
// [[], ["apple"], ["apple"], ["app"], ["app"], ["app"], ["app"]]
// Output: [null, null, true, false, true, null, true]

// Explanation
// Trie trie = new Trie();
// trie.insert("apple");
// trie.search("apple");   // return True
// trie.search("app");     // return False
// trie.startsWith("app"); // return True
// trie.insert("app");
// trie.search("app");     // return True

import java.util.ArrayList;
import java.util.List;

class TrieNode {

    // R links to node children
    private TrieNode[] links;

    private final int R = 26;
    private boolean isEnd;

    public TrieNode() {
        links = new TrieNode[R];
    }

    public boolean containsKey(char ch) {
        return links[ch - 'a'] != null;
    }

    public TrieNode get(char ch) {
        return links[ch - 'a'];
    }

    public void put(char ch, TrieNode node) {
        links[ch - 'a'] = node;
    }

    public void setEnd() {
        isEnd = true;
    }

    public boolean isEnd() {
        return isEnd;
    }
}

class ImplementTriePrefixTree {

    private TrieNode root;

    public ImplementTriePrefixTree() {
        root = new TrieNode();
    }
    
    public void insert(String word) {

        TrieNode node = root;
        for(int i=0; i<word.length(); i++) {
            char currentChar = word.charAt(i);
            if(!node.containsKey(currentChar)) {
                node.put(currentChar, new TrieNode());
            }
            node = node.get(currentChar);
        }
        node.setEnd();
    }

    public TrieNode searchPrefix(String word) {
        TrieNode node = root;
        for(int i=0; i<word.length(); i++) {
            char currentChar = word.charAt(i);
            if(node.containsKey(currentChar)) {
                node = node.get(currentChar);
            } else {
                return null;
            }
        }
        return node;
    }
    

    public boolean search(String word) {
        TrieNode node = searchPrefix(word);
        return node != null && node.isEnd();
    }
    
    public boolean startsWith(String prefix) {
        TrieNode node = searchPrefix(prefix);
        return node != null;
    }

    public static void main(String[] args) {

        String[] operations = {
            "Trie", "insert", "search", "search",
            "startsWith", "insert", "search"
        };

        String[][] arguments = {
            {}, {"apple"}, {"apple"}, {"app"},
            {"app"}, {"app"}, {"app"}
        };

        ImplementTriePrefixTree trie = null;
        List<Object> output = new ArrayList<>();

        for (int i = 0; i < operations.length; i++) {
            switch (operations[i]) {
                case "Trie":
                    trie = new ImplementTriePrefixTree();
                    output.add(null);
                    break;

                case "insert":
                    trie.insert(arguments[i][0]);
                    output.add(null);
                    break;

                case "search":
                    output.add(trie.search(arguments[i][0]));
                    break;

                case "startsWith":
                    output.add(trie.startsWith(arguments[i][0]));
                    break;
            }
        }

        System.out.println(output);
    }

}

