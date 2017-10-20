/*
@Author: Saraswati Mishra
325. Maximum Size Subarray Sum Equals k
 Given an array nums and a target value k, find the maximum length of a subarray that sums to k. If there isn't one, return 0 instead.

Note:
The sum of the entire nums array is guaranteed to fit within the 32-bit signed integer range.

Example 1:

Given nums = [1, -1, 5, -2, 3], k = 3,
return 4. (because the subarray [1, -1, 5, -2] sums to 3 and is the longest)

Example 2:

Given nums = [-2, -1, 2, 1], k = 1,
return 2. (because the subarray [-1, 2] sums to 1 and is the longest) 
*/
class Solution {
    public int maxSubArrayLen(int[] nums, int k) {
        HashMap<Integer, Integer> map=new HashMap<Integer, Integer>();
        int sum=0,len=0, maxlen=0;
        for(int i=0;i<nums.length;i++)
        {
            sum=sum+nums[i];
            if(sum==k)
                len=i;
            map.put(sum,i);
        }
        if(map.get(k)!=null)
            maxlen= map.get(k)+1;
        sum=0;
        for(int i=0;i<nums.length;i++)
        {
            sum=sum+nums[i];
            if(!(map.get(k+sum)==null))
            {
                int curr=map.get(k+sum)-i;
                maxlen=maxlen<curr?curr:maxlen ;
            }
        }
        if(maxlen>0)
            return maxlen;
        return 0;
    }
}
