package b18352;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N, M, K, X;
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());
		
		int[] distance = new int[N+1];
		boolean[] visit = new boolean[N+1];
		ArrayList<ArrayList<Integer>> adjList = new ArrayList<ArrayList<Integer>>();
		adjList.add(new ArrayList<Integer>());
		for (int j=0; j<N;j++) {
			adjList.add(new ArrayList<Integer>());			
			distance[j] = Integer.MAX_VALUE;
		}
		for (int i = 0; i<M ; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			adjList.get(a).add(b);
		}
		
		int result = 0;
		distance[X] = 0;
		visit[X]=true;
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.offer(X);
		while(!queue.isEmpty()) {
			int tmp = queue.poll();
			for(int j:adjList.get(tmp)) {
				if (!visit[j]) {
					visit[j]=true;
					distance[j]=distance[tmp]+1;
					queue.offer(j);
				}
			}
		}
		int answer=0;
		for (int i=1; i<N+1;i++) {
			if (distance[i]==K) { System.out.println(i); answer++;}
		}
		if (answer == 0) System.out.println(-1);
	}
		
}
