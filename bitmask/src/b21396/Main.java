package b21396;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int i=0;i<T;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int x = Integer.parseInt(st.nextToken());
			int cnt=0;
			int[] arr = new int[n];
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<n;j++) {
				arr[j]=Integer.parseInt(st.nextToken());
			}
			for(int a=0;a<n;a++) {
				for(int b=a+1;b<n;b++) {
					if((arr[a]^arr[b])==x) cnt++;
				}
			}
			System.out.println(cnt);
		}
	}

}
