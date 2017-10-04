/*
 Given two binary trees and imagine that when you put one of them to cover the other, some nodes of the two trees are overlapped while the others are not.

You need to merge them into a new binary tree. The merge rule is that if two nodes overlap, then sum node values up as the new value of the merged node. Otherwise, the NOT null node will be used as the node of new tree. 
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
public class Solution {
    TreeNode root;
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        TreeNode curr=null;
        if(t1==null && t2==null)
            return curr;
        int sum=0;
        if(t1!=null && t2!=null)
        {
            sum=t1.val+t2.val;
        }
        else if(t1!=null && t2==null)
            sum=t1.val;
        else if(t1==null && t2!=null)
            sum=t2.val;
        curr=new TreeNode(sum);
       //System.out.println("Current node="+curr.val);
       
       
        curr.left=mergeTrees(t1==null?null:t1.left, t2==null?null:t2.left);
        curr.right=mergeTrees(t1==null?null:t1.right, t2==null?null:t2.right);
         return curr;
    }
}
