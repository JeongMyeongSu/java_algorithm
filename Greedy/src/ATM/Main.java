package ATM;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String num = in.readLine();
		long answer=0L;
		String tem;
		int temp;
		tem = num;
		
		for (int i=0;i<num.length();i++) {
			tem = tem.substring(1,num.length())+tem.charAt(0);
			temp = Integer.parseInt(tem);
			answer += temp;
		}
		System.out.println(answer);
		
	}
}
