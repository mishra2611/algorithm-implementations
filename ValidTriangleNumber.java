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
