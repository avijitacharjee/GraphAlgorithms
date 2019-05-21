package javaapplication90;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Stack;

public class JavaApplication90 {
    public static void main(String[] args)
    {
        Graph g = new Graph(6); 
  
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 0);
        g.addEdge(1, 3);
        g.addEdge(1, 4);
        g.addEdge(2, 0);
        g.addEdge(2, 4);
        g.addEdge(3, 1);
        g.addEdge(3, 4);
        g.addEdge(3, 5);
        g.addEdge(4, 1);
        g.addEdge(4, 2);
        g.addEdge(4, 3);
        g.addEdge(4, 5);
        g.addEdge(5, 3);
        g.addEdge(5, 4);
        
        g.printLists();
        System.out.println("Following is Breadth First Traversal "+ 
                           "(starting from vertex 0)"); 
  
        g.DFSRecursive(0); 
    }
}
class Graph {
    private int v;
    private LinkedList<Integer> adj[];
    private int[][] adjMatrix;
    public Graph(int v)
    {
        this.v=v;
        adj= new LinkedList[v];
        for (int i=0;i<v;i++)
        {
            adj[i]=new LinkedList<>();
        }
        
    }
    public Graph(int[][] adj)
    {
        adjMatrix=adj;
    }
    public void printLists()
    {
        for (LinkedList<Integer> linkedList : adj)
        {
            for (Integer integer : linkedList)
            {
                System.out.print(integer+" ");
            }
            System.out.println("");
        }
    }
    void addEdge(int s,int d)
    {
        adj[s].add(d);
    }
    
    void BFS(int s)
    {
        boolean[] visited= new boolean[v];
        LinkedList<Integer> q= new LinkedList<>();
        visited[s]=true;
        q.add(s);
        while(!q.isEmpty())
        {
            s=q.poll();
            System.out.println(s+" ");
            Iterator<Integer> i=adj[s].listIterator();
            while(i.hasNext())
            {
                int n=i.next();
                if(!visited[n])
                {
                    visited[n]=true;
                    q.add(n);
                }
            }
        }
    }
    void DFSRecursive(int s)
    {
        boolean[] visited=new boolean[v];
        DFSR(s,visited);
    }
    void DFSR(int s,boolean[] visited)
    {
        visited[s]=true;
        System.out.print(s+" ");
        for(int i=0;i<adj[s].size();i++)
        {
            if(!visited[adj[s].get(i)])
            {
                DFSR(adj[s].get(i),visited);
                
            }
        }
    }
    void DFS(int s)
    {
        boolean[] visited= new boolean[v];
        Stack<Integer> stack= new Stack<>();
        stack.push(s);
        visited[s]=true;
        System.out.print(s+" ");
        while(!stack.isEmpty())
        {
            s=stack.peek();
            boolean hasWay=false;
            for(int i=0;i<adj[s].size();i++)
            {
                if(!visited[adj[s].get(i)])
                {
                    hasWay=true;
                    visited[adj[s].get(i)]=true;
                    stack.push(adj[s].get(i));
                    System.out.print(adj[s].get(i)+" ");
                    break;
                }
            }
            if(hasWay==false)
            {
                stack.pop();
            }
            
        }
    }
}
