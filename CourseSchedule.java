/*
 There are a total of n courses you have to take, labeled from 0 to n - 1.

Some courses may have prerequisites, for example to take course 0 you have to first take course 1, which is expressed as a pair: [0,1]

Given the total number of courses and a list of prerequisite pairs, is it possible for you to finish all courses?

For example:

2, [[1,0]]

There are a total of 2 courses to take. To take course 1 you should have finished course 0. So it is possible.

2, [[1,0],[0,1]]

There are a total of 2 courses to take. To take course 1 you should have finished course 0, and to take course 0 you should also have finished course 1. So it is impossible.
*/


class Solution {
    
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        HashMap<Integer, ArrayList<Integer>> map=new HashMap<Integer, ArrayList<Integer>>();
        HashMap<Integer, Integer> inbound=new HashMap<Integer, Integer>();
        HashSet<Integer> visited=new HashSet<Integer>();
        if(numCourses<2)
            return true;
        for(int i=0;i<prerequisites.length;i++)
        {
            if(map.get(prerequisites[i][0])==null)
            {
               map.put(prerequisites[i][0], new ArrayList<Integer>());
               inbound.put(prerequisites[i][0],0); 
            }
            
            if(map.get(prerequisites[i][1])==null)
            {
               map.put(prerequisites[i][1], new ArrayList<Integer>());
                inbound.put(prerequisites[i][1],1); 
            }
            else
                inbound.put(prerequisites[i][1],inbound.get(prerequisites[i][1])+1);    
            map.get(prerequisites[i][0]).add(prerequisites[i][1]);
        }
        return topoSort(map,inbound, visited);
        
    }
    
    boolean topoSort(HashMap<Integer, ArrayList<Integer>> map, HashMap<Integer, Integer> inbound, HashSet<Integer> visited)
    {
        if(visited.size()==map.size())
            return true;
        int curr=getMinInbound(inbound, visited);
        if(curr==-1)
            return false;
       
        
        visited.add(curr);
        ArrayList<Integer> list=map.get(curr);
        for(int i=0;i<list.size();i++)
        {
            int tmp=list.get(i);
            inbound.put(tmp,inbound.get(tmp)-1);
        }
        return topoSort(map,inbound,visited);
    }
    
    int getMinInbound(HashMap<Integer, Integer> inbound, HashSet<Integer> visited)
    {
        for(Map.Entry<Integer, Integer> entry: inbound.entrySet())
        {
            //System.out.println(entry.getKey()+" "+entry.getValue());
            if(entry.getValue()==0 && !visited.contains(entry.getKey()))
            {
                System.out.println("Inbound value"+entry.getKey());
                return entry.getKey();
            }
                
        }
        return -1;
    }
}
