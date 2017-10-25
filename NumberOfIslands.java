/*
@Author: Saraswati Mishra
Given a 2d grid map of '1's (land) and '0's (water), count the number of islands. An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.
*/

class Solution {
    int max=0;
    public int numIslands(char[][] grid) {
        if(grid.length==0)
            return 0;
        for(int i=0;i<grid.length;i++)
        {
            for(int j=0;j<grid[0].length;j++)
            {
                if(grid[i][j]=='1')
                {
                    grid=updateIsland(grid,i,j);
                    max++;
                }
            }
        }
        return max;
    }
    char[][] updateIsland(char[][]  grid,int row, int col)
    {
        if(row<0 ||  col<0|| row>=grid.length ||  col>=grid[0].length)
            return grid;
        if(grid[row][col]=='1'){
            grid[row][col]='.';
        grid=updateIsland(grid,row-1,col);
        grid=updateIsland(grid,row+1,col);
        grid=updateIsland(grid,row,col+1);
        grid=updateIsland(grid, row,col-1);
        }
            
        return grid;
    }
}
