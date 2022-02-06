package b11437;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static ArrayList<Integer>[] tree;
	static int[] depths;
	static int[] parents;
	
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		tree = new ArrayList[N+1];
		depths = new int[N+1];
		parents = new int[N+1];
		Arrays.fill(depths, -1);
		for(int i=0; i<N+1;i++) {
			tree[i] = new ArrayList<Integer>();
		}
		
		for(int i = 0 ; i<N-1; i++) {			
			StringTokenizer st = new StringTokenizer(br.readLine());
			int parent = Integer.parseInt(st.nextToken());
			int child = Integer.parseInt(st.nextToken());
			tree[parent].add(child);
			tree[child].add(parent);
		}
		DFS(1,0,0);


		int M = Integer.parseInt(br.readLine());
		for(int i=0;i<M;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			System.out.println(LCS(x,y));
		}
		
		
	}
	
	static void DFS(int now, int parent, int depth) {
		depths[now] = depth;
		parents[now] = parent;
		for(int child:tree[now]) {
			if(child != parent) {
				DFS(child,now,depth+1);
			}
		}
	}
	
	static int LCS(int x,int y) {
		while(depths[x]!=depths[y]) {
			if(depths[x]>depths[y]) x = parents[x];
			else y = parents[y];
		}
		while(x!=y) {
			x = parents[x];
			y = parents[y];
		}
		
		return x;
	}

}
