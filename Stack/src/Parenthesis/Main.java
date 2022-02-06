package Parenthesis;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		Loop :
		for(int t=0; t<T; t++) {
			String tc = br.readLine();
			Stack<Integer> stack = new Stack<>();
			for (int i=0 ; i<tc.length();i++) {
				if (tc.charAt(i)=='(') {
					stack.push(0);
				}else if(tc.charAt(i)==')'){
					if (stack.isEmpty()) {
						System.out.println("NO");
						continue Loop;
					}else {
						stack.pop();
					}
				}
			}
			if (stack.isEmpty()) System.out.println("YES");
			else System.out.println("NO");
		}
	}

}
