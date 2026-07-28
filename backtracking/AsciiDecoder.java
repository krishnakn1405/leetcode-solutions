// Ascii Decoder

// Problem: You are given a string s consisting only of digits. The string represents a sequence of encoded ASCII values without any separators.

// The encoding rules are:
// ASCII values from 65 to 90 represent uppercase English letters (A-Z).
// ASCII values from 97 to 122 represent lowercase English letters (a-z).

// Your task is to split the digit string into valid ASCII values and return the decoded string.

// If multiple decodings are possible, return any valid decoding.

// If no valid decoding exists, return an empty string.

public class AsciiDecoder {

    static boolean decode(String s, int index, StringBuilder ans) {

        if (index == s.length()) {
            return true;
        }

        // Try 2-digit ASCII
        if (index + 2 <= s.length()) {

            int num = Integer.parseInt(s.substring(index, index + 2));

            if ((num >= 65 && num <= 90) || (num >= 97 && num <= 99)) {

                ans.append((char) num);

                if (decode(s, index + 2, ans))
                    return true;

                ans.deleteCharAt(ans.length() - 1);
            }
        }

        // Try 3-digit ASCII
        if (index + 3 <= s.length()) {

            int num = Integer.parseInt(s.substring(index, index + 3));

            if (num >= 100 && num <= 122) {

                ans.append((char) num);

                if (decode(s, index + 3, ans))
                    return true;

                ans.deleteCharAt(ans.length() - 1);
            }
        }

        return false;
    }

    public static void main(String[] args) {

        String input = "7297991071011148297110107";

        StringBuilder ans = new StringBuilder();

        if (decode(input, 0, ans))
            System.out.println(ans);
        else
            System.out.println("Invalid Input");
    }
}

