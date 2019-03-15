package previous2018;

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
	      String str1 = scan.next();
	      String str2 = scan.next();
	      int[][] matrix = new int[str1.length()+1][str2.length()+1];
	      
	      for(int j=1; j <=str1.length();j++)
	    	  for(int k=1; k <=str2.length(); k++)
	    	  {
	    		  if(str1.charAt(j-1)==str2.charAt(k-1))
	    		  {
	    			  matrix[j][k]= matrix[j-1][k-1]+1;
	    			  
	    		  }
	    		  else
	    		  {
	    			  if(matrix[j-1][k]>matrix[j][k-1])
	    			  {
	    				  matrix[j][k]=matrix[j-1][k];
	    			  }
	    			  else
	    			  {
	    				  matrix[j][k]=matrix[j][k-1];
	    			  }
	    		  }
	    	  }
	      int biggestStr= matrix[str1.length()][str2.length()];
	      
	      int result= str1.length()-biggestStr + str2.length()-biggestStr;
	      System.out.println(result);
	    }
	    scan.close();
	}
}
