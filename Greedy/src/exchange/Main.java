package exchange;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int money = 1000-sc.nextInt();
		int[] exchange = {500,100,50,10,5,1};
		int i = 0;
		int ans = 0;

		while (money>0) {
			int coin = money / exchange[i];
			ans += coin;
			money -= coin*exchange[i];
			i++;
		}
		System.out.println(ans);
			
	}

}
