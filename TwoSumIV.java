/*
Given a Binary Search Tree and a target number, return true if there exist two elements in the BST such that their sum is equal to the given target.

Example 1:

Input: 
    5
   / \
  3   6
 / \   \
2   4   7

Target = 9

Output: True

Example 2:

Input: 
    5
   / \
  3   6
 / \   \
2   4   7

Target = 28

Output: False

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
    public boolean findTarget(TreeNode root, int k) {
        if(root==null)
            return false;
        HashSet<Integer> set=new HashSet<Integer>();
        return find(set,root,k);
    }
    
    boolean find(HashSet<Integer> set, TreeNode root, int target)
    {
        if(root==null)
            return false;
        if(set.contains(target-root.val))
            return true;
        set.add(root.val);
        return find(set, root.left, target)||find(set, root.right, target);
        
    }
}
