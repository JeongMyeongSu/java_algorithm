package b12865;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	
	static int N,K;
	static ArrayList<Integer> weight = new ArrayList<Integer>();
	static ArrayList<Integer> value = new ArrayList<Integer>();
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		K = sc.nextInt();
		int[][] dp = new int[N+1][K+1];		
		weight.add(0);
		value.add(0);
		for(int i=0; i<N ; i++) {
			int w = sc.nextInt();
			int v = sc.nextInt();
			weight.add(w);
			value.add(v);
		}
		
		for(int i=1; i<=N;i++) {
			for(int j =1; j<=K ; j++) {
				if(weight.get(i)>j) {
					dp[i][j] = dp[i-1][j];
				} else {
					dp[i][j] = Math.max(dp[i-1][j-weight.get(i)]+value.get(i), dp[i-1][j]);
				}
			}
		}
		System.out.println(dp[N][K]);
	}

}
