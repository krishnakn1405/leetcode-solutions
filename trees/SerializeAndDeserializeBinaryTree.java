// Serialize and Deserialize Binary Tree

// Serialization is the process of converting a data structure or object into a sequence of bits so that it can be stored in a file or memory buffer, or transmitted across a network connection link to be reconstructed later in the same or another computer environment.

// Design an algorithm to serialize and deserialize a binary tree. There is no restriction on how your serialization/deserialization algorithm should work. You just need to ensure that a binary tree can be serialized to a string and this string can be deserialized to the original tree structure.

// Clarification: The input/output format is the same as how LeetCode serializes a binary tree. You do not necessarily need to follow this format, so please be creative and come up with different approaches yourself.

// Example 1:
// Input: root = [1,2,3,null,null,4,5]
// Output: [1,2,3,null,null,4,5]

// Example 2:
// Input: root = []
// Output: []

import java.util.List;
import java.util.LinkedList;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.Queue;

class TreeNode {
    int val;
    TreeNode left, right;

    TreeNode(int val) {
        this.val = val;
    }
}

public class SerializeAndDeserializeBinaryTree {

    public String recserialize(TreeNode root, String str) {

        if(root == null) {
            str += "null,";
        } else {
            str += str.valueOf(root.val) + ",";
            str = recserialize(root.left, str);
            str = recserialize(root.right, str);
        }

        return str;
    }

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        return recserialize(root, "");
    }

    public TreeNode redeserialize(List<String> str) {

        if(str.get(0).equals("null")) {
            str.remove(0);
            return null;
        }

        TreeNode root = new TreeNode(Integer.valueOf(str.get(0)));
        str.remove(0);
        root.left = redeserialize(str);
        root.right = redeserialize(str);

        return root;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        
        String[] strArray = data.split(",");
        List<String> strList = new LinkedList<String>(Arrays.asList(strArray));
        return redeserialize(strList);
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

            if (i < arr.length && arr[i] != null) {
                current.left = new TreeNode(arr[i]);
                queue.add(current.left);
            }
            i++;

            if (i < arr.length && arr[i] != null) {
                current.right = new TreeNode(arr[i]);
                queue.add(current.right);
            }
            i++;
        }

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
            } else {
                result.add(node.val);
                queue.add(node.left);
                queue.add(node.right);
            }
        }

        // Remove trailing null values
        while (!result.isEmpty()
                && result.get(result.size() - 1) == null) {
            result.remove(result.size() - 1);
        }

        return result;
    }

    public static void main(String[] args) {
        Integer[] arr = {1, 2, 3, null, null, 4, 5};

        SerializeAndDeserializeBinaryTree obj =
                new SerializeAndDeserializeBinaryTree();

        TreeNode root = buildTree(arr);

        String serialized = obj.serialize(root);
        System.out.println("Serialized: " + serialized);

        TreeNode deserialized = obj.deserialize(serialized);

        System.out.println("Output: " + treeToArray(deserialized));
    }
}

