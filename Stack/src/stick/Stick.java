package stick;

import java.util.ArrayList;
import java.util.Scanner;

public class Stick {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		ArrayList<Integer> stares = new ArrayList<>();
		
		for (int i=0; i<num;i++) {
			stares.add(sc.nextInt());
		}
		
		int standard = stares.get(num-1);
		int answer = 1;
		
		for(int i=num-1;i>=0;i--) {
			if (standard < stares.get(i)) {
				answer++;
				standard = stares.get(i);				
			}
		}
		System.out.println(answer);
	}

}
