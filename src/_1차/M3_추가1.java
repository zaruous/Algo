package _1차;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class M3_추가1 {

	// 항상 PS에서 꼭 넣고 시작하는 코드
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st; // <- 특정 기준을 통해 문자열을 자르는 역할
	private static int N;

	static class Node implements Comparable<Node> {
		int from, to, weight;

		public Node(int from, int to, int weight) {
			super();
			this.from = from;
			this.to = to;
			this.weight = weight;
		}

		@Override
		public int compareTo(M3_추가1.Node o) {
			return Integer.compare(this.weight, o.weight);
		}

	}

	static class UnionFind {
		int[] board;

		public UnionFind() {
			board = new int[N + 1];
			for (int i = 1; i <= N; i++) {
				board[i] = i;
			}
		}

		public void union(int a, int b) {
			int aa = find(a);
			int bb = find(b);

			if (aa != bb) {
				board[bb] = aa;
			}
		}

		public int find(int a) {

			if (board[a] != a)
				return board[a];

			return board[a] = find(a);
		}
	}

	public static void main(String[] args) throws Exception {
		N = Integer.parseInt(br.readLine());

		PriorityQueue<Node> queue = new PriorityQueue<>();
		int[][] visite = new int[N + 1][N + 1];
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());

			for (int j = 1; j <= N; j++) {
				int parseInt = Integer.parseInt(st.nextToken());
				if(parseInt == 0) continue;
				queue.add(new Node(i, j, parseInt));
			}
		}

		int connect = 0;
		int sum = 0;
		UnionFind unionFind = new UnionFind();
		while (!queue.isEmpty()) {
			Node poll = queue.poll();
			int x = poll.from;
			int y = poll.to;
			int w = poll.weight;
			if(connect == N)break;
			
			int find = unionFind.find(y);
			if (x == find) {
				continue;
			}
			sum += w;
			unionFind.union(x, y);
			connect ++;
		}
System.out.println(sum);
	}

}
