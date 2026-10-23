// Kth Smallest Element in a BST

// Given the root of a binary search tree, and an integer k, return the kth smallest value (1-indexed) of all the values of the nodes in the tree.

// Example 1:
// Input: root = [3,1,4,null,2], k = 1
// Output: 1

// Example 2:
// Input: root = [5,3,6,2,4,null,null,1], k = 3
// Output: 3

import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;

class TreeNode {
    int val;
    TreeNode left, right;

    TreeNode(int val) {
        this.val = val;
    }
}

class KthSmallestElementInABST {

    public ArrayList<Integer> inOrder(TreeNode root, ArrayList<Integer> arr) {

        if(root == null) {
            return arr;
        }

        inOrder(root.left, arr);
        arr.add(root.val);
        inOrder(root.right, arr);
        return arr;
    }

    public int kthSmallest(TreeNode root, int k) {
        ArrayList<Integer> nums = inOrder(root, new ArrayList<Integer>());
        return nums.get(k-1);
    }

    // Build tree from level-order array
    public static TreeNode buildTree(Integer[] arr) {
        if (arr.length == 0 || arr[0] == null) {
            return null;
        }

        TreeNode root = new TreeNode(arr[0]);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        int i = 1;

        while (!queue.isEmpty() && i < arr.length) {
            TreeNode current = queue.poll();

            // Left child
            if (i < arr.length && arr[i] != null) {
                current.left = new TreeNode(arr[i]);
                queue.add(current.left);
            }
            i++;

            // Right child
            if (i < arr.length && arr[i] != null) {
                current.right = new TreeNode(arr[i]);
                queue.add(current.right);
            }
            i++;
        }

        return root;
    }

    public static void main(String[] args) {
        Integer[] arr = {5, 3, 6, 2, 4, null, null, 1};
        int k = 3;

        TreeNode root = buildTree(arr);

        KthSmallestElementInABST obj =
                new KthSmallestElementInABST();

        System.out.println("Kth smallest element: "
                + obj.kthSmallest(root, k));
    }

}

