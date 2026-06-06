// Letter Combinations of a Phone Number

// Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent. Return the answer in any order.

// A mapping of digits to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.

// Example 1:
// Input: digits = "23"
// Output: ["ad","ae","af","bd","be","bf","cd","ce","cf"]

// Example 2:
// Input: digits = "2"
// Output: ["a","b","c"]

import java.util.ArrayList;
import java.util.List;

class LetterCombinationsOfAPhoneNumber {

    // Mapping of digits to letters
    private String[] digitsToLetters = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    
    public List<String> letterCombinations(String digits) {
        
        List<String> combinations = new ArrayList<>();
        if(digits == null || digits.length() == 0) {
            return combinations;
        }
        backtrack(combinations, digits, "", 0);
        return combinations;
    }

    private void backtrack(List<String> combinations, String digits, String currentCombination, int index) {
        if(index == digits.length()) {
            combinations.add(currentCombination);
            return;
        }

        String letters = digitsToLetters[digits.charAt(index) - '0'];
        for(char letter: letters.toCharArray()) {
            backtrack(combinations, digits, currentCombination + letter, index + 1);
        }
    }

    public static void main(String[] args) {

        LetterCombinationsOfAPhoneNumber solution =
                new LetterCombinationsOfAPhoneNumber();

        String digits = "23";

        List<String> result = solution.letterCombinations(digits);

        System.out.println("Input: " + digits);
        System.out.println("Output: " + result);
    }

}
