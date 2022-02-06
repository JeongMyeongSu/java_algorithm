package b14502;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static int N;
	static int M;
	static int[][] arr;
	static int answer=0;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N][M];
		StringTokenizer in = null;
		for(int i=0; i<N; i++) {
			in = new StringTokenizer(br.readLine()," ");
			for(int j=0; j<M; j++) {
				arr[i][j] = Integer.parseInt(in.nextToken());
			}			
		}
		backtracking(0);
		System.out.println(answer);
	}
	
	static boolean[][] visit;
	public static void backtracking(int cnt) {
		if (cnt == 3) {
			int[][] copy = new int[N][M];
			visit = new boolean[N][M];
			for(int i=0;i<N;i++) {
				for(int j=0; j<M;j++) {
					copy[i][j]=arr[i][j];
				}
			}
			infection(copy);
			answer = Math.max(check(copy), answer);
			return;
		}
		for(int k=0; k<N*M ; k++) {
			int nx = k/M;
			int ny = k%M;
			if (arr[nx][ny]==0) {
				arr[nx][ny]=1;
				backtracking(cnt+1);
				arr[nx][ny]=0;
			}
		}
	}
	static class virus{
		int x,y;
		
		virus(int x,int y){
			this.x=x;
			this.y=y;
		}
	}
	public static void infection(int[][] arr) {
		Queue<virus> q = new LinkedList<virus>();
		for(int a=0; a<N; a++) {
			for(int b=0; b<M; b++) {
				if(arr[a][b]==2) q.add(new virus(a,b));
			}
		}
		while(!q.isEmpty()) {
			infection(arr, q.poll());
		}
	}
	static int[] dx = {0,0,1,-1};
	static int[] dy = {1,-1,0,0};
	
	public static void infection(int[][] arr, virus k) {
		int x = k.x;
		int y = k.y;
		
		for(int i=0; i<4; i++) {
			int di = x+dx[i];
			int dj = y+dy[i];
			if (di<0 || di>=N || dj<0 || dj>=M) continue;
			if (arr[di][dj]==0) {
				arr[di][dj]=2;
				infection(arr, new virus(di,dj));
			}
		}
	}
	
	public static int check(int[][] arr) {
		int safety = 0;
		for(int i=0;i<N;i++) {
			for(int j=0; j<M;j++) {
				if (arr[i][j]==0) safety++;
			}
		}
		return safety;
	}

}
