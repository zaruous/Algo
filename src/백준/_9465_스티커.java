package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _9465_스티커 {

	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static StringTokenizer sc;
	private static long[] d;
	private static int T;
	private static int N;
	private static int[][] arr;
	private static StringTokenizer sc1;
	private static StringTokenizer sc2;

	public static void main(String[] args) throws NumberFormatException, IOException {

		T = Integer.parseInt(br.readLine());

		for (int tcase = 1; tcase <= T; tcase++) {
			N = Integer.parseInt(br.readLine());
			arr = new int[N + 1][2];
			sc1 = new StringTokenizer(br.readLine());
			sc2 = new StringTokenizer(br.readLine());
			for (int i = 1; i <= N; i++) {
				arr[i][0] = Integer.parseInt(sc1.nextToken());
				arr[i][1] = Integer.parseInt(sc2.nextToken());
			}

			int[][] d = new int[N + 1][2];

			d[1][0] = arr[1][0];
			d[1][1] = arr[1][1];

			for (int x = 2; x <= N; x++) {
				d[x][0] = Math.max(Math.max(d[x - 2][0], d[x - 2][1]), d[x - 1][1]) + arr[x][0];
				d[x][1] = Math.max(Math.max(d[x - 2][0], d[x - 2][1]), d[x - 1][0]) + arr[x][1];
			}
			System.out.println(Math.max(d[N][0], d[N][1]));
		}

	}

}
