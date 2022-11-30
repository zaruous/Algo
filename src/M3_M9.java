import java.io.*;
import java.util.*;

public class M3_M9 {
	// 항상 PS에서 꼭 넣고 시작하는 코드
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st; // <- 특정 기준을 통해 문자열을 자르는 역할

	static int adj[][];
	static int N;

	static boolean visite[];
	static int max = Integer.MIN_VALUE;
	static int min = Integer.MAX_VALUE;

	static int maxv(int now, int end, int cost) {
		if (now == end) {
			return cost;
		}

		int max = Integer.MIN_VALUE;
		for (int to = 1; to < N; to++) {

			if (visite[to])
				continue;
			if (adj[now][to] == 0) // now->to로 갈 수 없으면 무시
				continue;
			visite[to] = true;
			int ret = maxv(to, end, adj[now][to]);
			max = Math.max(ret, max);
			visite[to] = false;
			// System.out.println(now + " -> " + to);
		}
		return max + cost;
	}

	static int minv(int now, int end, int cost) {
		if (now == end) {
			return cost;
		}

		int min = Integer.MAX_VALUE;
		for (int to = 1; to < N; to++) {

			if (visite[to])
				continue;
			if (adj[now][to] == 0) // now->to로 갈 수 없으면 무시
				continue;
			visite[to] = true;
			int ret = minv(to, end, adj[now][to]);
			min = Math.min(ret, min);
			visite[to] = false;
			// System.out.println(now + " -> " + to);
		}
		return min + cost;
	}

	public static void main(String[] args) throws IOException {

		N = Integer.parseInt(br.readLine());

		adj = new int[1 + N][1 + N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				adj[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		st = new StringTokenizer(br.readLine());
		int s = Integer.parseInt(st.nextToken());
		int t = Integer.parseInt(st.nextToken());

		visite = new boolean[1 + N];
		int ret = minv(s, t, 0);
		System.out.println(ret);
		visite = new boolean[1 + N];
		ret = maxv(s, t, 0);
		System.out.println(ret);

	}
}