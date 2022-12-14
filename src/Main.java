import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static StringTokenizer sc;
	private static int T, N, W, M, R, K, P;
	// private static int[] arr;

	private static int[][] visited;
	private static int[] cnt;
	static char[][] arr;
	private static int Q;
	private static int[] jw;
	private static ArrayList<Edge>[] adj;
	private static int C;
	private static int A;
	private static int B;

	static class Edge {

		public Edge(int n, int w) {
			super();
			this.n = n;
			this.w = w;
		}

		int n, w;
	}

	static class Node implements Comparable<Node> {
		int n, acc;

		public Node(int n, int acc) {
			super();
			this.n = n;
			this.acc = acc;
		}

		@Override
		public int compareTo(Main.Node o) {
			// TODO Auto-generated method stub
			return Integer.compare(this.acc, o.acc);
		}

	}

	// static void input() throws IOException {}

	public static void main(String[] args) throws IOException {

		T = Integer.parseInt(br.readLine());

		for (int testCase = 1; testCase <= T; testCase++) {
			sc = new StringTokenizer(br.readLine());
			N = Integer.parseInt(sc.nextToken());
			M = Integer.parseInt(sc.nextToken());

			adj = new ArrayList[N + 1];
			for (int i = 0; i <= N; i++) {
				adj[i] = new ArrayList<>();
			}

			for (int i = 0; i < M; i++) {
				sc = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(sc.nextToken());
				int b = Integer.parseInt(sc.nextToken());
				int c = Integer.parseInt(sc.nextToken());
				adj[a].add(new Edge(b, c));
				adj[b].add(new Edge(a, c));
			}

			dijkstra(1);
			int max = acc[N];
			for (int i = 1; i <= N; i++) {
				System.out.print(acc[i] + " ");
			}
			System.out.println();
			dijkstra(N);
			for (int i = 1; i <= N; i++) {
				System.out.print(acc[i] + " ");
			}
			System.out.println();

			
			
		}

	}

	static int[] acc;

	private static void dijkstra(int start) {
		int[] visite = new int[N + 1];
		acc = new int[N + 1];
		for (int i = 0; i <= N; i++) {
			acc[i] = Integer.MAX_VALUE;
		}

		PriorityQueue<Node> q = new PriorityQueue<>();
		q.add(new Node(start, 0));

		while (!q.isEmpty()) {
			Main.Node now = q.poll();
			if (visite[now.n] == 1)
				continue;
			visite[now.n] = 1;

			for (Edge next : adj[now.n]) {
				int newdist = next.w + now.acc;
				if (acc[next.n] <= newdist)
					continue;
				acc[next.n] = newdist;
				q.add(new Node(next.n, newdist));
			}
		}
	}

}
