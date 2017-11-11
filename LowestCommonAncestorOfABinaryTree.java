/*

 Given a binary tree, find the lowest common ancestor (LCA) of two given nodes in the tree.

According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two nodes v and w as the lowest node in T that has both v and w as descendants (where we allow a node to be a descendant of itself).”

        _______3______
       /              \
    ___5__          ___1__
   /      \        /      \
   6      _2       0       8
         /  \
         7   4

For example, the lowest common ancestor (LCA) of nodes 5 and 1 is 3. Another example is LCA of nodes 5 and 4 is 5, since a node can be a descendant of itself according to the LCA definition.

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
    
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
       LinkedList<TreeNode> path1=new LinkedList<TreeNode>();
    LinkedList<TreeNode> path2=new LinkedList<TreeNode>(); 
        getPath(root,q, path1);
        getPath(root,p, path2);
        TreeNode anc=root;
        while(path1.size()>0 && path2.size()>0)
        {
            TreeNode n1=path1.removeLast();
            TreeNode n2=path2.removeLast();
            if(n1==n2)
                anc=n1;
            else break;
        }
        return anc;
    }


 TreeNode getPath(TreeNode root,TreeNode p,LinkedList<TreeNode> path)
    {
        if(root==null|| p==null)
            return null;
        if(root==p)
        {
            path.add(root);
             return root;
        }
        if(getPath(root.left,p, path)!=null)
        {
            path.add(root);
             return root;
        }
        if(getPath(root.right,p, path)!=null)
        {
           path.add(root);
             return root; 
        }
        return null;
    }
    
    
    
}
