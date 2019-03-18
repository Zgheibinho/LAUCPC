package codeforces;

import java.util.*;
import java.io.*;

public class ProblemF {

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
	      System.out.println("Case #" + i + ": " + (n + m) + " " + (n * m));
	    }
	    scan.close();
	}
}
