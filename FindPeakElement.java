
/* Author:     smishra, saraswatimishra18@gmail.com
 Date:       Aug 20, 2017
 Problem:    Subsets
 Difficulty: Medium

A peak element is an element that is greater than its neighbors.

Given an input array where num[i] ≠ num[i+1], find a peak element and return its index.

The array may contain multiple peaks, in that case return the index to any one of the peaks is fine.

You may imagine that num[-1] = num[n] = -∞.

For example, in array [1, 2, 3, 1], 3 is a peak element and your function should return the index number 2.

 */
class Solution {
    public int findPeakElement(int[] nums) {
        int max=Integer.MIN_VALUE, idx=0;
        if(nums.length==0)
            return 0;
        else
        { 
            for(int i=0;i<nums.length;i++)
            {
                if(nums[i]>max)
                {
                    max=nums[i];idx=i;
                }      
            }
        }
        return idx;
    }
}
