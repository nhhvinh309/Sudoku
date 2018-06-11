// A Java program to implement graph coloring
import java.io.*;
import java.util.*;
import java.util.LinkedList;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

// This class represents an undirected graph using adjacency list
class Graph
{
    private int V;   // No. of vertices
    private LinkedList<Integer> adj[]; //Adjacency List
    
    //Constructor
    Graph(int v)
    {
        V = v;
       
        adj = new LinkedList[v];
        for (int i=0; i<v; ++i)
            adj[i] = new LinkedList();
    }
    
    //Function to add an edge into the graph
    void addEdge(int v,int w)
    {
        adj[v].add(w);
        adj[w].add(v); //Graph is undirected
    }
    public int getV()
    {
    	return V;
    }
    public void printGraph()
    {
          
          for(int i=0; i<V; i++)
          {
              System.out.print(i + ": ");
              Iterator<Integer> itr=adj[i].iterator();  
              while(itr.hasNext()){  
                             System.out.print(itr.next() + " ");  
               }
               System.out.print(" - Size: " + adj[i].size() + "  ");
               System.out.println();
           }  
    }
    public LinkedList<Integer> getListAdj(int u)
    {
    	return adj[u];
    }
    public boolean readGraph(String input_name, int result[])
    {
		try{
			Scanner fileReader = new Scanner(new File(input_name));
			int v = 0;
			while(fileReader.hasNextInt()){
				result[v] = fileReader.nextInt();
				v++;
			}
			 
			for(int i = 0; i < result.length; i++){
				LinkedList<Integer> newConect = new LinkedList<>();
				for(int j = i+1; j < result.length; j++){
					if((i%9 == j%9 || i/9 == j/9 ||
							i/9/3*3 + i%9/3 == j/9/3*3 + j%9/3) && 
								i != j){
						addEdge(i,j);
					}
				}
			}
		}
		catch(Exception e){System.out.println(e);};
        return true;
    }
    
}
// This code is contributed by Anh Vo 
