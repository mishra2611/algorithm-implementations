/*
 Given a collection of integers that might contain duplicates, nums, return all possible subsets (the power set).

Note: The solution set must not contain duplicate subsets.

For example,
If nums = [1,2,2], a solution is:

[
  [2],
  [1],
  [1,2,2],
  [2,2],
  [1,2],
  []
]

*/


class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        
             Arrays.sort(nums);
        List<List<Integer>> list=new ArrayList<List<Integer>>();
        bt(nums,0,list, new ArrayList<Integer>());
        return list;
    }
    
    void bt(int[] nums, int index, List<List<Integer>> list, List<Integer> path)
    {
            list.add(new ArrayList<>(path));
        
        for(int i=index;i<nums.length;i++)
        {
            if(i>index && nums[i]==nums[i-1])
                continue;
            path.add(nums[i]);
            bt(nums, i+1,list, path);
            path.remove(path.size()-1);
        }
    }
   
}
