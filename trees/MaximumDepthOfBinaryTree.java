// Maximum Depth of Binary Tree

// Given the root of a binary tree, return its maximum depth.

// A binary tree's maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.

// Example 1:
// Input: root = [3,9,20,null,null,15,7]
// Output: 3

// Example 2:
// Input: root = [1,null,2]
// Output: 2

import java.util.Queue;
import java.util.LinkedList;

class TreeNode {
    int val;
    TreeNode left, right;

    TreeNode(int val) {
        this.val = val;
    }

}

public class MaximumDepthOfBinaryTree {
    public int maxDepth(TreeNode root) {
        
        if(root == null) {
            return 0;
        } else {
            int leftmax = maxDepth(root.left);
            int rightmax = maxDepth(root.right);
            return Math.max(leftmax, rightmax) + 1;
        }

    }

    public static TreeNode buildTree(Integer[] arr) {
        if (arr.length == 0 || arr[0] == null) {
            return null;
        }

        TreeNode root = new TreeNode(arr[0]);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        int i = 1;

        while (!queue.isEmpty() && i < arr.length) {
            TreeNode current = queue.poll();

            if (i < arr.length && arr[i] != null) {
                current.left = new TreeNode(arr[i]);
                queue.offer(current.left);
            }
            i++;

            if (i < arr.length && arr[i] != null) {
                current.right = new TreeNode(arr[i]);
                queue.offer(current.right);
            }
            i++;
        }

        return root;
    }

    public static void main(String[] args) {
        // Input array
        Integer[] arr = {3, 9, 20, null, null, 15, 7};

        TreeNode root = buildTree(arr);

        MaximumDepthOfBinaryTree obj = new MaximumDepthOfBinaryTree();

        System.out.println("Maximum Depth: " + obj.maxDepth(root));
    }
}
