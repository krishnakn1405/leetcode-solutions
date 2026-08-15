// Median of Two Sorted Arrays

// Given two sorted arrays nums1 and nums2 of size m and n respectively, return the median of the two sorted arrays.

// The overall run time complexity should be O(log (m+n)).

// Example 1:
// Input: nums1 = [1,3], nums2 = [2]
// Output: 2.00000
// Explanation: merged array = [1,2,3] and median is 2.

// Example 2:
// Input: nums1 = [1,2], nums2 = [3,4]
// Output: 2.50000
// Explanation: merged array = [1,2,3,4] and median is (2 + 3) / 2 = 2.5.

class MedianOfTwoSortedArrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        
        if(nums1.length > nums2.length) {
            return findMedianSortedArrays(nums2, nums1);
        }

        int x = nums1.length;
        int y = nums2.length;

        int start = 0;
        int end = x;

        while(start <= end) {
            int partX = (start+end)/2;
            int partY = (x+y+1)/2 - partX;
            
            int xLeft = partX == 0 ? Integer.MIN_VALUE : nums1[partX - 1];
            int xRight = partX == x ? Integer.MAX_VALUE : nums1[partX];
            int yLeft = partY == 0 ? Integer.MIN_VALUE : nums2[partY - 1];
            int yRight = partY == y ? Integer.MAX_VALUE : nums2[partY];

            if(xLeft <= yRight && yLeft <= xRight) {
                if((x+y)%2 == 0) {
                    return ((double) Math.max(xLeft, yLeft) + Math.min(xRight, yRight)) / 2;
                } else {
                    return Math.max(xLeft, yLeft);
                }
            } else if(xLeft > yRight) {
                end = partX - 1;
            } else {
                start = partX + 1;
            }
        }

        return 0;
    }

    public static void main(String[] args) {

        int[] nums1 = {1, 2};
        int[] nums2 = {3, 4};

        MedianOfTwoSortedArrays solution = new MedianOfTwoSortedArrays();

        double result = solution.findMedianSortedArrays(nums1, nums2);

        System.out.println("nums1 = " + java.util.Arrays.toString(nums1));
        System.out.println("nums2 = " + java.util.Arrays.toString(nums2));
        System.out.println("Median = " + result);
    }
}
