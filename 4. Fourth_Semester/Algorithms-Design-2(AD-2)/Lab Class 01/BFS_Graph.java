import java.util.*;
class Graph{
	int n;
	LinkedList<Integer>[] adjL;
	Graph(int n){
		this.n=n;
		adjL=new LinkedList[n];
		for(int i=0;i<n;i++) {
			adjL[i]=new LinkedList<Integer>();
		}
	}
	
	public void addEdge(int src,int dest) {
		adjL[src].add(dest);
		adjL[dest].add(src);
	}
	
	public void BFSAll() {
		boolean[] visited=new boolean[n];
		for(int i=0;i<n;i++) {
			if(!visited[i])
				BFSTraversal(i,visited);
		}
	}
	public void BFSTraversal(int start,boolean[] visited) {
		Queue<Integer> q=new LinkedList<Integer>();
		
		q.add(start);
		
		while(!q.isEmpty()) {
			int head=q.poll();
			System.out.print(head+" ");
			visited[head]=true;
			for(int neighbors:adjL[head]) {
				if(!visited[neighbors])
					q.add(neighbors);
			}
		}
	}
	
	public void dfsAll() {
		boolean[] visited=new boolean[n];
		for(int i=0;i<n;i++) {
			if(!visited[i])
				dfsUtil(i,visited);
		}
	}
	public void dfsUtil(int v,boolean[] visited) {
		visited[v]=true;
		System.out.print(v+" ");
		for(int neighbor:adjL[v]) {
			if(!visited[neighbor])
				dfsUtil(neighbor,visited);
		}
	}
}

public class BFS {
	public static void main(String[] args) {
        int numVertices = 7;
        Graph graph = new Graph(numVertices);
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 3);
        graph.addEdge(2, 4);
        graph.addEdge(5, 6);

        System.out.println("Breadth-First Search (BFS):");
        graph.dfsAll();
    }
}
