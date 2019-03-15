package previous2018;

import java.util.*;
import java.io.*;

public class ProblemJ {

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
	      int[] nums = new int[n];
	      for (int j=0 ; j<n ; j++)
	      {
	    	nums[j]= scan.nextInt();
	      }
	      
	      int minindex=0;
	      int min= nums[0];
	      System.out.print(minindex+1);
	      for (int j=1 ; j<n ; j++)
	      {
	    	  if(nums[j]>min)
	    	  {
	    		  min=nums[j];
	    		  minindex=j;
	    		  System.out.print(" ");
	    		  System.out.print(j+1);
	    	  }
	      }
	      //System.out.println("Case #" + i + ": " + (n + m) + " " + (n * m));
	    }
	    scan.close();
	}
}
