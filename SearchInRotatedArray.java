/*

Author:     smishra, saraswatimishra18@gmail.com
 Date:       Aug 20, 2017
 Problem:    Search in rotated array
 Difficulty: Medium

Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.

(i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).

You are given a target value to search. If found in the array return its index, otherwise return -1.

You may assume no duplicate exists in the array.
*/

class Solution {
    public int search(int[] nums, int target) {
        if(nums.length==0)
            return -1;
        return binSearch(nums, 0, nums.length-1, target);
    }
    
    int binSearch(int[] nums, int low, int high, int target)
    {
        if(low>high)
            return -1;
        if(high==low)
        {
            if(nums[low]==target)
                return low;
            else
                return -1;
        }
        int mid=(low+high)/2;
        System.out.println(mid);
        if(nums[mid]==target)
            return mid;
        
        if( low<mid && nums[low]<nums[mid] && target>=nums[low] && target<=nums[mid] )
            return binSearch(nums, low, mid-1, target);
        else if(low<mid && nums[low]>nums[mid] && (nums[low]<=target || target<=nums[mid]))    
            return binSearch(nums, low, mid-1, target);
        else if((mid<high) && nums[mid]<nums[high] && nums[mid]<=target && target<=nums[high])
            return binSearch(nums, mid+1, high, target);
        else if((mid<high) && nums[mid]>nums[high] && (target>=nums[mid] || target<=nums[high]))
            return binSearch(nums, mid+1, high, target);
        return -1;
    }
}
