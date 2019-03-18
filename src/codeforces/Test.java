package codeforces;

import java.util.*;
import java.io.*;

public class Test {

	public static void main(String[] args) throws FileNotFoundException 
	{
//		File file = new File("input.txt");
//		Scanner scan = new Scanner(file);
	    PrintStream fileStream = new PrintStream("input.txt");
	    System.setOut(fileStream);
	    Random r = new Random();
	    System.out.println(""+100000);
	    for (int i = 1; i <= 100000; ++i) 
	    {
	    	System.out.println( r.nextInt((100000) + 1));
	    }
	    System.out.println("");
	    System.out.println(""+100000);
	    for (int i = 1; i <= 100000; ++i) 
	    {
	    	System.out.println( r.nextInt((50000) + 1));
	    	System.out.println( r.nextInt((100000 - 50000) + 1) + 50000);
	    }
	}
}
