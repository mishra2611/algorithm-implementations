/*
Author:     smishra, saraswatimishra18@gmail.com
 Date:       Aug 20, 2017
 Problem:    Subsets
 Difficulty: Medium

 Question: Given a set of distinct integers, nums, return all possible subsets.

Note: The solution set must not contain duplicate subsets.

For example,
If nums = [1,2,3], a solution is:

[
  [3],
  [1],
  [2],
  [1,2,3],
  [1,3],
  [2,3],
  [1,2],
  []
]

*/
class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> list=new ArrayList<List<Integer>>();
        int n=nums.length;
        int max=(new Double(Math.pow(2,n))).intValue();
        for(int i=0;i<max;i++)
        {
            List<Integer> al=new ArrayList<Integer>();
            for(int j=0;j<n;j++)
            {
                if((i&(1<<j))>0)
                    al.add(nums[j]);
                    
            }
            list.add(al);
        }
        return list;
    }
}
