/*

Given a binary tree, return the bottom-up level order traversal of its nodes' values. (ie, from left to right, level by level from leaf to root).

For example:
Given binary tree [3,9,20,null,null,15,7],

    3
   / \
  9  20
    /  \
   15   7

return its bottom-up level order traversal as:

[
  [15,7],
  [9,20],
  [3]
]


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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        Deque<TreeNode> queue=new LinkedList<TreeNode>();
        List<List<Integer>> mainList=new ArrayList<List<Integer>>();
        if(root==null)
            return mainList;
        queue.add(root);
        while(!queue.isEmpty())
        {
            List<Integer> list=new ArrayList<Integer>();
            int len=queue.size();
            for(int i=0;i<len;i++)
            {
                TreeNode curr=queue.removeFirst();
                list.add(curr.val);
                if(curr.left!=null)
                    queue.add(curr.left);
                if(curr.right!=null)
                        queue.add(curr.right);
            }
            mainList.add(0,list);
        }
        return mainList;
    }
    
}
