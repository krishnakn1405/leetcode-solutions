// Construct Binary Tree from Preorder and Inorder Traversal

// Given two integer arrays preorder and inorder where preorder is the preorder traversal of a binary tree and inorder is the inorder traversal of the same tree, construct and return the binary tree.

// Example 1:
// Input: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
// Output: [3,9,20,null,null,15,7]

// Example 2:
// Input: preorder = [-1], inorder = [-1]
// Output: [-1]

import java.util.Map;
import java.util.HashMap;
import java.util.Queue;
import java.util.LinkedList;
import java.util.ArrayList;
import java.util.List;

class TreeNode {
    int val;
    TreeNode left, right;

    TreeNode(int val) {
        this.val = val;
    }
}

class ConstructBinaryTreeFromPreorderAndInorderTraversal {

    int preorderIndex;
    Map<Integer, Integer> inorderIndexMap;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        
        preorderIndex = 0;
        inorderIndexMap = new HashMap<>();

        for(int i=0; i<inorder.length; i++) {
            inorderIndexMap.put(inorder[i], i);
        }

        return arrayToTree(preorder, 0, preorder.length - 1);
    }

    public TreeNode arrayToTree(int[] preorder, int left, int right) {

        if(left>right) {
            return null;
        }

        int rootValue = preorder[preorderIndex];
        preorderIndex++;

        TreeNode root = new TreeNode(rootValue);
        root.left = arrayToTree(preorder, left, inorderIndexMap.get(rootValue)-1);
        root.right = arrayToTree(preorder, inorderIndexMap.get(rootValue)+1, right);

        return root;
    }

    // Convert tree to level-order array
    public static List<Integer> treeToArray(TreeNode root) {
        List<Integer> result = new ArrayList<>();

        if (root == null) {
            return result;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();

            if (node == null) {
                result.add(null);
                continue;
            }

            result.add(node.val);
            queue.add(node.left);
            queue.add(node.right);
        }

        // Remove trailing nulls
        while (!result.isEmpty()
                && result.get(result.size() - 1) == null) {
            result.remove(result.size() - 1);
        }

        return result;
    }

    public static void main(String[] args) {
        int[] preorder = {3, 9, 20, 15, 7};
        int[] inorder = {9, 3, 15, 20, 7};

        ConstructBinaryTreeFromPreorderAndInorderTraversal obj =
            new ConstructBinaryTreeFromPreorderAndInorderTraversal();

        TreeNode root = obj.buildTree(preorder, inorder);

        System.out.println(treeToArray(root));
    }
}

