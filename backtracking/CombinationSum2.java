// Combination Sum II

// Given a collection of candidate numbers (candidates) and a target number (target), find all unique combinations in candidates where the candidate numbers sum to target.

// Each number in candidates may only be used once in the combination.

// Note: The solution set must not contain duplicate combinations.

// Example 1:
// Input: candidates = [10,1,2,7,6,1,5], target = 8
// Output: 
// [
// [1,1,6],
// [1,2,5],
// [1,7],
// [2,6]
// ]

// Example 2:
// Input: candidates = [2,5,2,1,2], target = 5
// Output: 
// [
// [1,2,2],
// [5]
// ]

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class CombinationSum2 {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates); // Sort the array to handle duplicates
        backtrack(result, new ArrayList<>(), candidates, target, 0);
        return result;
    }

    private void backtrack(List<List<Integer>> result, List<Integer> current, int[] candidates, int target, int start) {

        if(target == 0) {
            result.add(new ArrayList<>(current));
            return;
        }

        for(int i=start; i<candidates.length; i++) {
            
            // Skip dupliactes
            if(i>start && candidates[i] == candidates[i-1]) {
                continue;
            }

            // Early termination if the remaining sum becomes negative
            if(target - candidates[i] < 0) {
                break;
            }
            current.add(candidates[i]);
            backtrack(result, current, candidates, target - candidates[i], i+1);
            current.remove(current.size() - 1);
        }
    }

    public static void main(String[] args) {

        int[] candidates = {10, 1, 2, 7, 6, 1, 5};
        int target = 8;

        CombinationSum2 solution = new CombinationSum2();

        List<List<Integer>> result =
                solution.combinationSum2(candidates, target);

        System.out.println("Result:");
        for (List<Integer> combination : result) {
            System.out.println(combination);
        }
    }

}


