package fastway;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {

	static int answer,D;
	static ArrayList<int[]> list = new ArrayList<int[]>();
	
	public static void main(String[] args) throws IOException {		
		int N;
		answer = Integer.MAX_VALUE;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());
		for(int i=0; i<N;i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			if (b<=D) {
				if (b-a>c) {
					list.add(new int[] {a,b,c});
				}
			}	
		}
		go(0,0);
		System.out.println(answer);		
	}
	
	static void go(int v,int dist) {
		if(dist>=answer) return;
		if(v==D) {
			answer = dist;
		}
		for(int i=0; i<list.size();i++) {
			int[] p = list.get(i);
			if (p[0]==v) go(p[1],p[2]+dist);
		}
		go(v+1,dist+1);
	}

}
