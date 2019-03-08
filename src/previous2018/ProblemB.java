package previous2018;

import java.util.*;
import java.io.*;

public class ProblemB {
	
	public static String printPos(int n)
	{
		if (n==1)
		{
			return "1st";
		}
		if (n==2)
		{
			return "2nd";
		}
		if (n==3)
		{
			return "3rd";
		}
		else
			return n+"th";
	}

	public static void main(String[] args) throws FileNotFoundException 
	{
		HashMap<Integer,Integer> h;
		HashMap<Integer,Integer> h2;
		File file = new File("input.txt");
		Scanner scan = new Scanner(file);
//	    PrintStream fileStream = new PrintStream("output.txt");
//	    System.setOut(fileStream);
	    int t = scan.nextInt();
	//    System.out.println("t: "+ t);
	    for (int i = 1; i <= t; ++i) 
	    {
	    	int n = scan.nextInt();
	  //  	System.out.println("n: "+ t);
	    	h= new HashMap<Integer,Integer>(n);
	    	h2= new HashMap<Integer,Integer>(n);
	    	for (int j = 1; j <= n; ++j)
	    	{
	    		int current=scan.nextInt();
	    //		System.out.println("current "+current);
	    		h.put(current,j);
	    	}
	    	for (int j = 1; j <= n; ++j)
	    	{
	    		int current=scan.nextInt();
	    		h2.put(current,j);
	    	}
	    	for (int j = 1; j <= n; ++j)
	    	{
	    		int n1= h.get(j);
	    		int n2= h2.get(j);
	    		if(n1 != n2)
	    			System.out.println("team "+j+" moved from "+printPos(n1)+" position to "+printPos(n2)+" position");
	    		else
	    			System.out.println("team "+j+" stayed at "+printPos(n1)+" position");	
	    	}
	    }
	    scan.close();
	}
}