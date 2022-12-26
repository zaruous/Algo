package _2차;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class M2_02_포스터붙이기 {
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
		public int compareTo(M2_02_포스터붙이기.Node o) {
			// TODO Auto-generated method stub
			return Integer.compare(this.acc, o.acc);
		}

	}

	static void input() throws IOException {
		sc = new StringTokenizer(br.readLine());
		C = Integer.parseInt(sc.nextToken());
		P = Integer.parseInt(sc.nextToken());
		K = Integer.parseInt(sc.nextToken());
		A = Integer.parseInt(sc.nextToken());
		B = Integer.parseInt(sc.nextToken());

		adj = new ArrayList[P + 1];
		for (int i = 0; i <= P; i++) {
			adj[i] = new ArrayList<>();
		}

		for (int t = 0; t < C; t++) {
			sc = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(sc.nextToken());
			int b = Integer.parseInt(sc.nextToken());
			int c = Integer.parseInt(sc.nextToken());
			adj[a].add(new Edge(b, c));
			adj[b].add(new Edge(a, c));
		}
	}

	public static void main(String[] args) throws IOException {
		input();

		dijkstra(K);
		int a = acc[A];
		int b = acc[B];
//		System.out.println();
		dijkstra(B);
		int d = acc[A];
		dijkstra(A);
		int c = acc[B];
		System.out.println(Integer.min(a + d, b + c));

	}

	static int[] acc;

	private static void dijkstra(int start) {
		int[] visite = new int[P + 1];
		acc = new int[P + 1];
		for (int i = 0; i <= P; i++) {
			acc[i] = Integer.MAX_VALUE;
		}

		PriorityQueue<Node> q = new PriorityQueue<>();
		q.add(new Node(start, 0));

		while (!q.isEmpty()) {
			M2_02_포스터붙이기.Node now = q.poll();
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
