package UcpcSolution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		String str = in.readLine();
		
		StringBuilder ans = new StringBuilder();
		
		for (int i=0;i<str.length();i++) {
			if (str.charAt(i)-'A'>=0 && str.charAt(i)-'A'<=25) {
				ans.append(str.charAt(i));
			}
		}
		
		int j =0;
        for(int i=0; i<ans.length(); i++) {
            if(j==0 && ans.charAt(i)=='U') {
                j+=1;
            }
            if((j==1 || j==3) && ans.charAt(i)=='C') {
                j+=1;
            }
            if(j==2 && ans.charAt(i)=='P') {
                j+=1;
            }
        }
        if (j==4) {
        	System.out.println("I love UCPC");
        }else {
        	System.out.println("I hate UCPC");
        }
	}

}
