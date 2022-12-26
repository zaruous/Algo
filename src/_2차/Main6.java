package _2차;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.StringTokenizer;

/**
 * 
 * 
 * @author KYJ (callakrsos@naver.com)
 *
 */
public class Main6 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static StringTokenizer sc;
	private static int T, N, W, M, R, K, P;
	private static int[] arr;
	private static int[][] board;
	static ArrayList<Node>[] arrayList;

	static class Node {
		int y, depth;

		public Node(int y, int depth) {
			super();

			this.y = y;
			this.depth = depth;
		}

	}

//	static Comparator<? super Main.Node> c = (o1, o2) -> Integer.compare(o1.y, o2.y);
	private static int[] visited;
	private static int[] cnt;

	public static void main(String[] args) throws IOException {
		sc = new StringTokenizer(br.readLine());

		// 도시
		N = Integer.parseInt(sc.nextToken());
		// 도로
		M = Integer.parseInt(sc.nextToken());
		// 남은기름통 칸수
		K = Integer.parseInt(sc.nextToken());
		// 출발도시
		P = Integer.parseInt(sc.nextToken());

		arrayList = new ArrayList[N + 1];
		for (int i = 1; i <= N; i++) {
			arrayList[i] = new ArrayList<Node>();
		}

		for (int i = 0; i < M; i++) {
			sc = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(sc.nextToken());
			int b = Integer.parseInt(sc.nextToken());
			arrayList[a].add(new Node(b, 0));
		}

		cnt = new int[N + 1];
		visited = new int[N + 1];

		LinkedList<Node> q = new LinkedList<Node>();
		q.add(new Node(P, 1));
		visited[P] = 1;
		cnt[P] = 1;

		// int depth = 1;
		if (q.isEmpty()) {
			System.out.println("-1");
			return;
		}

//		boolean found = false;
		while (!q.isEmpty()) {
			Node poll = q.poll();

			ArrayList<Node> yList = arrayList[poll.y];
			for (Node curNode : yList) {

				if (visited[poll.y] == 1)
					continue;
				if (poll.depth > K)
					continue;
				// System.out.println(poll.y + " -> " + curNode.y);
//				if (poll.depth == K) {
////					System.out.println(curNode.y);
////					found = true;
//					continue;
//				}
				visited[poll.y] = 1;
				cnt[poll.y] = cnt[poll.y] + 1;
//				curNode.depth += poll.depth + 1;
				q.add(curNode);
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
