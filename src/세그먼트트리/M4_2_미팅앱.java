package 세그먼트트리;
import java.io.*;
import java.util.*;

/**
 * 
 * MST
 * @author (zaruous@naver.com)
 *
 */
public class M4_2_미팅앱 {
	static class Edge implements Comparable<Edge> {
		int A, B;
		int cost;

		Edge(int A, int B, int cost) {
			this.A = A;
			this.B = B;
			this.cost = cost;
		}

		@Override
		public String toString() {
			return "Edge [A=" + A + ", B=" + B + ", cost=" + cost + "]";
		}

		@Override
		public int compareTo(Edge o) {
			if (this.cost < o.cost)
				return -1;
			if (this.cost > o.cost)
				return 1;
			return 0;
		}
	}

	static StringTokenizer st;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int N, T;
	static ArrayList<Edge> edge_lst;
	static char gender[];

	static void input() throws IOException {
		edge_lst = new ArrayList<Edge>();
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());
		gender = new char[N + 1];
		st = new StringTokenizer(br.readLine());
		for (int node = 1; node <= N; node++) {
			gender[node] = st.nextToken().charAt(0);
		}

		for (int t = 0; t < T; t++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			if (gender[a] == gender[b])
				continue;
			edge_lst.add(new Edge(a, b, cost));
		}

	}

	static int de;
	static int parent[];

	static void initParent() {
		parent = new int[N + 1];
		for (int node = 1; node <= N; node++) {
			parent[node] = node;
		}
	}

	static int Find(int a) {
		if (parent[a] == a) {
			return a;
		}
		return parent[a] = Find(parent[a]);
	}

	static void Union(int a, int b) {
		int pa = Find(a);
		int pb = Find(b);
		if (pa == pb)
			return;
		parent[pa] = pb;
	}

	public static void main(String[] args) throws IOException {
		input();
		initParent();

		Collections.sort(edge_lst);

		int sum = 0;
		int cnt = 0;
		for (Edge edge : edge_lst) {
			
			if (Find(edge.A) == Find(edge.B))
				continue;
			Union(edge.A, edge.B);
			sum += edge.cost;
			cnt++;
		}
		if (cnt == N - 1)
			System.out.println(sum);
		else
			System.out.println(-1);

	}
}
