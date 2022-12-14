
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class M3_01_알뜰기차여행 {
	static StringTokenizer st;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int N, T;
	static ArrayList<Edge> adj[];

	static class Node implements Comparable<Node> { // pq 에 넣을 자료
		int node;
		int accDist;

		Node(int node, int accDist) {
			this.node = node;
			this.accDist = accDist;
		}

		@Override
		public int compareTo(Node o) { // accDist 가 작은것부터 뽑힌다!
			if (this.accDist < o.accDist) {
				return -1;
			}
			if (this.accDist > o.accDist) {
				return 1;
			}
			return 0;
		}
	}

	static class Edge { // 그래프 구성할 자료
		int node;
		int dist;

		Edge(int node, int dist) {
			this.node = node;
			this.dist = dist;
		}
	}

	static void input() throws IOException {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());

		adj = new ArrayList[N];
		for (int i = 0; i < N; i++) {
			adj[i] = new ArrayList<Edge>();
		}

		for (int t = 0; t < T; t++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int dist = Integer.parseInt(st.nextToken());

			adj[from].add(new Edge(to, dist));
		}
	}

	static int dist[]; // 모든 K 에 대해 0~~~~> K 의 최단 거리, 최소 비용

	static void dijkstra(int start) {
		final int INF = Integer.MAX_VALUE;
		dist = new int[N]; // 각 정점들에 대한 현재 탐색된 최단 거리
							// pq에 등록할지 말지 ?
		for (int node = 0; node < N; node++) {
			dist[node] = INF;
		}

		int processed[] = new int[N];

		// LinkedList<Node> pq = new LinkedList<>();
		PriorityQueue<Node> pq = new PriorityQueue<>();
		dist[start] = 0;
		pq.add(new Node(start, 0));

		while (!pq.isEmpty()) {
			Node now = pq.poll();

			if (processed[now.node] == 1)
				continue;
			processed[now.node] = 1;
			// process 진행 : 인접한 지점들의 누적거리구해서 pq 등록
			for (Edge next : adj[now.node]) {
				int newDist = now.accDist + next.dist; // 시작~~~>now + 간선비용 = 시작
														// ~~~> next 의 누적비용
				if (newDist >= dist[next.node])
					continue;
				dist[next.node] = newDist;
				pq.add(new Node(next.node, newDist));
			}

		}
	}

	public static void main(String[] args) throws IOException {
		input();
		dijkstra(0);
		System.out.println(dist[N - 1] == Integer.MAX_VALUE ? "impossible" : dist[N - 1]);
		// for (int node = 0; node < N; node++) {
		// System.out.println("0~~~>" + node + "최단거리: " + dist[node]);
		// }
	}
}
