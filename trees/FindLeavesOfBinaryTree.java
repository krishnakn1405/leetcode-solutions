// Find Leaves of Binary Tree

// Given the root of a binary tree, collect a tree's nodes as if you were doing this:

// Collect all the leaf nodes.
// Remove all the leaf nodes.
// Repeat until the tree is empty.
 

// Example 1:
// Input: root = [1,2,3,4,5]
// Output: [[4,5,3],[2],[1]]
// Explanation: [[3,5,4],[2],[1]] and [[3,4,5],[2],[1]] are also considered correct answers since per each level it does not matter the order on which elements are returned.

// Example 2:
// Input: root = [1]
// Output: [[1]]

import java.util.ArrayList;
import java.util.List;

class TreeNode {
    int val;
    TreeNode left, right;

    TreeNode(int val) {
        this.val = val;
    }
}

class FindLeavesOfBinaryTree {

    public List<List<Integer>> collectLeaves(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        while(root != null) {
            List<Integer> leaves = new ArrayList<>();
            root = removeLeaves(root, leaves);
            result.add(leaves);
        }

        return result;
    }

    private TreeNode removeLeaves(TreeNode node, List<Integer> leaves) {

        if(node == null) {
            return null;
        }

        if(node.left == null && node.right == null) {
            leaves.add(node.val);
            return null; // Remove the leaf node
        }

        node.left = removeLeaves(node.left, leaves);
        node.right = removeLeaves(node.right, leaves);

        return node;
    }

    public static void main(String[] args) {

        FindLeavesOfBinaryTree solution = new FindLeavesOfBinaryTree();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        List<List<Integer>> result = solution.collectLeaves(root);
        System.out.println(result);
    }
}

