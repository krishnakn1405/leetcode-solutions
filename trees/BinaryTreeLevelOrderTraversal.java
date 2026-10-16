// Binary Tree Level Order Traversal

// Given the root of a binary tree, return the level order traversal of its nodes' values. (i.e., from left to right, level by level).

// Example 1:
// Input: root = [3,9,20,null,null,15,7]
// Output: [[3],[9,20],[15,7]]

// Example 2:
// Input: root = [1]
// Output: [[1]]

// Example 3:
// Input: root = []
// Output: []

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class TreeNode {
    int val;
    TreeNode left, right;

    TreeNode(int val) {
        this.val = val;
    }
}

class BinaryTreeLevelOrderTraversal {

    List<List<Integer>> ans = new ArrayList<>();

    public void order(TreeNode node, int level) {

        if(ans.size() == level) {
            ans.add(new ArrayList<Integer>());
        }

        ans.get(level).add(node.val);

        if(node.left != null) {
            order(node.left, level+1);
        }

        if(node.right != null) {
            order(node.right, level+1);
        }
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        
        if(root == null) {
            return ans;
        }

        order(root, 0);
        return ans;
    }

    // Build binary tree from array (level-order format)
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
        Integer[] arr = {3, 9, 20, null, null, 15, 7};

        TreeNode root = buildTree(arr);

        BinaryTreeLevelOrderTraversal obj =
                new BinaryTreeLevelOrderTraversal();

        List<List<Integer>> result = obj.levelOrder(root);

        System.out.println(result);
    }

}
