// Validate Binary Search Tree

// Given the root of a binary tree, determine if it is a valid binary search tree (BST).

// A valid BST is defined as follows:
// The left subtree of a node contains only nodes with keys strictly less than the node's key.
// The right subtree of a node contains only nodes with keys strictly greater than the node's key.
// Both the left and right subtrees must also be binary search trees.
 
// Example 1:
// Input: root = [2,1,3]
// Output: true

// Example 2:
// Input: root = [5,1,4,null,null,3,6]
// Output: false
// Explanation: The root node's value is 5 but its right child's value is 4.

import java.util.LinkedList;
import java.util.Queue;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
        this.val = val;
    }
}

class ValidateBinarySearchTree {

    public Integer prev;

    public boolean isValidBST(TreeNode root) {
        prev = null;
        return inOrder(root);
    }

    public boolean inOrder(TreeNode root) {

        if(root == null) {
            return true;
        }

        if(!inOrder(root.left)) {
            return false;
        }

        if(prev != null && root.val <= prev) {
            return false;
        }

        prev = root.val;
        return inOrder(root.right);
    }


    // Build binary tree from level-order array
    public static TreeNode buildTree(Integer[] arr) {
        if (arr == null || arr.length == 0 || arr[0] == null) {
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
        Integer[] arr = {5, 1, 4, null, null, 3, 6};

        TreeNode root = buildTree(arr);

        ValidateBinarySearchTree solution =
                new ValidateBinarySearchTree();

        boolean result = solution.isValidBST(root);

        System.out.println("Is Valid BST: " + result);
    }
}

