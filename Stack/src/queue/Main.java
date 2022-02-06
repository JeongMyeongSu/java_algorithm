package queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		
		Queue<Integer> queue = new LinkedList();
		BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.parseInt(sc.readLine());
		StringTokenizer st;
		String input;
		int k = -1;
		
		for(int i=0;i<num;i++) {
			st = new StringTokenizer(sc.readLine());
			input = st.nextToken();
			switch(input) {
			case "push":
				k = Integer.parseInt(st.nextToken());
				queue.offer(k);
				break;
			case "pop":
				if(queue.isEmpty()) System.out.println(-1);
				else System.out.println(queue.poll());
				break;
			case "size":
				System.out.println(queue.size());
				break;
			case "empty":
				int x = queue.isEmpty() ? 1:0;
				System.out.println(x);
				break;
			case "front":
				if(queue.isEmpty()) System.out.println(-1);
				else System.out.println(queue.peek());
				break;
			case "back":
				int y = queue.size();
				if(queue.isEmpty()) System.out.println(-1);
				else System.out.println(k);
			}			
			
		}
		
	}

}
