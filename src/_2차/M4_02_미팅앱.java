package _2차;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class M4_02_미팅앱 {

	static StringTokenizer st;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int N, M;
	static char MAP[][];
	static int dr[] = { -1, 1, 0, 0 };
	static int dc[] = { 0, 0, -1, 1 };
	private static StringTokenizer sc;
	private static int[][] arr;
	private static int V;
	private static int E;
	private static int[] sexs;

	static class Node implements Comparable<Node> {
		int x, y, w;
		boolean color;

		public Node(int x, int y, int w, boolean color) {
			super();
			this.x = x;
			this.y = y;
			this.w = w;
			this.color = color;
		}

		@Override
		public int compareTo(M4_02_미팅앱.Node o) {

			if (this.w == o.w) {
				if (this.color != o.color)
					return 1;
				else
					return -1;
			}

			return Integer.compare(this.w, o.w);
		}

	}

	public static void main(String[] args) throws IOException {
		sc = new StringTokenizer(br.readLine());

		N = Integer.parseInt(sc.nextToken());
		M = Integer.parseInt(sc.nextToken());

		sc = new StringTokenizer(br.readLine());
		sexs = new int[N+1];
		for (int i = 1; i <= N; i++)
			sexs[i] = "M".equals(sc.nextToken()) ? 1 : 0;

		ArrayList<M4_02_미팅앱.Node> arrayList = new ArrayList<Node>();
		arr = new int[V][V];
		for (int i = 0; i < M; i++) {
			sc = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(sc.nextToken());
			int b = Integer.parseInt(sc.nextToken());
			int w = Integer.parseInt(sc.nextToken());
			if(sexs[a] != sexs[b])
				arrayList.add(new Node(a, b, w, (sexs[a] == sexs[b])));
		}

		Collections.sort(arrayList);

		
		M4_02_미팅앱.UnionFind unionFind = new UnionFind(N);

		int line = 0;
		int sumw = 0;
		for (Node n : arrayList) {
			int a = unionFind.find(n.x);
			int b = unionFind.find(n.y);
			if (a != b) {
				line ++;
				unionFind.union(n.x, n.y);
				sumw += n.w;
			}
		}
		if( line == N-1)
			System.out.println(sumw);
		else
			System.out.println(-1);

	}

	static class UnionFind {
		int[] arr;

		public UnionFind(int N) {
			arr = new int[N + 1];
			for (int i = 1; i <= N; i++)
				arr[i] = i;
		}

		public void union(int a, int b) {
			int na = find(a);
			int nb = find(b);

			if (na != nb)
				arr[na] = nb;
		}

		public int find(int a) {
			if (arr[a] == a)
				return arr[a];
			return arr[a] = find(arr[a]);
		}
	}
}