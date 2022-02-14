package main.java.problems.trees;

import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreeNode;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class SortElementsInTwoBinaryTrees {

    /*
    Given two binary search trees root1 and root2, return a list containing all the integers from both trees sorted in ascending order.
Example 1:

Input: root1 = [2,1,4], root2 = [1,0,3]
Output: [0,1,1,2,3,4]

Example 2:
Input: root1 = [1,null,8], root2 = [8,1]
Output: [1,1,8,8]

Constraints:
The number of nodes in each tree is in the range [0, 5000].
-105 <= Node.val <= 105
     */

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    List<Integer> integerList = new ArrayList<>();

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1,null,null);
        TreeNode node4 = new TreeNode(4,null,null);
        TreeNode node2 = new TreeNode(2,node1,node4);

        TreeNode node0 = new TreeNode(0,null,null);
        TreeNode node3 = new TreeNode(3,null,null);
        TreeNode node01 = new TreeNode(1,node0,node3);

        List<Integer> integerList = getAllElements(node2, node01);
        integerList.forEach(System.out::println);
    }

    // online solution, Complexity O(M+N)
    public static List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        Stack<TreeNode> st1 = new Stack<>();
        Stack<TreeNode> st2 = new Stack<>();

        List<Integer> res = new ArrayList<>();

        while(root1 != null || root2 != null || !st1.empty() || !st2.empty()){
            while(root1 != null){
                st1.push(root1);
                root1 = root1.left;
            }
            while(root2 != null){
                st2.push(root2);
                root2 = root2.left;
            }
            if(st2.empty() || (!st1.empty() && st1.peek().val <= st2.peek().val)){
                root1 = st1.pop();
                res.add(root1.val);
                root1 = root1.right;
            }
            else{
                root2 = st2.pop();
                res.add(root2.val);
                root2 = root2.right;
            }
        }
        return res;
    }
}
