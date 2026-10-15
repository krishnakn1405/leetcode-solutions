// Invert Binary Tree

// Given the root of a binary tree, invert the tree, and return its root.

// Example 1:
// Input: root = [4,2,7,1,3,6,9]
// Output: [4,7,2,9,6,3,1]

// Example 2:
// Input: root = [2,1,3]
// Output: [2,3,1]

// Example 3:
// Input: root = []
// Output: []

import java.util.Queue;
import java.util.LinkedList;
import java.util.List;
import java.util.ArrayList;

class TreeNode {
    int val;
    TreeNode left, right;

    TreeNode(int val) {
        this.val = val;
    }
}

class InvertBinaryTree {
    public TreeNode invertTree(TreeNode root) {
        
        if(root == null) {
            return null;
        }

        TreeNode right = invertTree(root.right);
        TreeNode left = invertTree(root.left);

        root.left = right;
        root.right = left;

        return root;
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

    public static List<Integer> treeToArray(TreeNode root) {
        List<Integer> result = new ArrayList<>();

        if (root == null) {
            return result;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            TreeNode current = queue.poll();

            if (current == null) {
                result.add(null);
                continue;
            }

            result.add(current.val);
            queue.offer(current.left);
            queue.offer(current.right);
        }

        // Remove trailing null values
        while (!result.isEmpty()
                && result.get(result.size() - 1) == null) {
            result.remove(result.size() - 1);
        }

        return result;
    }

    public static void main(String[] args) {
        // Input array
        Integer[] arr = {4, 2, 7, 1, 3, 6, 9};

        TreeNode root = buildTree(arr);

        InvertBinaryTree obj = new InvertBinaryTree();
        TreeNode invertedRoot = obj.invertTree(root);

        System.out.println(treeToArray(invertedRoot));
    }

}
