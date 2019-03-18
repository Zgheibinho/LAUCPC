package codeforces;

import java.util.*;
import java.io.*;

public class ProblemD {

	public static void main(String[] args) throws FileNotFoundException 
	{
		File file = new File("input.txt");
		Scanner scan = new Scanner(file);
		int[]arr;
	    PrintStream fileStream = new PrintStream("output.txt");
	    System.setOut(fileStream);
	    int t = scan.nextInt();
	    int[] nums= new int[t+1];
	    for (int i = 1; i <= t; ++i) 
	    {
	      int n = scan.nextInt();
	      nums[i]=n;
	    }
	    int q = scan.nextInt();
	    for (int i = 1; i <= q; ++i) 
	    {
	    	boolean flag = false;
	      int l = scan.nextInt() ;
	      int r = scan.nextInt();
	      arr = new int[r-l+1];
	      for( int j=l ; j<=r ;j++)
	      {
	    	  arr[j-l]=nums[j];
	      }
	      Arrays.sort(arr);
	      for(int j=0; j<arr.length-2; j++)
	      {
	    	  if (arr[j+2]< arr[j]+ arr[j+1])
	    	  {
	    		  flag = true;
	    		  break;
	    	  }
	      }
	      if(flag)
		    {
		    	System.out.println("YES");
		    }
		    else
		    {
		    	System.out.println("NO");
		    }
		 
	    }
	    
	    scan.close();
	}
}