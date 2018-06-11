// A Java program to implement greedy algorithm for graph coloring
import java.io.*;
import java.util.*;
import java.util.LinkedList;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

// This class represents an undirected graph using adjacency list

// tao mot graph ket noi cac edge voi nhau : mang 1 chieu(danh sach lien ket don)
// doc file xuat ra mang 1 chieu
// add cac vi tri = 0 vao mang missed[]
// sovle() :
	//
class SudokuSolver 
{
    private Graph g;  
    private int cColored;
    int result[];
    public Writer fileOut;
	private List<Integer> missed = new ArrayList<>();
	private int posMissed = 0;
	
	public boolean solve(){
		if(missed.size() == posMissed)
			return true;
		
		for(int value = 1; value < 10; value++){
			int pos = missed.get(posMissed);
			if(check(pos, value)){
				result[pos] = value;
				posMissed++;
				if(solve()){
					return true;
				}
				else{
					result[pos] = 0;
				}
			}
		}
		posMissed--;
		return false;
	}
	public boolean check(int pos, int value){
			for(int j : g.getListAdj(pos)){
				if(value == result[j])
					return false;
			}
			return true;
	}
    //Constructor
    SudokuSolver(int v, String name)
    {
        cColored = 0;
        g = new Graph(v);
        result = new int[v];
        g.readGraph(name, result);
    }
    
    void GraphColoring(String output_name)
    {
        // Initialize remaining V-1 vertices as unassigned
        for (int u = 0; u < g.getV(); u++){
           if(result[u]==0)
				missed.add(u); // add nhung diem miss vao array missed
		}
       // Do something here 
	   solve();
	   writeSolvePuzzle(output_name);
    }
	
    public boolean writeSolvePuzzle(String output_name)
    {
            try{
	        fileOut = new FileWriter(output_name); 
	        int n  = 9;
	        for(int i=0 ;i < n; i++)
	              {
	                 for(int j=0 ;j < n; j++)
	                       fileOut.write(result[i*n + j] + " ");
	                 fileOut.write("\n");
	              }
	        fileOut.close();
	        return true;
              }
              catch(IOException e)
              {
                  System.out.println(e);
                  return false;
              }
    }
    
    public static void main(String args[])
    {
        SudokuSolver g1 = new SudokuSolver(81, args[0]);
        g1.GraphColoring(args[1]);
    }
}
// This code is contributed by Anh Vo 
