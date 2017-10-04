/*
Author:     smishra, saraswatimishra18@gmail.com
 Date:       Sept 30, 2017
 Problem:    Maximum Average Subarray
 Difficulty: Easy
Given an array consisting of n integers, find the contiguous subarray of given length k that has the maximum average value. And you need to output the maximum average value. 
*/


public class Solution {
    public double findMaxAverage(int[] nums, int k) {
        int len=nums.length;
        double avgIni=0, avg;
        if(k>len)
            return avgIni;
        
            for(int i=0;i<k;i++)
                avgIni+=nums[i];
        if(len==k){
                return new Double(avgIni/len);
        }
        avgIni=avgIni/k;
        avg=avgIni;
        System.out.println("Initial vaerage:"+avgIni);
        for(int i=1;i<len-k+1;i++)
        {
            avg=avg-new Double(nums[i-1])/k+new Double(nums[i+k-1])/k;
            if(avg>avgIni)
                avgIni=avg;
        }
        return avgIni;
        
    }
}

