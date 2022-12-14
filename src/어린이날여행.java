
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 어린이날여행 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int de;
	static int N, M, K, P;
	static ArrayList<Integer> adj_lst[];

	static void input() throws IOException {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		P = Integer.parseInt(st.nextToken());
		adj_lst = new ArrayList[N + 1]; // [1] ~ [N]
		for (int v = 1; v <= N; v++)
			adj_lst[v] = new ArrayList<>();
		for (int t = 0; t < M; t++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			adj_lst[from].add(to);
		}
	}

	public static void main(String args[]) throws IOException {
		input();
		de = -1;
		int start = P;
		// K 번 이동해서 갈수 있는 지점을 오름차순 출력
		Queue<Integer> qu = new LinkedList<>();
		int visited[] = new int[N + 1]; // 큐 등록할때
		int cnt[] = new int[N + 1]; // level 기록

		visited[start] = 1;
		cnt[start] = 0;
		qu.add(start);

		while (!qu.isEmpty()) {
			int now = qu.poll();

			for (Integer next : adj_lst[now]) {
				if (visited[next] == 1)
					continue; // 이전에 큐 등록된 지점인가?
				visited[next] = 1;
				cnt[next] = cnt[now] + 1;
				qu.add(next);
			}
		}

		int flag = 0;
		// cnt 배열을 확인후 K 번만에 이동할 수 있는 지역을 출력하기
		for (int node = 1; node <= N; node++) {
			if (visited[node] == 0)
				continue;
			if (cnt[node] != K)
				continue;
			System.out.println(node + " ");
			flag = 1;
		}
		if (flag == 0) {
			System.out.println(-1);
		}
	}

}
