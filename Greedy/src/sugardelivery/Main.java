package sugardelivery;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		int bag;
		int total,remainder;		
		int answer=-1;
		int big_cnt,sm_cnt;
		
		Scanner sc = new Scanner(System.in);
		total = sc.nextInt();
		big_cnt = total/5;
		for(int i=0;i<=big_cnt;i++) {
			remainder = total - (big_cnt-i)*5;
			if (remainder%3==0) {
				answer = big_cnt-i+remainder/3;
				break;
			}
		}
		System.out.println(answer);
	}

}
