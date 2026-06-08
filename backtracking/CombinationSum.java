// Combination Sum

// Given an array of distinct integers candidates and a target integer target, return a list of all unique combinations of candidates where the chosen numbers sum to target. You may return the combinations in any order.

// The same number may be chosen from candidates an unlimited number of times. Two combinations are unique if the frequency of at least one of the chosen numbers is different.

// The test cases are generated such that the number of unique combinations that sum up to target is less than 150 combinations for the given input.

// Example 1:
// Input: candidates = [2,3,6,7], target = 7
// Output: [[2,2,3],[7]]
// Explanation:
// 2 and 3 are candidates, and 2 + 2 + 3 = 7. Note that 2 can be used multiple times.
// 7 is a candidate, and 7 = 7.
// These are the only two combinations.

// Example 2:
// Input: candidates = [2,3,5], target = 8
// Output: [[2,2,2,2],[2,3,3],[3,5]]

// Example 3:
// Input: candidates = [2], target = 1
// Output: []

import java.util.ArrayList;
import java.util.List;

class CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        List<Integer> combination = new ArrayList<>();

        backTrack(target, res, combination, 0, candidates);
        return res;
    }

    public void backTrack(int target, List<List<Integer>> res, List<Integer> combination, int start, int[] candidates) {

        if(target == 0) {
            res.add(new ArrayList<Integer>(combination));
        } else if (target < 0) {
            return;
        }

        for(int i=start; i<candidates.length; i++) {
            combination.add(candidates[i]);
            backTrack(target-candidates[i], res, combination, i, candidates);
            combination.remove(combination.size() - 1);
        }
    }

    public static void main(String[] args) {

        int[] candidates = {2, 3, 5};
        int target = 8;

        CombinationSum obj = new CombinationSum();

        List<List<Integer>> result =
                obj.combinationSum(candidates, target);

        System.out.println("Output:");
        System.out.println(result);
    }

}


