package codeforces;

import java.util.*;
import java.io.*;

public class ProblemB {
	
	class Event implements Comparable<Event>
	{
		int left;
		int right;
		int qu;
		public Event(int l, int r, int q)
		{
		left=l;
		right=r;
		qu=q;
		}
		
		public int compareTo(Event e)
		{
			if(this.right>e.right)
			{
				return 1;
			}
			else if(this.right<e.right)
			{
				return -1;
			}
			else
				return 0;
		}
		public String toString()
		{
			return "lrq "+left+" "+right+" "+ qu;
		}
		
	}

	public static void main(String[] args) throws FileNotFoundException 
	{
		File file = new File("input.txt");
		Scanner scan = new Scanner(file);
//	    PrintStream fileStream = new PrintStream("output.txt");
//	    System.setOut(fileStream);
	    int t = scan.nextInt();
	    ProblemB p = new ProblemB();
	    Event[] arr = new Event[t];
	    for (int i = 1; i <= t; ++i) 
	    {
	      int l = scan.nextInt();
	      int r = scan.nextInt();
	      int q = scan.nextInt();
	      
	      arr[i-1]=p.new Event(l,r,q);
	      //System.out.println("Case #" + i + ": " + (n + m) + " " + (n * m));
	    }
	    Arrays.sort(arr);
	    int[] food = new int[t];
	    for(int i=0; i<arr.length;i++)
	    	food[i]=arr[i].qu;
	    for(int i=1; i<arr.length;i++)
	    	for(int j =0;j<i;j++)
	    	{
	    		if(arr[i].left >= arr[j].right)
	    		{
	    			food[i]= Math.max(food[i], food[j]+arr[i].qu);
	    		}
	    	}
	    System.out.println(food[t-1]);
	    scan.close();
	}
}