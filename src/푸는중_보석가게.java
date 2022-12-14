import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * 
 * 
 * @author KYJ (callakrsos@naver.com)
 *
 */
public class 푸는중_보석가게 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static StringTokenizer sc;
	private static int T, N, W, M, R, K, P;
	// private static int[] arr;

	private static int[] visited;
	private static int[] cnt;
	static ArrayList<Node>[] arr;
	private static int Q;
	private static int[] jw;

	static class Node {
		public Node(int to, int value) {
			this.to = to;
			this.value = value;
		}

		int to;
		int value;

	}

	public static void main(String[] args) throws IOException {
		T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			sc = new StringTokenizer(br.readLine());

			N = Integer.parseInt(sc.nextToken());
			M = Integer.parseInt(sc.nextToken());
			Q = Integer.parseInt(sc.nextToken());

			jw = new int[N + 1];
			for (int i = 0; i < N; i++) {
				arr[i] = new ArrayList<>();
			}

			for (int i = 0; i < M; i++) {
				sc = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(sc.nextToken());
				int b = Integer.parseInt(sc.nextToken());
				int c = Integer.parseInt(sc.nextToken());

				arr[a].add(new Node(b, c));
				arr[b].add(new Node(a, -c));
			}
			
			
			for(int i=0; i< Q; i++)
			{
				sc = new StringTokenizer(br.readLine());
				int from = Integer.parseInt(sc.nextToken());
				int to = Integer.parseInt(sc.nextToken());
			}
			
			
		}

	}

}
