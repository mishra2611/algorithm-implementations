/*
Given an absolute path for a file (Unix-style), simplify it.

For example,
path = "/home/", => "/home"
path = "/a/./b/../../c/", => "/c"

click to show corner cases.
Corner Cases:

    Did you consider the case where path = "/../"?
    In this case, you should return "/".
    Another corner case is the path might contain multiple slashes '/' together, such as "/home//foo/".
    In this case, you should ignore redundant slashes and return "/home/foo".


*/


class Solution {
    public String simplifyPath(String path) {
        LinkedList<String> s=new LinkedList<String>();
        String[] splitString=path.split("/");
        for(int i=0;i<splitString.length;i++)
        {
            if(splitString[i].equals(".."))
            {
                if(s.size()!=0)
                    s.removeLast();
            }
            else if(splitString[i].equals("")||splitString[i].equals("."))
            {}   
            else
                s.add(splitString[i]);
        }
        StringBuilder sb=new StringBuilder();
         if(s.size()==0)
            sb.append("/");
        
        while(s.size()>0)
        {
            sb.append("/");
            sb.append(s.removeFirst());
            
        }
       
        return sb.toString();
        
    }
}
