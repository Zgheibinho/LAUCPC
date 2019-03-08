package previous2018;

import java.util.*;
import java.io.*;

public class ProblemD {
	
	public static boolean isUpper(char c)
	{
		if(c>='a' && c<='z')
			return false;
		else
			return true;
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
	      String str = scan.next();
	      String bestRes="";
	      String currentRes=""+str.charAt(0);
	      
	      for (int j = 1;j < str.length(); ++j)
	      {
	    	if(isUpper(str.charAt(j)) == isUpper(currentRes.charAt(0)))
	    	{
	    		currentRes += str.charAt(j);
	    		if((currentRes.length()==bestRes.length())&&(isUpper(currentRes.charAt(0))))
    			{
    				bestRes = currentRes;
    			}
	    		
	    		if(currentRes.length()>bestRes.length())
	    			{
	    				bestRes = currentRes;
	    			}
	    	}
	    	else
	    	{
	    		currentRes=""+str.charAt(j);
	    		if((currentRes.length()==bestRes.length())&&(isUpper(currentRes.charAt(0))))
    			{
    				bestRes = currentRes;
    			}
	    	}
	    	//System.out.println(bestRes+" <- best current->"+currentRes +isUpper(currentRes.charAt(0))+(currentRes.length()==bestRes.length()));
	      }
	      System.out.println(bestRes);
	    }
	    scan.close();
	}
}