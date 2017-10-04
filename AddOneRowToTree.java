/*
@Author: Saraswati Mishra
Given the root of a binary tree, then value v and depth d, you need to add a row of nodes with value v at the given depth d. The root node is at depth 1.

The adding rule is: given a positive integer depth d, for each NOT null tree nodes N in depth d-1, create two tree nodes with value v as N's left subtree root and right subtree root. And N's original left subtree should be the left subtree of the new left subtree root, its original right subtree should be the right subtree of the new right subtree root. If depth d is 1 that means there is no depth d-1 at all, then create a tree node with value v as the new root of the whole original tree, and the original tree is the new root's left subtree.
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
    int count=2;
    
    public TreeNode addOneRow(TreeNode root, int v, int d) {
        TreeNode currLeft=null,currRight=null;
         if(d==1)
            {
                currLeft=new TreeNode(v);
                currLeft.left=root;
                return currLeft;
            }
            else 
            return addRow(root,v,d);
            
    }
    
     TreeNode addRow(TreeNode root, int v, int d) {
        TreeNode currLeft=null,currRight=null; 
     
        if(root==null)
            return null;
            System.out.println("Current data:"+root.val);
           
        if(count==d)
        {
            currLeft=new TreeNode(v);
            currRight=new TreeNode(v);
                currLeft.left=root.left;
                currRight.right=root.right;
                root.left=currLeft;
                root.right=currRight;
        }

            count++;
            root.left=addRow(root.left,v,d);
            root.right=addRow(root.right,v,d);
            count--;
            //System.out.println("Current data:"+curr.val);
            return root;
    }
    
    
   
}
