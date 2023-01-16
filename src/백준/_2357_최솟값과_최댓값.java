/********************************
 *	프로젝트 : Algo
 *	패키지   : 백준
 *	작성일   : 2023. 1. 16.
 *	작성자   : (zaruous@naver.com)
 *******************************/
package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 2357
 * 
 * @author (zaruous@naver.com)
 *
 */
public class _2357_최솟값과_최댓값 {

	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static StringTokenizer sc;
	private static int M;
	private static int N;
	private static long[] arr;
	private static long[] maxtree;
	private static long[] mintree;

	/**
	 * @작성자 : (zaruous@naver.com)
	 * @작성일 : 2023. 1. 16.
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		sc = new StringTokenizer(br.readLine());
		N = Integer.parseInt(sc.nextToken());
		M = Integer.parseInt(sc.nextToken());

		arr = new long[N + 1];
		maxtree = new long[((N + 1) * 4)];
		mintree = new long[((N + 1) * 4)];
		for (int i = 1; i <= N; i++) {
			int a = Integer.parseInt(br.readLine());
			arr[i] = a;
		}

		init0(1, 1, N);
		init1(1, 1, N);

		for (int i = 0; i < M; i++) {
			sc = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(sc.nextToken());
			int b = Integer.parseInt(sc.nextToken());
			long query0 = query0(1, 1, N, a, b);
			long query1 = query1(1, 1, N, a, b);
			System.out.println(query0 + " " + query1);
		}

	}

	private static long query0(int pos, int start, int end, int s, int e) {
		if (end < s || e < start)
			return Integer.MAX_VALUE;
		if (s <= start && end <= e)
			return mintree[pos];
		int mid = (start + end) / 2;
		long a = query0(pos * 2, start, mid, s, e);
		long b = query0(pos * 2 + 1, mid + 1, end, s, e);
		return Long.min(a, b);
	}

	private static long query1(int pos, int start, int end, int s, int e) {
		if (end < s || e < start)
			return 0;
		if (s <= start && end <= e)
			return maxtree[pos];
		int mid = (start + end) / 2;
		long a = query1(pos * 2, start, mid, s, e);
		long b = query1(pos * 2 + 1, mid + 1, end, s, e);
		return Long.max(a, b);
	}

	private static long init0(int pos, int left, int right) {
		if (left == right)
			return mintree[pos] = arr[left];

		int mid = (left + right) / 2;

		long a = init0(pos * 2, left, mid);
		long b = init0(pos * 2 + 1, mid + 1, right);

		return mintree[pos] = Long.min(a, b);
	}

	private static long init1(int pos, int left, int right) {
		if (left == right)
			return maxtree[pos] = arr[left];

		int mid = (left + right) / 2;

		long a = init1(pos * 2, left, mid);
		long b = init1(pos * 2 + 1, mid + 1, right);

		return maxtree[pos] = Long.max(a, b);
	}
}
