package previous2018;

import java.util.*;
import java.io.*;


public class ProblemA {

	public static void main(String[] args) throws FileNotFoundException 
	{
		File file = new File("input.txt");
		Scanner scan = new Scanner(file);
//	    PrintStream fileStream = new PrintStream("output.txt");
//	    System.setOut(fileStream);
	    int t = scan.nextInt();
	    
	    for (int i = 1; i <= t; ++i) 
	    {
	    	int max;
	    	int x = scan.nextInt();
	    	max=x;
	    	int y = scan.nextInt();
	    	if(y>max)
	    		max=y;
	    	int z = scan.nextInt();
	    	if(z>max)
	    		max=z;
	    	System.out.println(max);
	    }
	    scan.close();
	}
}