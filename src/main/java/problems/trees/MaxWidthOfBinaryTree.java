package main.java.problems.trees;

import java.util.LinkedList;
import java.util.Queue;

/*
https://leetcode.com/problems/maximum-width-of-binary-tree/

Given the root of a binary tree, return the maximum width of the given tree.
The maximum width of a tree is the maximum width among all levels.
The width of one level is defined as the length between the end-nodes (the leftmost and rightmost non-null nodes), where the null nodes between the end-nodes are also counted into the length calculation.

It is guaranteed that the answer will in the range of 32-bit signed integer.

Example 1:
Input: root = [1,3,2,5,3,null,9]
Output: 4
Explanation: The maximum width existing in the third level with the length 4 (5,3,null,9).

Example 2:
Input: root = [1,3,null,5,3]
Output: 2
Explanation: The maximum width existing in the third level with the length 2 (5,3).

Example 3:
Input: root = [1,3,2,5]
Output: 2
Explanation: The maximum width existing in the second level with the length 2 (3,2).

Constraints:
The number of nodes in the tree is in the range [1, 3000].
-100 <= Node.val <= 100
 */
public class MaxWidthOfBinaryTree {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public static void main(String[] args) {
        // example 1
        TreeNode node5 = new TreeNode(5);
        TreeNode node3 = new TreeNode(3);
        TreeNode node03 = new TreeNode(3, node5, node3);
        TreeNode node9 = new TreeNode(9);
        TreeNode node2 = new TreeNode(2, null, node9);
        TreeNode node1 = new TreeNode(1, node03, node2);

        System.out.println(new MaxWidthOfBinaryTree().widthOfBinaryTree(node1));
    }

    // https://leetcode.com/problems/maximum-width-of-binary-tree/discuss/1803819/Simple-java-solution-using-2-queue-with-explaination-or-bfs
    public int widthOfBinaryTree(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        Queue<Integer> queueIndex = new LinkedList<>();
        queue.add(root);
        queueIndex.add(1);
        int width = 0;
        //do level order traversal
        while (!queue.isEmpty()) {
            int size = queue.size();
            int start = 0;
            //hold index of last node in a level
            int end = 0;
            for (int i = 0; i < size; i++) {
                //remove from both queue
                TreeNode node = queue.poll();
                int index = queueIndex.poll();
                //if i==0 it means its first node
                if (i == 0) {
                    //update start index
                    start = index;
                }
                //if i==last index update end index
                if (i == size - 1) {
                    end = index;
                }
                //normal bfs logic to add node to queue if present. here add to both queue
                if (node.left != null) {
                    queue.add(node.left);
                    queueIndex.add(index * 2);
                }
                //normal bfs logic to add node to queue if present. here add to both queue
                if (node.right != null) {
                    queue.add(node.right);
                    queueIndex.add(index * 2 + 1);
                }
            }
            //update max width
            width = Math.max(width, end - start + 1);
        }
        return width;
    }
}
