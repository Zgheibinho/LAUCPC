package previous2018;

import java.util.*;
import java.io.*;

public class ProblemK {
	
	class Graph {

		int[][] matrix;
		long[] values;
		
		public Graph(int size) 
		{
			matrix = new int[size+1][size+1];
			values = new long[size+1];
		}
		
		public void addEdge(int n1,int n2)
		{
			if(n1!=n2)
			{
			matrix[n1][n2]=1;
			matrix[n2][n1]=1;
			}
		}
		
		public void printvalue(int n1)
		{
			long result=0;
			for(int i=0; i<values.length;i++)
			{
				if(matrix[n1][i]==1)
				{
					result+= values[i];
				}
			}
			System.out.println(result);
		}
		
		public void addValue(int n1, int amount)
		{
			values[n1]+=amount;
		}
	}

	public static void main(String[] args) throws FileNotFoundException 
	{
		File file = new File("input.txt");
		Scanner scan = new Scanner(file);
//	    PrintStream fileStream = new PrintStream("output.txt");
//	    System.setOut(fileStream);
	    int t = scan.nextInt();
	    for (int i = 1; i <= t; ++i) 
	    {
	      int n = scan.nextInt();
	      int m = scan.nextInt();
	      ProblemK k = new ProblemK();
	      Graph g = k.new Graph(n);
	      for(int j=1; j<=n-1;j++)
	      {
	    	int n1 = scan.nextInt();
	    	int n2 = scan.nextInt();
	    	 g.addEdge(n1, n2);
	      }
	      
	      for(int j=1;j<=m;j++)
	      {
	    	int choice = scan.nextInt();
	    	if(choice==1)
	    	{
	    		int n1 = scan.nextInt();
	    		g.printvalue(n1);
	    	}
	    	else
	    	{
	    		int n2 = scan.nextInt();
	    		int amount = scan.nextInt();
	    		g.addValue(n2, amount);
	    	}
	      }
	    }
	    scan.close();
	}
}
