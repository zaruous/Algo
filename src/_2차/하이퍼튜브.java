package _2차;

import java.io.*;
import java.util.*;

public class 하이퍼튜브 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int de;
	static int N, M, K;
	static ArrayList<Integer> tube_to_node[];
	static ArrayList<Integer> node_to_tube[];

	static void input() throws IOException {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		tube_to_node = new ArrayList[M + 1];
		node_to_tube = new ArrayList[N + 1];
		for (int tube = 1; tube <= M; tube++)
			tube_to_node[tube] = new ArrayList<>();
		for (int node = 1; node <= N; node++)
			node_to_tube[node] = new ArrayList<>();
		for (int tube = 1; tube <= M; tube++) {
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < K; i++) {
				int node = Integer.parseInt(st.nextToken());
				tube_to_node[tube].add(node);
				node_to_tube[node].add(tube);
			}
		}
	}

	public static void main(String args[]) throws IOException {
		input();
		int visited_tube[] = new int[M + 1];
		int visited[] = new int[N + 1];
		int cnt[] = new int[N + 1]; // 1 ~~~~~> k 지점까지의 거쳐온 최소 역의 개수
		Queue<Integer> qu = new LinkedList<>();
		visited[1] = 1;
		cnt[1] = 1;
		qu.add(1);

		while (!qu.isEmpty()) {
			int now = qu.poll();

			// next 찾기 : now->tube->next
			for (Integer tube : node_to_tube[now]) {
				if (visited_tube[tube] == 1)
					continue;
				visited_tube[tube] = 1;
				// 각 tube(now와 인접한)에 대해서
				for (Integer next : tube_to_node[tube]) {
					if (visited[next] == 1)
						continue;
					// now->next
					visited[next] = 1;
					cnt[next] = cnt[now] + 1;
					qu.add(next);
				}
			}
		}
		if (visited[N] == 1) {
			System.out.println(cnt[N]);
		} else {
			System.out.println(-1);
		}

	}

}
