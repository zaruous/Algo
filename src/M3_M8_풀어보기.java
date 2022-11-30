import java.io.*;
import java.util.*;

public class M3_M8_풀어보기 {
	// 항상 PS에서 꼭 넣고 시작하는 코드
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st; // <- 특정 기준을 통해 문자열을 자르는 역할

	static int adj[][];
	static int cntNode;

	static int cnt = 0;

	static void v(int now)
	// now에 있다.
	{

		cnt++;
		for (int to = 1; to < cntNode; to++) {
			if (adj[now][to] == 0) // now->to로 갈 수 없으면 무시
				continue;

			int next = to; // now에서 갈 수 있는 next

			// now에서 갈 수 있는 next로 가라!
			v(next);
		}
	}

	public static void main(String[] args) throws IOException {

		cntNode = Integer.parseInt(br.readLine());
		int cntEdge = Integer.parseInt(br.readLine());
		// int s = Integer.parseInt(br.readLine());

		adj = new int[1 + cntNode][1 + cntNode];

		for (int i = 0; i < cntEdge; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			adj[from][to] = 1;
		}

		v(1);
		System.out.println(cnt);
	}
}