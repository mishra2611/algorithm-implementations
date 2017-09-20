/*
Author:     smishra, saraswatimishra18@gmail.com
 Date:       Sep 11, 2017
 Problem:    Maximum Product of Three Numbers
 Difficulty: Easy
Given an integer array, find three numbers whose product is maximum and output the maximum product.
*/

class Solution {
    public int maximumProduct(int[] nums) {
        Arrays.sort(nums);
        if(nums.length<3)
            return 0;
        int n=nums.length-1, max=Integer.MIN_VALUE, tmp,score1,score2;
        if(nums[0]<0 && nums[1]< 0 && nums[n]>0)
        {
            score1=nums[0]* nums[1]* nums[n];
            score2=nums[n]*nums[n-1]*nums[n-2];
            tmp=score1>score2?score1:score2;
            max=tmp>max?tmp:max;
        }    
        else if(nums[0]<0 && nums[1]< 0 && nums[n]<0)
            max=nums[n]*nums[n-1]*nums[n-2];
        else if(nums[n]==0)
            return 0;
        else
        {
            max= nums[n]*nums[n-1]*nums[n-2];
        }
        return max;    
        
    }
}
