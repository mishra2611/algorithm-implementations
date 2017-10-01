/*
 Author:     smishra, saraswatimishra18@gmail.com
 Date:       Sept 30, 2017
 Problem:    Find integer square root of a number
 Difficulty: Easy

Implement int sqrt(int x).
*/



class Solution {
    public int mySqrt(int x) {
        if(x<2)
            return x;
        int mid=x/2;
        int prev=mid, a=mid;
        while(a>x/a){
            prev=a;
          a=a/2;  
        }
           
    for(int i=prev; i>=a;i--)
    {
        if(i<=x/i)
            return i;
    }
     return 1;   
       
    }
}
