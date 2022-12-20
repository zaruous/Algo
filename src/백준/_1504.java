package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class _1504 {

	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static int T;
	private static StringTokenizer sc;
	private static int N;
	private static int E;
	private static int K;
	private static ArrayList<Node>[] arr;
	// private static int[] visite;
	private static int p1;
	private static int p2;

	static class Node implements Comparable<Node> {
		int to, value;

		public Node(int to, int value) {
			super();
			this.to = to;
			this.value = value;
		}

		@Override
		public int compareTo(_1504.Node o) {
			return Integer.compare(value, o.value);
		}

	}

	public static void main(String[] args) throws IOException {
		// T = Integer.parseInt(br.readLine());
		sc = new StringTokenizer(br.readLine());

		N = Integer.parseInt(sc.nextToken());
		E = Integer.parseInt(sc.nextToken());
		// visite = new int[N + 1];
		arr = new ArrayList[N + 1];
		for (int i = 1; i <= N; i++)
			arr[i] = new ArrayList<>();

		for (int i = 0; i < E; i++) {
			sc = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(sc.nextToken());
			int b = Integer.parseInt(sc.nextToken());
			int c = Integer.parseInt(sc.nextToken());
			arr[a].add(new Node(b, c));
			arr[b].add(new Node(a, c));
		}

		sc = new StringTokenizer(br.readLine());
		p1 = Integer.parseInt(sc.nextToken());
		p2 = Integer.parseInt(sc.nextToken());

		int min = Integer.MAX_VALUE;

		int[] v1 = extracted();
		int a = dijkstra(v1, 1, p1);
		int[] v2 = extracted();
		int b = dijkstra(v2, p1, p2);
		int[] v3 = extracted();
		int c = dijkstra(v3, p2, N);

		int[] v4 = extracted();
		int d = dijkstra(v4, 1, p2);
		int[] v5 = extracted();
		int e = dijkstra(v5, p2, p1);
		int[] v6 = extracted();
		int f = dijkstra(v6, p1, N);

		int res1 = (a + b + c);
		int res2 = (d + e + f);
		int ans = (res1 >= INF && res2 >= INF) ? -1 : Math.min(res1, res2);

		System.out.println(ans);
	}

	static int INF = 200_000_000;

	private static int[] extracted() {
		int[] arr = new int[N + 1];
		for (int i = 1; i <= N; i++)
			arr[i] = INF;
		return arr;
	}

	// 다익스트라 알고리즘
	public static int dijkstra(int[] dist, int start, int end) {
		// Arrays.fill(dist, INF);
		// Arrays.fill(check, false);
		// boolean[] visite = new boolean[N + 1];
		PriorityQueue<Node> pq = new PriorityQueue<>();
		boolean[] check = new boolean[N + 1];
		pq.offer(new Node(start, 0));
		dist[start] = 0;

		while (!pq.isEmpty()) {
			Node curNode = pq.poll();
			int cur = curNode.to;

			if (!check[cur]) {
				check[cur] = true;

				for (Node node : arr[cur]) {
					if (!check[node.to] && dist[node.to] > dist[cur] + node.value) {
						dist[node.to] = dist[cur] + node.value;
						pq.add(new Node(node.to, dist[node.to]));
					}
				}
			}
		}

		return dist[end];
	}

	// private static int dikstra(int[] dist, int start, int end) {
	//
	// boolean[] visite = new boolean[N + 1];
	// PriorityQueue<Node> q = new PriorityQueue<>();
	// Main.Node node = new Node(0, start, 0);
	// dist[start] = 0;
	//// visite[start] = true;
	// q.add(node);
	//
	// while (!q.isEmpty()) {
	// Node now = q.poll();
	//
	// if (visite[now.to])
	// continue;
	//
	// visite[now.to] = true;
	// if (now.to == end) {
	// return dist[end] == Integer.MAX_VALUE ? -1 : dist[end];
	// }
	//
	// for (Node next : arr[now.to]) {
	//
	// if (dist[next.to] > dist[now.from] + next.value) {
	// dist[next.to] = dist[now.from] + next.value;
	// q.add(next);
	// }
	//
	// }
	// }
	//
	// return -1;
	// }

}