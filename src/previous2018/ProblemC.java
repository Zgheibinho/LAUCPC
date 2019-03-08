package previous2018;

import java.util.*;
import java.io.*;

public class ProblemC {

	public static void main(String[] args) throws FileNotFoundException 
	{
		File file = new File("input.txt");
		Scanner scan = new Scanner(file);
//	    PrintStream fileStream = new PrintStream("output.txt");
//	    System.setOut(fileStream);
	    int t = scan.nextInt();
	    for (int i = 1; i <= t; ++i) 
	    {
	      int h = scan.nextInt();
	      int m = scan.nextInt();
	      int s = scan.nextInt();
	      int extra = scan.nextInt();
	      
	      int total = h*60*60 + m*60 + s + extra;
	      
	      h= total/3600;
	      total-= (total/3600) *3600;
	      m =total/60;
	      total-= (total/60) *60;
	      s = total;
	      
	      System.out.println(h+" "+ m + " "+ s);
	    }
	    scan.close();
	}
}