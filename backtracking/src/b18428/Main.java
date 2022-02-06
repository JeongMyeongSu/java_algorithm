package b18428;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

	static int N;
	static String[][] arr; 
	static Queue<teacher> teachers;
	
	static class teacher{
		int x,y;
		teacher(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new String[N][N];
		teachers = new LinkedList<teacher>();
		for(int i=0; i<N; i++) {
			String[] hang = br.readLine().split(" "); 
			for(int j=0;j<N;j++) {
				if (hang[j].equals("T")) {
					teachers.add(new teacher(i,j));
				}
				arr[i][j]=hang[j];
			}
		}
		backtracking(0);
		System.out.println("NO");
	}
	
	public static void backtracking(int cnt) {
		if (cnt == 3) {
			if(check()) {
				System.out.println("YES");
				System.exit(0);
			};
			return;
		}
		for(int i=0;i<N*N;i++) {
			int x = i/N;
			int y = i%N;
			if (arr[x][y].equals("X")) {
				arr[x][y] = "O";
				backtracking(cnt+1);
				arr[x][y] = "X";
			}
		}
	}
	static int[] dx = {0,0,1,-1};
	static int[] dy = {1,-1,0,0};
	public static boolean check() {
		for(teacher t:teachers) {
			if (!looking(t.x,t.y)) return false;
		}
		return true;
	}
	
	public static boolean looking(int x,int y) {
		Loop:
		for(int i=0; i<4; i++) {
			int p=1;
			while(p<N) {
				int di = x+dx[i]*p;
				int dj = y+dy[i]*p;
				if (di<0 || di>N-1 || dj<0 || dj>N-1) continue Loop;
				if (arr[di][dj].equals("O")) continue Loop;
				if (arr[di][dj].equals("S")) return false;
				p++;
			}
		}	
		return true;
	}

}
