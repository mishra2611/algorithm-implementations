/*

173. Binary Search Tree Iterator 

Implement an iterator over a binary search tree (BST). Your iterator will be initialized with the root node of a BST.

Calling next() will return the next smallest number in the BST.

Note: next() and hasNext() should run in average O(1) time and uses O(h) memory, where h is the height of the tree.

Credits:
Special thanks to @ts for adding this problem and creating all test cases.
*/


/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

public class BSTIterator {
    Stack<TreeNode> s=new Stack<TreeNode>();
    public BSTIterator(TreeNode root) {
        while(root!=null)
        {
            s.push(root);
            root=root.left;
        } 
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        if(s!=null && !s.isEmpty())
            return true;
        return false;
        
    }

    /** @return the next smallest number */
    public int next() {
        TreeNode curr;
        TreeNode latest=s.pop();
        curr=latest;
        latest=latest.right;
        while(latest!=null)
        {
            s.push(latest);
            latest=latest.left;
        }
        return curr.val;
    }
}

/**
 * Your BSTIterator will be called like this:
 * BSTIterator i = new BSTIterator(root);
 * while (i.hasNext()) v[f()] = i.next();
 */
