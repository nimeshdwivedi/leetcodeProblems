package main.java.problems.trees;

/*
Given the root of a binary tree, return its maximum depth.
A binary tree's maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
 */
public class MaxDepthInBinaryTree {

    public static class TreeNode {
        int val;
        MaxDepthInBinaryTree.TreeNode left;
        MaxDepthInBinaryTree.TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, MaxDepthInBinaryTree.TreeNode left, MaxDepthInBinaryTree.TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public static void main(String[] args) {
        MaxDepthInBinaryTree.TreeNode node1 = new MaxDepthInBinaryTree.TreeNode(7,null,null);
        MaxDepthInBinaryTree.TreeNode node4 = new MaxDepthInBinaryTree.TreeNode(15,null,null);
        MaxDepthInBinaryTree.TreeNode node2 = new MaxDepthInBinaryTree.TreeNode(20,node4,node1);

        MaxDepthInBinaryTree.TreeNode node0 = new MaxDepthInBinaryTree.TreeNode(9,null,null);
        MaxDepthInBinaryTree.TreeNode node01 = new MaxDepthInBinaryTree.TreeNode(3,node0,node2);

        System.out.println(new MaxDepthInBinaryTree().maxDepth(node01));
    }

    public int maxDepth(TreeNode root) {
        if(root == null)
            return 0;
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        return 1 + Math.max(left, right);
    }
}
