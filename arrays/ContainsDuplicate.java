// Contains Duplicate

// Given an integer array nums, return true if any value appears at least twice in the array, and return false if every element is distinct.

// Example 1:
// Input: nums = [1,2,3,1]
// Output: true
// Explanation: The element 1 occurs at the indices 0 and 3.

// Example 2:
// Input: nums = [1,2,3,4]
// Output: false
// Explanation: All elements are distinct.

// Example 3:
// Input: nums = [1,1,1,3,3,4,3,2,4,2]
// Output: true

import java.util.HashSet;

class ContainsDuplicate {
    public boolean containsDuplicate(int[] nums) {
        
        // Create a HashSet to store elements from the array
        HashSet<Integer> seenNumbers = new HashSet<>();

        // Iterate through each element in the array
        for(int num: nums) {

            // Check if the element is alraedy in the HashSet
            if(seenNumbers.contains(num)) {
                return true; // Duplicate found
            }

            // Add the element to the HashSet
            seenNumbers.add(num);
        }

        return false; // No duplicates found

    }

    public static void main(String[] args) {

        // Input: nums = [1,2,3,1]
        int[] nums = {1, 2, 3, 1};

        ContainsDuplicate obj = new ContainsDuplicate();

        boolean result = obj.containsDuplicate(nums);

        System.out.println("Input: nums = [1,2,3,1]");
        System.out.println("Output: " + result);
    }
}



