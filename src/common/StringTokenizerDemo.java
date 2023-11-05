package common;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class StringTokenizerDemo {

	public static void main(String[] args) throws NumberFormatException, IOException {
		long startTime = System.currentTimeMillis();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		long[] sort = new long[n];
		String s = br.readLine();
		StringTokenizer st = new StringTokenizer(s, " ");
		int i = 0;
		while (st.hasMoreTokens()) {
			sort[i] = Long.parseLong(st.nextToken());
		}
		long endTime = System.currentTimeMillis();
		long totalTime = endTime - startTime;
		System.out.println(totalTime);
	}

}
