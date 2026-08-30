// Flatten Binary Tree to Linked List

// Given the root of a binary tree, flatten the tree into a "linked list":

// The "linked list" should use the same TreeNode class where the right child pointer points to the next node in the list and the left child pointer is always null.
// The "linked list" should be in the same order as a pre-order traversal of the binary tree.
 
// Example 1:
// Input: root = [1,2,5,3,4,null,6]
// Output: [1,null,2,null,3,null,4,null,5,null,6]

// Example 2:
// Input: root = []
// Output: []

// Example 3:
// Input: root = [0]
// Output: [0]

import java.util.ArrayList;
import java.util.Arrays;
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

class FlattenBinaryTreeToLinkedList {

    public TreeNode flattenTree(TreeNode node) {

        if(node == null) {
            return null;
        }

        if(node.left == null && node.right == null) {
            return node;
        }

        TreeNode leftTail = flattenTree(node.left);
        TreeNode rightTail = flattenTree(node.right);

        if(leftTail != null) {
            leftTail.right = node.right;
            node.right = node.left;
            node.left = null;
        }

        return rightTail == null ? leftTail : rightTail;
    }

    public void flatten(TreeNode root) {
        flattenTree(root);    
    }

    // Convert array representation -> Binary Tree
    public static TreeNode arrayToTree(Integer[] arr) {

        if (arr == null || arr.length == 0 || arr[0] == null) {
            return null;
        }

        TreeNode root = new TreeNode(arr[0]);

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        int i = 1;

        while (!queue.isEmpty() && i < arr.length) {

            TreeNode current = queue.poll();

            // Left child
            if (i < arr.length && arr[i] != null) {
                current.left = new TreeNode(arr[i]);
                queue.offer(current.left);
            }
            i++;

            // Right child
            if (i < arr.length && arr[i] != null) {
                current.right = new TreeNode(arr[i]);
                queue.offer(current.right);
            }
            i++;
        }

        return root;
    }

    // Convert flattened tree -> ArrayList
    public static ArrayList<Integer> treeToArray(TreeNode root) {

    	ArrayList<Integer> result = new ArrayList<>();

    	TreeNode current = root;

    	while (current != null) {
        	result.add(current.val);

        	// Left child is always null after flattening
        	result.add(null);

        	current = current.right;
    	}

    	// Remove the last unnecessary null
    	if (!result.isEmpty()) {
        	result.remove(result.size() - 1);
    	}

    	return result;
    }

    public static void main(String[] args) {

        // Input
        Integer[] input = {1, 2, 5, 3, 4, null, 6};

        // Array -> Binary Tree
        TreeNode root = arrayToTree(input);

        // Flatten
        FlattenBinaryTreeToLinkedList obj =
                new FlattenBinaryTreeToLinkedList();

        obj.flatten(root);

        // Flattened Tree -> ArrayList
	ArrayList<Integer> output = treeToArray(root);

        // Print
        System.out.println("Input:  " + Arrays.toString(input));
        System.out.println("Output: " + output);
    }
}
