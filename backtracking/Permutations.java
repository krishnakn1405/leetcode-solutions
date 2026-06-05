// Permutations

// Given an array nums of distinct integers, return all the possible permutations. You can return the answer in any order.

// Example 1:
// Input: nums = [1,2,3]
// Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]

// Example 2:
// Input: nums = [0,1]
// Output: [[0,1],[1,0]]

// Example 3:
// Input: nums = [1]
// Output: [[1]]

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

class Permutations {
    public List<List<Integer>> permute(int[] nums) {
        
        List<List<Integer>> result = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        backtrack(result, new ArrayList<>(), nums, used);
        return result;
    }

    private void backtrack(List<List<Integer>> result, List<Integer> current, int[] nums, boolean[] used) {
        if(current.size() == nums.length) {
            result.add(new ArrayList<>(current));
            return;
        }

        for(int i=0; i<nums.length; i++) {
            if(!used[i]) {
                current.add(nums[i]);
                used[i] = true;
                backtrack(result, current, nums, used);
                used[i] = false;
                current.remove(current.size() - 1);
            }
        }
    }


    public static void main(String[] args) {

        int[] nums = {1, 2, 3};

        Permutations obj = new Permutations();
        List<List<Integer>> result = obj.permute(nums);

        System.out.println("Input: " + Arrays.toString(nums));
        System.out.println("Output:");

        for (List<Integer> permutation : result) {
            System.out.println(permutation);
        }
    }
}



