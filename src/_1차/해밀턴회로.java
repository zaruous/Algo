package _1차;
import java.io.*;
import java.util.*;

public class 해밀턴회로 {
	// 항상 PS에서 꼭 넣고 시작하는 코드
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st; // <- 특정 기준을 통해 문자열을 자르는 역할

	static int adj[][];
	static int N;

	static boolean visite[];
	static int mmin = Integer.MAX_VALUE;

	// static ArrayList<Integer> trace = new ArrayList<Integer>
	static void minv(int now, int cost, int visiteCount, String tor) {
		if (visiteCount > N)
			return;

		if (now == 1 && visiteCount >= N) {
			mmin = Math.min(cost, mmin);
			System.out.println(tor);
			return;
		}

		for (int to = N; to >= 1; to--) {

			if (visite[to])
				continue;
			if (adj[now][to] == 0) // now->to로 갈 수 없으면 무시
				continue;
			visite[to] = true;
			minv(to, adj[now][to] + cost, visiteCount + 1, tor + " - >" + to);
			// min = Math.min(ret, min);
			visite[to] = false;
		}

//		visite[1] = true;
//		minv(1, adj[now][1] + cost, visiteCount + 1, tor + " - >" + 1);
//		// min = Math.min(ret, min);
//		visite[1] = false;
	}

	public static void main(String[] args) throws IOException {

		N = Integer.parseInt(br.readLine());
		adj = new int[1 + N][1 + N];
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= N; j++) {
				adj[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		visite = new boolean[1 + N];
		minv(1, 0, 0, "1");
		System.out.println(mmin);

	}
}