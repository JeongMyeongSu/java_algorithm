package stove;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		int ans=-1;
		int time;
		
		Scanner sc = new Scanner(System.in);
		time = sc.nextInt();
		
		if (time%10==0) {
			System.out.print(time/300+" ");
			time -= (time/300)*300;
			System.out.print(time/60+" ");
			time -= (time/60)*60;
			System.out.print(time/10);			
		}
		else System.out.println(-1);
	}

}
