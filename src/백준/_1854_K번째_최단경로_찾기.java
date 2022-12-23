package 백준;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class _1854_K번째_최단경로_찾기 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static StringTokenizer sc;
	private static int N;
	private static int M;
	private static int K;
	static ArrayList<ArrayList<Node>> arr;
	static PriorityQueue<Integer>[] revq;

	static class Node implements Comparable<Node> {
		int n, w;

		public Node(int n, int w) {
			super();
			this.n = n;
			this.w = w;
		}

		@Override
		public int compareTo(_1854_K번째_최단경로_찾기.Node o) {
			return Integer.compare(w, o.w);
		}

	}

	public static void main(String[] args) throws IOException {
		sc = new StringTokenizer(br.readLine());
		N = Integer.parseInt(sc.nextToken());
		M = Integer.parseInt(sc.nextToken());
		K = Integer.parseInt(sc.nextToken());

		arr = new ArrayList<>();
		for (int i = 0; i <= N; i++)
			arr.add(new ArrayList<>());

		revq = new PriorityQueue[N + 1];
		for (int i = 1; i <= N; i++)
			revq[i] = new PriorityQueue<>(Comparator.reverseOrder());

		for (int i = 0; i < M; i++) {
			sc = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(sc.nextToken());
			int b = Integer.parseInt(sc.nextToken());
			int c = Integer.parseInt(sc.nextToken());
			arr.get(a).add(new Node(b, c));
			
		}

		distra();

		for (int i = 1; i <= N; i++) {
			if (revq[i].size() != K)
				System.out.println(-1);
			else
				System.out.println(revq[i].poll());
		}

	}

	private static void distra() {

		PriorityQueue<Node> q = new PriorityQueue<Node>();
		revq[1].add(0);
		q.add(new Node(1, 0));
		
		while (!q.isEmpty()) {
			Node cur = q.poll();

			for (Node next : arr.get(cur.n)) {
				int nw = cur.w + next.w;

				if (revq[next.n].size() < K) {
					revq[next.n].add(nw);
					q.add(new Node(next.n, nw));
				} 
				else if (revq[next.n].peek() > nw) {
					revq[next.n].poll();
					revq[next.n].add(nw);
					q.add(new Node(next.n, nw));
				}

			}
		}

	}

}