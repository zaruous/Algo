package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _2748_피보나치의수 {

	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static StringTokenizer sc;
	private static long[] d;

	public static void main(String[] args) throws NumberFormatException, IOException {

		int n = Integer.parseInt(br.readLine());
		d = new long[n + 1];

		d[0] = 0;
		d[1] = 1;

		for (int i = 2; i <= n; i++) {
			d[i] = d[i - 1] + d[i - 2];
		}
		System.out.println(d[n]);
	}

}
