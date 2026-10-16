// Binary Tree Zigzag Level Order Traversal

// Given the root of a binary tree, return the zigzag level order traversal of its nodes' values. (i.e., from left to right, then right to left for the next level and alternate between).

// Example 1:
// Input: root = [3,9,20,null,null,15,7]
// Output: [[3],[20,9],[15,7]]

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

class BinaryTreeZigzagLevelOrderTraversal {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        
        if(root == null) {
            return new ArrayList<List<Integer>>();
        }

        List<List<Integer>> results = new ArrayList<List<Integer>>();

        // add the root element with a delimiter to kick off the BFS loop
        LinkedList<TreeNode> node_queue = new LinkedList<TreeNode>();
        node_queue.addLast(root);
        node_queue.addLast(null);

        LinkedList<Integer> level_list = new LinkedList<Integer>();
        boolean is_order_left = true;

        while(node_queue.size() > 0) {

            TreeNode curr_node = node_queue.pollFirst();
            if(curr_node != null) {

                if(is_order_left) {
                    level_list.addLast(curr_node.val);
                } else {
                    level_list.addFirst(curr_node.val);
                }

                if(curr_node.left != null) {
                    node_queue.addLast(curr_node.left);
                }

                if(curr_node.right != null) {
                    node_queue.addLast(curr_node.right);
                }
            } else {

                // we finish the scan of one level
                results.add(level_list);
                level_list = new LinkedList<Integer>();

                // prepare for the next level
                if(node_queue.size() > 0) {
                    node_queue.addLast(null);
                }

                is_order_left = !is_order_left;
            }
        }

        return results;
    }


    // Convert array into a binary tree
    public static TreeNode buildTree(Integer[] arr) {

        if (arr.length == 0 || arr[0] == null) {
            return null;
        }

        TreeNode root = new TreeNode(arr[0]);
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
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

        BinaryTreeZigzagLevelOrderTraversal obj =
                new BinaryTreeZigzagLevelOrderTraversal();

        List<List<Integer>> result = obj.zigzagLevelOrder(root);

        System.out.println(result);
    }
}

