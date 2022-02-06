package bird;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Vector;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		Vector<Queue<String>> qArray = new Vector<Queue<String>>();
		for(int i = 0;i<N;i++) {
			String str = br.readLine();
			String[] q = str.split(" ");
			Queue queue = new LinkedList<String>();
			qArray.add(queue);
			for(int j=0;j<q.length;j++) {
				qArray.get(i).offer(q[j]);
			}
		}		
		String res = br.readLine();
		String[] result = res.split(" ");
		Boolean flag = false;
		Loop:
		for(int i=0; i<result.length;i++) {
			String c = result[i];
			for(int j=0;j<qArray.size();j++) {
				if (c.equals(qArray.get(j).peek())) {
					qArray.get(j).poll();
					continue Loop;
				}
			}
			System.out.println("Impossible");
			flag=true;
			break;
		}
		if(!flag) {
			Boolean flag2 = false;
			for (int i=0; i<qArray.size();i++) {
				if(!qArray.get(i).isEmpty()) {
					flag2=true;
					System.out.println("Impossible");
				}
			}
			if(!flag2) System.out.println("Possible");			
		}
	}

}
