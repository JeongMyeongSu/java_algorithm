package b9663;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;not

public class Main {
	static int N;
	static boolean[][] arr;
	static int answer=0;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new boolean[N][N];
		backtracking(0);
		System.out.println(answer);
	}
	
	public static void backtracking(int cnt) {
		if (cnt == N) {
			answer++;
			return;
		}
		for(int i=0; i<N;i++) {
			if (check(cnt,i)) {
				arr[cnt][i]=true;
				backtracking(cnt+1);
				arr[cnt][i]=false;
			}
		}
	}
	
	public static boolean check(int r,int c) {
		for(int i=0; i<N; i++) {
			if (arr[r][i]) return false;
			if (arr[i][c]) return false;
			int di = r+i;
			int dj = c+i;
			if (!(di>=N || di<0 || dj>=N || dj<0)) {
				if (arr[di][dj]) return false;
			}
			di = r-i;
			dj = c-i;
			if (!(di>=N || di<0 || dj>=N || dj<0)) {
				if (arr[di][dj]) return false;
			}
			di = r+i;
			dj = c-i;
			if (!(di>=N || di<0 || dj>=N || dj<0)) {
				if (arr[di][dj]) return false;
			}
			di = r-i;
			dj = c+i;
			if (!(di>=N || di<0 || dj>=N || dj<0)) {
				if (arr[di][dj]) return false;
			}
		}
		return true;
	}
}
