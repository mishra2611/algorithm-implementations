/*

There is a brick wall in front of you. The wall is rectangular and has several rows of bricks. The bricks have the same height but different width. You want to draw a vertical line from the top to the bottom and cross the least bricks.

The brick wall is represented by a list of rows. Each row is a list of integers representing the width of each brick in this row from left to right.

If your line go through the edge of a brick, then the brick is not considered as crossed. You need to find out how to draw the line to cross the least bricks and return the number of crossed bricks.

You cannot draw a line just along one of the two vertical edges of the wall, in which case the line will obviously cross no bricks.

Example:

Input: 
[[1,2,2,1],
 [3,1,2],
 [1,3,2],
 [2,4],
 [3,1,2],
 [1,3,1,1]]



*/


class Solution {
    public int leastBricks(List<List<Integer>> wall) {
        if(wall.size()==0)
            return 0;
        int sum=0, rowSum=0,count=Integer.MIN_VALUE;;
        
        HashMap<Integer, Integer> map=new HashMap<Integer, Integer>();
        
        for(int i=0;i<wall.size();i++)
        {
            List<Integer> tmp=wall.get(i);
            sum=0;
            for(int j=0;j<tmp.size()-1;j++)
            {
                int sumCount=0;
                sum=sum+tmp.get(j);
                if(map.get(sum)==null)
                    sumCount=1;
                else
                    sumCount=map.get(sum)+1;
                 map.put(sum, sumCount); 
                count=count<sumCount?sumCount:count;
            }
            
        }
        if(map.size()==0)
            return wall.size();
        return wall.size()-count;
    }
}
