package b3187;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int R;
	static int C;
	static boolean[][] visit;
	static String[] earth;
	static int sheep;
	static int wolf;
	static int ans_sheep=0;
	static int ans_wolf=0;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		visit = new boolean[R][C];
		earth = new String[R];
		for(int i=0; i<R ; i++) {
			String row = br.readLine();
			earth[i] = row;			
		}
		for(int i=0;i<R;i++) {
			for(int j=0; j < C; j++) {
				sheep = 0;q
				wolf = 0;
				char t = earth[i].charAt(j);
				if (!visit[i][j] && t != '#') {
					DFS(i,j);
				}
				sheep =  sheep>wolf ? sheep : 0;
				wolf = sheep<=wolf ? wolf : 0;
				ans_sheep +=sheep;
				ans_wolf += wolf;
			}
		}
		System.out.print(ans_sheep+" ");
		System.out.print(ans_wolf);
	}
	static int[] dx = {0,0,1,-1};
	static int[] dy = {1,-1,0,0};
	
	static void DFS(int i,int j) {
		if (!visit[i][j]) {
			visit[i][j] = true;
			switch (earth[i].charAt(j)) {
			case 'v':
				wolf += 1;
				break;
			case 'k':
				sheep += 1;
				break;	
		}
		}
		for(int k=0;k<4;k++) {
			int di = i+dx[k];
			int dj = j+dy[k];
			if (di<0 || di>=R || dj<0 || dj>=C) break;
			if (!visit[di][dj]) {				
				visit[di][dj] = true;
				switch (earth[di].charAt(dj)) {
					case '#':
						break;
					case '.':
						DFS(di,dj);
						break;
					case 'v':
						wolf += 1;
						DFS(di,dj);
						break;
					case 'k':
						sheep += 1;
						DFS(di,dj);
						break;	
				}
			}
		}
	}

}
