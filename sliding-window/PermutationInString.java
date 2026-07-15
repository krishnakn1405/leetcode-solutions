// Permutation in String

// Given two strings s1 and s2, return true if s2 contains a permutation of s1, or false otherwise.

// In other words, return true if one of s1's permutations is the substring of s2.

// Example 1:
// Input: s1 = "ab", s2 = "eidbaooo"
// Output: true
// Explanation: s2 contains one permutation of s1 ("ba").

// Example 2:
// Input: s1 = "ab", s2 = "eidboaoo"
// Output: false

class PermutationInString {
    public boolean checkInclusion(String s1, String s2) {
        
        if(s1.length() > s2.length()) {
            return false;
        }

        int[] s1Map = new int[26];
        int[] s2Map = new int[26];

        // Initialize frequency maps for s1 and the first window of s2
        for(int i=0; i<s1.length(); i++) {
            s1Map[s1.charAt(i) - 'a']++;
            s2Map[s2.charAt(i) - 'a']++;
        }

        // Slide the window through s2 and compare the maps
        for(int i=0; i<s2.length() - s1.length(); i++) {
            if(matches(s1Map, s2Map)) {
                return true;
            }
            s2Map[s2.charAt(i + s1.length()) - 'a']++; // Add bew character to the window
            s2Map[s2.charAt(i) - 'a']--; // Remove old character from the window
        }

        // Check the last window
        return matches(s1Map, s2Map);
    }

    // Helper function to compare two frequency maps
    private boolean matches(int[] s1Map, int[] s2Map) {
        for(int i=0; i<26; i++) {
            if(s1Map[i] != s2Map[i]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {

        String s1 = "ab";
        String s2 = "eidbaooo";

        PermutationInString obj = new PermutationInString();

        boolean result = obj.checkInclusion(s1, s2);

        System.out.println("Input:");
        System.out.println("s1 = \"" + s1 + "\"");
        System.out.println("s2 = \"" + s2 + "\"");

        System.out.println("\nOutput:");
        System.out.println(result);
    }
}

