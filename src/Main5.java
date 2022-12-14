import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.StringTokenizer;

/**
 * 
 * 
 * @author KYJ (callakrsos@naver.com)
 *
 */
public class Main5 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static int T;
	private static StringTokenizer sc;
	private static int N;
	private static int W;
	private static int[] arr;
	private static int M;
	private static int R;
	private static int K;
	private static int[][] board;
	private static int P;
	static ArrayList<Integer>[] arrayList;

	public static void main(String[] args) throws IOException {
		sc = new StringTokenizer(br.readLine());

		// 도시
		N = Integer.parseInt(sc.nextToken());
		// 도로
		M = Integer.parseInt(sc.nextToken());
		// 남은기름통 칸수
		K = Integer.parseInt(sc.nextToken());
		// 출발도시
		P = Integer.parseInt(sc.nextToken());

		arrayList = new ArrayList[N + 1];
		for (int i = 1; i <= N; i++) {
			arrayList[i] = new ArrayList<Integer>();
		}

		// board = new int[N + 1][N + 1];
		for (int i = 0; i < M; i++) {
			sc = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(sc.nextToken());
			int b = Integer.parseInt(sc.nextToken());
			// board[a][b] = 1;
			arrayList[a].add(b);
			// arrayList.add(new Node(a, b));
		}
		for (int i = 1; i <= N; i++) {
			arrayList[i].sort(Comparator.naturalOrder());
		}

		LinkedList<Integer> q = new LinkedList<Integer>();
		q.add(P);

		int depth = 1;
		if (q.isEmpty()) {
			System.out.println("-1");
			return;
		}

		boolean found = false;
		while (!q.isEmpty()) {
			Integer poll = q.poll();

			ArrayList<Integer> arr = arrayList[poll];
			for (Integer y : arr) {
				if (depth == K) {
					System.out.println(y);
					found = true;
					continue;
				}
				q.add(y);
			}
			
			depth++;
		}
		if (!found) {
			System.out.println("-1");
		}
	}

}
