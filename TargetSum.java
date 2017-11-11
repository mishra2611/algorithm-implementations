/*
 You are given a list of non-negative integers, a1, a2, ..., an, and a target, S. Now you have 2 symbols + and -. For each integer, you should choose one from + and - as its new symbol.

Find out how many ways to assign symbols to make sum of integers equal to target S.

Example 1:

Input: nums is [1, 1, 1, 1, 1], S is 3. 
Output: 5
Explanation: 

-1+1+1+1+1 = 3
+1-1+1+1+1 = 3
+1+1-1+1+1 = 3
+1+1+1-1+1 = 3
+1+1+1+1-1 = 3

There are 5 ways to assign symbols to make the sum of nums be target 3.

Note:

    The length of the given array is positive and will not exceed 20.
    The sum of elements in the given array will not exceed 1000.
    Your output answer is guaranteed to be fitted in a 32-bit integer.



*/


class Solution {
    int count=0;
    public int findTargetSumWays(int[] nums, int S) {
        findSum(nums,nums.length-1, 0, S,0);
        return count;
    }
    
    void findSum(int[] nums,int len, int level, int target, int sum)
    {
        int sum1=sum+nums[level], sum2=sum-nums[level];
        if(level==len)
        {
            if(sum1==target)
            count++;
            if(sum2==target)
                count++;
            return;
        }
        findSum(nums, len, level+1, target, sum1);
        findSum(nums, len, level+1, target, sum2);
        return;
    }
}
