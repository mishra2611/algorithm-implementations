/*
Given an array and a value, remove all instances of that value in place and return the new length.

Do not allocate extra space for another array, you must do this in place with constant memory.

The order of elements can be changed. It doesn't matter what you leave beyond the new length.

Example:
Given input array nums = [3,2,2,3], val = 3

Your function should return length = 2, with the first two elements of nums being 2.
*/
class Solution {
    public int removeElement(int[] nums, int val) {
        Arrays.sort(nums);
        if(nums.length==0)
            return 0;
        int startIdx=Integer.MIN_VALUE, endIdx=Integer.MIN_VALUE;
        for(int i=0;i<nums.length;i++)
        {
            if(nums[i]==val &&(i==0 || nums[i-1]<nums[i]))
                startIdx=i;
            if(nums[i]==val &&(i==nums.length-1 || nums[i+1]>nums[i]))
                endIdx=i;
        }
        int i;
        if(startIdx==Integer.MIN_VALUE)
            return nums.length;
        
        for(i=startIdx;i<nums.length;i++)
        {
            if(nums.length>endIdx+1)
            nums[i]=nums[++endIdx];
            else 
                break;
        }
        
        return i;
        
    }
}
