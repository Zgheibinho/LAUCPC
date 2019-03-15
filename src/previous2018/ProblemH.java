package previous2018;

import java.util.*;
import java.io.*;

public class ProblemH {

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
	      int w = scan.nextInt();
	      int e = scan.nextInt();
//	      HashMap<Integer,Character> hmap = new HashMap<Integer,Character>(n+1);
//	      int[] nums = new int[n+1];
	      
	      int totalE=0;
	      int totalW=0;
	      for(int j=1; j<=n; j++)
	      {
	    	String str= scan.next();
	    	char kingdom=str.charAt(0);
	    	
	    	if(kingdom=='E')
	    	{
	    		totalE++;
//	    		int current=Integer.parseInt(str.substring(1, str.length()));
//	    		hmap.put(current, kingdom);
//	    		nums[j]=current;
	    	}
	    	else
	    	{
	    		totalW++;
//	    		int current=Integer.parseInt(str.substring(1, str.length()));
//	    		hmap.put(current, kingdom);
//	    		nums[j]= current;
	    	}
	      }
	      System.out.println(totalW);
	      System.out.println(totalE);
	      
	      
//	      System.out.println("Case #" + i + ": " + (n + m) + " " + (n * m));
	    }
	    scan.close();
	}
}