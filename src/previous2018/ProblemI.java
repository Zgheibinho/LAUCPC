package previous2018;

import java.util.*;
import java.io.*;

public class ProblemI {
	
	class Graph {

		//WEIGHTED
		//LinkedList<Node>[] list;
		
		LinkedList<Integer>[] list;
		public boolean hasCycle=false;
		public final int INFINITY = Integer.MAX_VALUE/2-1;
		public boolean isBipartite = false;
		
		
		@SuppressWarnings("unchecked")
		public Graph(int size) {
			list=new LinkedList[size+1];
			for(int i=1;i<=size;i++) {
				//WEIGHTED
				//list[i]=new LinkedList<Node>();
				list[i]=new LinkedList<Integer>();
			}
		}
		
//		WEIGHTED	
//		public void addEdge(int n1, int n2, int w) {
//			list[n2].add(new Node(n1,w));
//			list[n1].add(new Node(n2,w));
//		}
		
		public void addEdge(int n1, int n2) {
			if(!(list[n2].contains(n1)))
			{	
			list[n2].add(n1);
			list[n1].add(n2);
			}
		}
		public void print() {
			for(int i=1;i<list.length;i++) {
				System.out.println(list[i].toString());
			}
		}
		public void DFS(int node) {
			boolean[] visited=new boolean[list.length];
			DFSUtil(node,visited);
		}
		private void DFSUtil(int node,boolean[] visited) {
			System.out.println(node);
			visited[node]=true;
			ListIterator<Integer> iter=list[node].listIterator();
			while(iter.hasNext()) {
				int neighbor=iter.next();
				if(visited[neighbor]==false) {
					DFSUtil(neighbor,visited);
				}
			}
		}
		
		public boolean cycle(int node) {
			boolean[] visited=new boolean[list.length];
			HashMap<Integer, Integer> hmap = new HashMap<Integer, Integer>();
			hasCycle=false;
			cycleUtil(node,visited,hmap);
			boolean result=hasCycle;
			hasCycle=false;
			return result;
		}
		
		private void cycleUtil(int node,boolean[] visited,HashMap<Integer,Integer> hmap) {
			visited[node]=true;
			ListIterator<Integer> iter=list[node].listIterator();
			while(iter.hasNext()) 
			{
				int neighbor=iter.next();
				if(visited[neighbor]==false) {
					if(!hmap.containsKey(neighbor))
						hmap.put(neighbor,node);
					cycleUtil(neighbor,visited,hmap);
				}
				else
				{
					if(hmap.containsKey(node))
					{
						if(hmap.get(node)!=neighbor)
						{
							hasCycle=true;
						}
					}
				}
			}
		}
		
		
		public boolean bipartite(int node) {
			boolean[] visited=new boolean[list.length];
			HashMap<Integer, Integer> hmap = new HashMap<Integer, Integer>();
			isBipartite=true;
			bipartiteUtil(node,visited,hmap,0);
			for(int i=1; i<visited.length;i++)
			{
				
				if(visited[i]==false)
				{
					HashMap<Integer, Integer> hmap2 = new HashMap<Integer, Integer>();
					System.out.println(i);
					bipartiteUtil(i,visited,hmap2,0);
				}
			}
			
			boolean result=isBipartite;
			isBipartite=true;
			return result;
		}
		
		private void bipartiteUtil(int node,boolean[] visited,HashMap<Integer,Integer> hmap, int oddoreven) {
			oddoreven++;
			visited[node]=true;
			ListIterator<Integer> iter=list[node].listIterator();
			while(iter.hasNext()) 
			{
				int neighbor=iter.next();
				if(visited[neighbor]==false) {
					if(!hmap.containsKey(neighbor))
						hmap.put(neighbor,node);
					bipartiteUtil(neighbor,visited,hmap,oddoreven);
				}
				else
				{
					if(hmap.containsKey(node))
					{
						if(hmap.get(node)!=neighbor)
						{
							if(oddoreven%2 ==1)
							isBipartite=false;
						}
					}
				}
			}
		}
		
		
		public void Bfs(int index)
		{
			Queue<Integer> Q = new LinkedList<Integer>();
			boolean[] visited= new boolean[list.length];
			
			visited[index]=true;
			System.out.print(index+"-");
			
			Q.offer(index);
			
			while(!Q.isEmpty())
			{
				int current_index=Q.poll();
				ListIterator<Integer> iter=list[current_index].listIterator();
				
				while(iter.hasNext()) {
					int neighbor=iter.next();
					if(visited[neighbor]==false) {
						Q.offer(neighbor);
						System.out.print(neighbor +"-");
						visited[neighbor]=true;
					}
				}
		
			}
		}
		
		
		
		public int connectedComponents(int node,int count) {
			boolean[] visited=new boolean[list.length];
			DFSUtil(node,visited);
			count++;
			for(int i=1; i<visited.length;i++)
			{
				if(visited[i]==false)
				{
					count++;
					DFSUtil(i,visited);
				}
			}
			return count;
		}

		// WEIGHTED
//		public void Dijkstra(int root, int target)
//		{
//			int[] dist= new int[list.length];
//			int[] parent = new int[list.length];
//			boolean[] visited= new boolean[list.length];
//			Arrays.fill(dist,Integer.MAX_VALUE-1);
//			Arrays.fill(parent,Integer.MAX_VALUE-1);
//			Arrays.fill(visited,false);
//			
//			dist[root]=0;
//			parent[root]=root;
//			ListIterator<Node> iter=list[root].listIterator();
//			
//			while(iter.hasNext()) {
//				Node neighbor=iter.next();
//				dist[neighbor.getInfo()]= neighbor.getWeight();
//				parent[neighbor.getInfo()]=root;
//			}
//			visited[root]=true;
//			int count=0;
//			while(count<list.length-1)
//			{
//				int min = Integer.MAX_VALUE;
//				int indexmin= Integer.MAX_VALUE;
//				for(int i=0;i<dist.length;i++)
//				{
//					if(dist[i]<min && visited[i]==false)
//					{
//						min=dist[i];
//						indexmin=i;
//					}
//				}
//				ListIterator<Node> iter2=list[indexmin].listIterator();
//				while(iter2.hasNext()) 
//				{
//					Node neighbor=iter2.next();
//					if(dist[neighbor.getInfo()]<dist[indexmin] || dist[neighbor.getInfo()]==Integer.MAX_VALUE-1)
//					{
//						if(dist[neighbor.getInfo()]!=Integer.MAX_VALUE-1)
//						{	
//						dist[neighbor.getInfo()]+=dist[indexmin];
//						parent[neighbor.getInfo()] = indexmin;
//						}
//						else
//						{
//							dist[neighbor.getInfo()] =dist[indexmin];
//							parent[neighbor.getInfo()] = indexmin;
//						}
//					}
//				}
//				count++;
//				visited[indexmin]=true;
//			}
//			System.out.println("weight of shortest path is: "+ dist[target]);
//			
//		}
		
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
	      
	      ProblemI test = new ProblemI();
	      Graph g= test.new Graph(n);
	      
	      for(int j=1; j<= m; j++)
	      {
	    	  int n1= scan.nextInt();
	    	  int n2= scan.nextInt();
	    	  
	    	  g.addEdge(n1, n2);
	      }
	      
	      if(g.bipartite(1))
	      {
	    	  System.out.println("YES");
	      }
	      
	      else
	      {
	    	  System.out.println("NO");
	      }
	      
	    }
	    scan.close();
	}
}

