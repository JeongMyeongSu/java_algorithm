package b17298;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		ArrayList<Integer> numbers = new ArrayList<Integer>(); 
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i<N ; i++) {
			numbers.add(Integer.parseInt(st.nextToken()));	
		}
		
		Stack<Integer> stack = new Stack<>();
		int[] answer = new int[N];
		Arrays.fill(answer, -1);
		
		stack.push(numbers.get(0));
		for (int i=1; i < N; i++) {
			int newnum = numbers.get(i);
			if (stack.isEmpty() || stack.peek()>=newnum) {
				stack.push(newnum);
			}else {
				int j = i-1;
				while(!stack.isEmpty() && stack.peek()<newnum) {
					stack.pop();
					answer[j--] = newnum;
				}				
				stack.push(newnum);
			}
		}
		
	
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		for(int i=0;i<N;i++) {
			bw.write(answer[i]+" ");
		}
		bw.write("\n");
		bw.flush();
	}
}
