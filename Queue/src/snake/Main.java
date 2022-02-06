package snake;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));
		int N = Integer.parseInt(br.readLine());
		int K = Integer.parseInt(br.readLine());
		int[][] arr = new int[N][N];
		for (int i=0;i<K;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			arr[a-1][b-1] = 1;
		}
		int L = Integer.parseInt(br.readLine());
		HashMap<Integer, String> hm = new HashMap<>();
		for(int i=0;i<L;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			String c = st.nextToken();
			hm.put(x, c);
		}
		int time=0;
		int[] dx = {-1,0,1,0};
		int[] dy = {0,1,0,-1};
		int nx = 0;
		int ny = 0;
		int dir = 1;
		Queue<Integer> q = new LinkedList<>();
		q.offer(0);
		while (true) {
			time++;
			nx = nx+dx[dir];
			ny = ny+dy[dir];
			if (nx<0 || nx>N-1 || ny<0 || ny>N-1) break;
			if (q.contains(nx*N+ny)) break;
			if (arr[nx][ny]==1) {
				arr[nx][ny]=0;
				q.offer(nx*N+ny);				
			}else {
				q.offer(nx*N+ny);
				q.poll();
			}
			
			if (hm.containsKey(time)) {
				String data = hm.get(time);
				if (data.equals("D")) {
					dir += 1;
					if (dir==4) dir = 0;
				}else {
					dir -= 1;
					if (dir == -1) dir = 3;
				}
			}		
		}
		System.out.println(time);
	}

}
