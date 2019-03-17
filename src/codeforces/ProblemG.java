package codeforces;

import java.util.*;
import java.io.*;

public class ProblemG {

	public static void main(String[] args) throws FileNotFoundException 
	{
		File file = new File("input.txt");
		Scanner scan = new Scanner(file);
//	    PrintStream fileStream = new PrintStream("output.txt");
//	    System.setOut(fileStream);
		ArrayList<Long> nums = new ArrayList<Long>(10);
		nums.add(0, (long)1);
		for(int i=2; i<=1000000000;i++)
		{
			boolean done=false;
			int j=2;
			while(!done)
			{
				if((long)Math.pow(i, j)<(long)Math.pow(10,12))
				{
					//System.out.println((long)Math.pow(i, j));
					nums.add((long)Math.pow(i, j));
					j++;
				}
				else
				{
					done=true;
				}
			}
		}
		Set<Long> set = new HashSet<>(nums);
		nums.clear();
		nums.addAll(set);
		Collections.sort(nums);
	    //int t = scan.nextInt();
	    //for (int i = 1; i <= t; ++i) 
	    //{
	      int n = scan.nextInt();
	      System.out.println(nums.get(n-1));
	    //}2
	    scan.close();
	}
}
