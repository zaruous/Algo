package _2차;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 신규도로 {
	static class Edge {
		int node;
		int dist;

		Edge(int node, int dist) {
			this.node = node;
			this.dist = dist;
		}
	}

	static class Node implements Comparable<Node> {
		int node;
		int accDist;

		Node(int node, int accDist) {
			this.node = node;
			this.accDist = accDist;
		}

		@Override
		public int compareTo(Node o) {
			if (this.accDist < o.accDist) {
				return -1;
			}
			if (this.accDist > o.accDist) {
				return 1;
			}
			return 0;
		}
	}

	static StringTokenizer st;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int N, T;
	static ArrayList<Edge> adj[];

	static void input() throws IOException {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());

		adj = new ArrayList[N + 1]; // [1] ~ [N]
		for (int i = 0; i < N + 1; i++) {
			adj[i] = new ArrayList<Edge>();
		}

		for (int t = 0; t < T; t++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int dist = Integer.parseInt(st.nextToken());

			adj[from].add(new Edge(to, dist));
			adj[to].add(new Edge(from, dist));
		}
	}

	static void dijkstra(int start, int dist[]) {
		final int INF = Integer.MAX_VALUE;
		Arrays.fill(dist, INF);
		int processed[] = new int[N + 1];

		PriorityQueue<Node> pq = new PriorityQueue<>();

		dist[start] = 0;
		pq.add(new Node(start, 0));

		while (!pq.isEmpty()) {
			Node now = pq.poll();
			if (processed[now.node] == 1)
				continue;
			processed[now.node] = 1;
			for (Edge next : adj[now.node]) {
				int newDist = now.accDist + next.dist;
				if (newDist < dist[next.node]) {
					dist[next.node] = newDist; // 이후에 newDist 보다 더 큰 거리는 pq
												// 안들어온다
					pq.add(new Node(next.node, newDist));
				}
			}
		}

	}

	public static void main(String[] args) throws IOException {
		int TC = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= TC; tc++) {
			input();
			int distFromOne[] = new int[N + 1];
			int distFromN[] = new int[N + 1];
			dijkstra(1, distFromOne);
			dijkstra(N, distFromN);

//			Arrays.sort(distFromOne, 2, N);
			Arrays.sort(distFromN, 2, N);

			
			
			
			
			
			long cnt = 0;
			int target = distFromOne[N] - 1;
			int b = N - 1;
			for (int a = 2; a < N; a++) {
				int distA = distFromOne[a];
				int distB = distFromN[b];

				while (b >= 2 && !(distA + distB < target)) {
					b--;
					distB = distFromN[b];
				}
				if(b >= 2) {
					cnt += (b-1);
				}

			}
			System.out.println("#" + tc + " " + cnt);
			// A,B 선택하기 distFromeOne[A] + 1 + distFromN[B] < distFromOne[N]

	
		}

	}
}