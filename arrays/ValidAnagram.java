// Valid Anagram

// Given two strings s and t, return true if t is an anagram of s, and false otherwise.

// Example 1:
// Input: s = "anagram", t = "nagaram"
// Output: true

// Example 2:
// Input: s = "rat", t = "car"
// Output: false

class ValidAnagram {
    public boolean isAnagram(String s, String t) {
        
        // If the lengths are different, they can't be anagrams
        if(s.length() != t.length()) {
            return false;
        }

        // Create an array to count character frequencies
        int[] charCounts = new int[26]; // assuming only lowercase English letters

        // Increment count for each charcter in 's' and decrement for each in 't'
        for(int i=0; i<s.length(); i++) {
            charCounts[s.charAt(i) - 'a']++;
            charCounts[t.charAt(i) - 'a']--;
        }

        // Check if all counts are zero
        for(int count: charCounts) {
            if(count != 0) {
                return false;
            }
        }

        return true; // All counts are zero, so 't' is an anagram of 's'
    }

    public static void main(String[] args) {

        String s = "anagram";
        String t = "nagaram";

        ValidAnagram obj = new ValidAnagram();

        boolean result = obj.isAnagram(s, t);

        System.out.println("Input:");
        System.out.println("s = \"" + s + "\"");
        System.out.println("t = \"" + t + "\"");

        System.out.println("\nOutput:");
        System.out.println(result);
    }

}


