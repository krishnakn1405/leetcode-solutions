// Subsets II

// Given an integer array nums that may contain duplicates, return all possible subsets (the power set).

// The solution set must not contain duplicate subsets. Return the solution in any order.

// Example 1:
// Input: nums = [1,2,2]
// Output: [[],[1],[1,2],[1,2,2],[2],[2,2]]

// Example 2:
// Input: nums = [0]
// Output: [[],[0]]

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Subsets2 {
    public List<List<Integer>> subsetsWithDup(int[] nums) {

        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums); // Sort the array to handle duplicates
        backtrack(result, new ArrayList<>(), nums, 0);
        return result;        
    }

    private void backtrack(List<List<Integer>> result, List<Integer> current, int[] nums, int start) {

        result.add(new ArrayList<>(current));

        for(int i=start; i<nums.length; i++) {
            // Skip duplicates
            if(i>start && nums[i] == nums[i-1]) {
                continue;
            }
            current.add(nums[i]);
            backtrack(result, current, nums, i+1);
            current.remove(current.size() - 1);
        }
    }

    public static void main(String[] args) {

        Subsets2 obj = new Subsets2();

        int[] nums = {1, 2, 2};

        List<List<Integer>> result = obj.subsetsWithDup(nums);

        System.out.println("Input: " + Arrays.toString(nums));
        System.out.println("Output:");

        for(List<Integer> subset : result) {
            System.out.println(subset);
        }
    }
}


