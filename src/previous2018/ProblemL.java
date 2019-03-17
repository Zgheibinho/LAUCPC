package previous2018;

import java.util.*;
import java.io.*;

public class ProblemL {
	
	 class Node 
	 {
		private int info;
		private double weight;
		
		public Node(int inf,double w)
		{
			info=inf;
			weight = w;
		}
		
		public int getInfo() 
		{
			return info;
		}
		public void setInfo(int info) 
		{
			this.info = info;
		}
		public double getWeight() 
		{
			return weight;
		}
		public void setWeight(double weight) 
		{
			this.weight = weight;
		}
		public String toString()
		{
			return "info: "+info+"  weight:"+weight;
		}
	}
	
	class Graph {

		//WEIGHTED
		LinkedList<Node>[] list;
		
//		LinkedList<Integer>[] list;
		public boolean hasCycle=false;
		public final int INFINITY = Integer.MAX_VALUE/2-1;
		
		@SuppressWarnings("unchecked")
		public Graph(int size) {
			list=new LinkedList[size];
			for(int i=0;i<size;i++) {
				//WEIGHTED
				list[i]=new LinkedList<Node>();
//				list[i]=new LinkedList<Integer>();
			}
		}
		
//		WEIGHTED	
		public void addEdge(int n1, int n2, double w) {
			//list[n2].add(new Node(n1,w));
			list[n1].add(new Node(n2,w));
		}
		
//		public void addEdge(int n1, int n2) {
//			list[n2].add(n1);
//			list[n1].add(n2);
//		}
		public void print() {
			for(int i=0;i<list.length;i++) {
				System.out.println(list[i].toString());
			}
		}
//		public void DFS(int node) 
//		{
//			boolean[] visited=new boolean[list.length];
//			DFSUtil(node,visited);
//		}
//		private void DFSUtil(int node,boolean[] visited) {
//			System.out.println(node);
//			visited[node]=true;
//			ListIterator<Node> iter=list[node].listIterator();
//			while(iter.hasNext()) {
//				int neighbor=iter.next();
//				if(visited[neighbor]==false) {
//					DFSUtil(neighbor,visited);
//				}
//			}
//		}
//		
//		public boolean cycle(int node) {
//			boolean[] visited=new boolean[list.length];
//			HashMap<Integer, Integer> hmap = new HashMap<Integer, Integer>();
//			hasCycle=false;
//			cycleUtil(node,visited,hmap);
//			boolean result=hasCycle;
//			hasCycle=false;
//			return result;
//		}
//		
//		private void cycleUtil(int node,boolean[] visited,HashMap<Integer,Integer> hmap) {
//			visited[node]=true;
//			ListIterator<Integer> iter=list[node].listIterator();
//			while(iter.hasNext()) 
//			{
//				int neighbor=iter.next();
//				if(visited[neighbor]==false) {
//					if(!hmap.containsKey(neighbor))
//						hmap.put(neighbor,node);
//					cycleUtil(neighbor,visited,hmap);
//				}
//				else
//				{
//					if(hmap.containsKey(node))
//					{
//						if(hmap.get(node)!=neighbor)
//						{
//							hasCycle=true;
//						}
//					}
//				}
//			}
//		}
//		
//		public void Bfs(int index)
//		{
//			Queue<Integer> Q = new LinkedList<Integer>();
//			boolean[] visited= new boolean[list.length];
//			
//			visited[index]=true;
//			System.out.print(index+"-");
//			
//			Q.offer(index);
//			
//			while(!Q.isEmpty())
//			{
//				int current_index=Q.poll();
//				ListIterator<Integer> iter=list[current_index].listIterator();
//				
//				while(iter.hasNext()) {
//					int neighbor=iter.next();
//					if(visited[neighbor]==false) {
//						Q.offer(neighbor);
//						System.out.print(neighbor +"-");
//						visited[neighbor]=true;
//					}
//				}
//		
//			}
//		}
//		
//		
//		
//		public int connectedComponents(int node,int count) {
//			boolean[] visited=new boolean[list.length];
//			DFSUtil(node,visited);
//			count++;
//			for(int i=0; i<visited.length;i++)
//			{
//				if(visited[i]==false)
//				{
//					count++;
//					DFSUtil(i,visited);
//				}
//			}
//			return count;
//		}

		// WEIGHTED
		public double Dijkstra(int source, int destination)
		{
			double[] dist= new double[list.length];
			boolean[] visited = new boolean[list.length];
			int[] parent = new int[list.length];
			Arrays.fill(visited, false);
			Arrays.fill(dist, Integer.MIN_VALUE+5);
			Arrays.fill(parent, -1);
			
			//Initialization
			dist[source]=1;
			parent[source]=source;
			//relax source
			ListIterator<Node> iter = list[source].listIterator();
			while(iter.hasNext())
			{
				Node neighbor = iter.next();
				//System.out.println("hello "+dist[source] * neighbor.getWeight());
				if( dist[neighbor.getInfo()] < (dist[source] * neighbor.getWeight()))
				{
					dist[neighbor.getInfo()] = (dist[source] * neighbor.getWeight());
					parent[neighbor.getInfo()] = source;
					//System.out.println(neighbor.getInfo()+" hello"+ dist[neighbor.getInfo()]);
				}
			}
			
			visited[source]=true;
			
			for(int i=1 ; i<list.length; i++)
			{
				//for every vertex except source because it is already updated
				
				//extract max
				int minindex=-1;
				double min=Integer.MIN_VALUE;
				for(int j=0; j<dist.length;j++)
				{
					if((visited[j]==false)&&(dist[j]>min))
					{
						minindex=j;
						min=dist[j];
					}
				}
				
				//relax min
				iter=list[minindex].listIterator();
				while(iter.hasNext())
				{
					Node neighbor = iter.next();
					if( dist[neighbor.getInfo()] < (dist[minindex] * neighbor.getWeight()))
					{
						//vertex relaxation , if gives a better path update
						dist[neighbor.getInfo()] = (dist[minindex] * neighbor.getWeight());
						parent[neighbor.getInfo()] = minindex;
					}
				}
				visited[minindex]=true;
			}
			if(dist[destination]<Integer.MIN_VALUE+10)
			{
				dist[destination]=0;
			}
			
			return dist[destination];
		}
		

		
//		public Graph prims()
//		{
//			
//		}
		
		
		
		
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
	      int n = scan.nextInt();
	      int m = scan.nextInt();
	      ProblemL p = new ProblemL();
	      Graph g = p.new Graph(n);
	      for(int j =1 ; j<=m;j++)
	      {
	    	  int n1 = scan.nextInt() -1;
	    	  int n2 = scan.nextInt() -1;
	    	  double w = scan.nextDouble();
	    	  
	    	  g.addEdge(n1, n2, w);
	      }
	      
	      System.out.println(g.Dijkstra(0, n-1));
	      
	    }
	    scan.close();
	}
}
