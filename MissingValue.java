/*
@Author: Saraswati Mishra
 Given an array containing n distinct numbers taken from 0, 1, 2, ..., n, find the one that is missing from the array.

For example,
Given nums = [0, 1, 3] return 2.

Note:
Your algorithm should run in linear runtime complexity. Could you implement it using only constant extra space complexity? 
*/


class Solution {
    public int missingNumber(int[] nums) {
        
        for(int i=0;i<nums.length;i++)
        {
            if(nums[i]!=i)
            {
              if(nums[i]!=nums.length)
                {
                    int k=nums[i], tmp;
                    System.out.println(nums[k] );
                    while(  k!=nums.length && nums[k]!=k)
                    {
                        tmp=nums[k];
                        nums[k]=k;
                        k=tmp;
                    }
                }
            }
        }
        for(int i=0;i<nums.length;i++)
        {
            System.out.println(nums[i]);
            if(nums[i]!=i)
                return i;
        }
        return nums.length;
    }
}
