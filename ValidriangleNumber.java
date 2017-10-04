/*
@Author: Saraswati Mishra
Given an array consists of non-negative integers, your task is to count the number of triplets chosen from the array that can make triangles if we take them as side lengths of a triangle.

Example 1:

Input: [2,2,3,4]
Output: 3
Explanation:
Valid combinations are: 
2,3,4 (using the first 2)
2,3,4 (using the second 2)
2,2,3

*/

class Solution {
    public int triangleNumber(int[] nums) {
        if(nums.length<3)
            return 0;
        int s=0, e=nums.length-1, m=s+1, count=0;
        Arrays.sort(nums);
        while(s<e)
        {
            if(m<e && s!=m && m!=e){
               if(nums[s]+nums[m]>nums[e] && nums[e]-nums[s]<nums[m])
            {
                count++;m++;
            }
            else if(nums[s]+nums[m]<=nums[e] ){
                 m++;continue;
            } 
            }

            if(m==e)
            {
                e--;
                m=s+1;
            }
            if(s==e)
            {
                s++;e=nums.length-1;
                m=s+1;
            }
        }
        return count;
    }
}
