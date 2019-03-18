package codeforces;

import java.util.*;
import java.io.*;

public class ProblemE {

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
	      if(n%2 ==0)
	      {
	    	  n= - (n/2);
	    	  System.out.println(n);
	      }
	      else
	      {
	    	  n= n/2 +1;
	    	System.out.println(n);	  
	      }
	    }
	    scan.close();
	}
}
