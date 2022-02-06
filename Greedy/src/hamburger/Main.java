package hamburger;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();
		String table = sc.next();
		boolean[] hamburgers = new boolean[N];
		
		int i=0;
		int answer=0;
		while(i<N) {
			if (table.charAt(i)=='P') {
				int start = i-K;
				int end = i+K;
				if (start<0) start = 0;
				if (end>N-1) end = N-1;
				for(int j=start;j<=end;j++) {
					if (table.charAt(j)=='H' && !hamburgers[j]) {
						hamburgers[j]=true;
						answer ++;
						break;
					}
				}
			}
			i++;
		}
		System.out.println(answer);
	}
}
