/*
Given a binary tree, determine if it is height-balanced.

For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1. 
*/


/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public boolean isBalanced(TreeNode root) {
        if(root==null)
            return true;
        if(isBalanced(root.left) && isBalanced(root.right))
        {
            int left=height(root.left);
        int right=height(root.right);
            int diff=Math.abs(left-right);
        if(diff>1)
            return false;
        return true;
        }
        return false;
        
        
    }
    
   int height(TreeNode root)
   {
       if(root==null)
           return 0;
       int left=height(root.left);
       int right=height(root.right);
       if(Math.abs(left-right)>1)
           return 100;
       System.out.println("At node:"+root.val+"Height:"+Math.max(left, right));
       return 1+Math.max(left, right);
   }
}
