// Encode and Decode Strings

// Design an algorithm to encode a list of strings to a string. The encoded string is then sent over the network and is decoded back to the original list of strings.

// Machine 1 (sender) has the function:

// String encode(List<String> strs) {
    // ... your code
//    return encoded_string;
// }
// Machine 2 (receiver) has the function:

// List<String> decode(String encoded_string) {
    // ... your code
//    return decoded_strs;
// }
// So Machine 1 does:

// String encoded_string = encode(strs);
// and Machine 2 does:

// List<String> decoded_strs = decode(encoded_string);
// decoded_strs in Machine 2 should be the same as the input strs in Machine 1.

// Implement the encode and decode methods.

// Example 1:
// Input: strs = ["Hello","World"]
// Output: ["Hello","World"]
// Explanation: Solution solution = new Solution();, String encoded_string = solution.encode(strs);

// Machine 1 ---encoded_string---> Machine 2
// List<String> decoded_strs = solution.decode(encoded_string);

// Example 2:
// Input: strs = [""]
// Output: [""]

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

class EncodeAndDecodeStrings {

    // Encodes a list of strings to a single string
    public String encode(List<String> strs) {

        if(strs.size() == 0) {
            return Character.toString((char)258);
        }

        String seperate = Character.toString((char)257);
        StringBuilder sb = new StringBuilder();
        for(String s:strs) {
            sb.append(s);
            sb.append(seperate);
        }
        sb.deleteCharAt(sb.length()-1);
        return sb.toString();
    }

    // Decodes a single string to a list of strings
    public List<String> decode(String str) {

        if(str.equals(Character.toString((char)258))) {
            return new ArrayList();
        }

        String seperate = Character.toString((char)257);

        return Arrays.asList(str.split(seperate, -1));
    }

    public static void main(String[] args) {

        EncodeAndDecodeStrings obj = new EncodeAndDecodeStrings();

        List<String> strs = Arrays.asList("Hello", "World");

        // Encode
        String encoded = obj.encode(strs);
        System.out.println("Encoded String: " + encoded);

        // Decode
        List<String> decoded = obj.decode(encoded);
        System.out.println("Decoded List: " + decoded);
    }
}
