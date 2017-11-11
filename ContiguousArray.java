/*

525. Contiguous Array 

Given a binary array, find the maximum length of a contiguous subarray with equal number of 0 and 1.

Example 1:

Input: [0,1]
Output: 2
Explanation: [0, 1] is the longest contiguous subarray with equal number of 0 and 1.

Example 2:

Input: [0,1,0]
Output: 2
Explanation: [0, 1] (or [1, 0]) is a longest contiguous subarray with equal number of 0 and 1.

Note: The length of the given binary array will not exceed 50,000. 

*/


class Solution {
    public int findMaxLength(int[] nums) {
        HashMap<Integer, Integer> map=new HashMap<Integer, Integer>();
        int[] helper=new int[nums.length];
        int sum=0,tmp=0, max=0;
        
        for(int i=0;i<nums.length;i++)
        {
            if(nums[i]==0)
                sum-=1;
            else
                sum+=1;
            if(sum==0)
            {
                max=max>(i+1)?max:(i+1);
                //map.put(sum,i);
            }
                
            else
            {
                if(map.get(sum)==null)
            {
                map.put(sum,i);
            }
            else
            {
                tmp=map.get(sum);
                tmp=i-tmp;
                max=max>tmp?max:tmp;
            }
            }
            
            
        }
        return max;
        
        
        
    }
   
    
}
