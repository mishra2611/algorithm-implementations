/*
 Given a binary search tree and a node in it, find the in-order successor of that node in the BST.

Note: If the given node has no in-order successor in the tree, return null. 

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
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        System.out.println("Root:"+root.val+"Node:"+p.val);
        if(root==null|| p==null)
            return null;
        if(root.val==p.val)
        {
            if(p.right!=null)
                return min(p.right);
            return null;
        }
        else if(root.val<p.val)
            return inorderSuccessor(root.right,p);
        else //Root.val>p.val
        {
            TreeNode curr=inorderSuccessor(root.left,p);
            if(curr==null)
                return root;
            return curr;
        }
    }
    
    TreeNode min(TreeNode root)
    {
        if(root==null)
            return null;
        while(root.left!=null)
            root=root.left;
        return root;
    }
}
