package 세그먼트트리;
import java.io.*;
import java.util.*;

public class M1_추가1_세그먼트트리 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static long arr[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 }; // 실제 배열 값
	static long tree[]; // segment tree의 값을 저장할 배열
	private static int N;
	private static int M;

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		arr = new long[N + 1];
		tree = new long[(N+1) * 4];
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++)
			arr[i] = Integer.parseInt(st.nextToken());

		init(1, 1, N);
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			System.out.println(query(1, 1, N, s, e));
		}

	}

	private static long init(int node, int start, int end) {
		if (start == end) {
			return tree[node] = arr[start];
		}

		int mid = (start + end) / 2;
		long a = init(node * 2, start, mid);
		long b = init(node * 2 + 1, mid + 1, end);
		return tree[node] = a +  b;
	}

	private static long query(int node, int start, int end, int s, int e) {

		if (end < s || e < start)
			return 0;

		if (s <= start && end <= e)
			return tree[node];

		int mid = (start + end) / 2;
		long a = query(node * 2, start, mid, s, e);
		long b = query(node * 2 + 1, mid + 1, end, s, e);
		return a+ b;
	}

}