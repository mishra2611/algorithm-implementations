/*
Author:     smishra, saraswatimishra18@gmail.com
 Date:       Aug 20, 2017
 Problem:    231. Is Power of Two
 Difficulty: Easy
Given an integer, write a function to determine if it is a power of two. 
*/

class Solution {
    public boolean isPowerOfTwo(int n) {
        while(n%2==0 && n>0)
        {
            n=n/2;
        }
        if(n==1)
            return true;
        return false;
        
    }
}
