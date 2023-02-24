/********************************
 *	프로젝트 : Algo
 *	패키지   : 백준.다익스트라
 *	작성일   : 2023. 2. 24.
 *	작성자   : (zaruous@naver.com)
 *******************************/
package 백준.다익스트라;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * @author (zaruous@naver.com)
 *
 */
public class P1238_파티 {
	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static StringTokenizer sc;

	static class Edge {
		int to;
		int cost;

		public Edge(int to, int cost) {
			super();
			this.to = to;
			this.cost = cost;
		}

	}

	static List<Edge>[] LIST_FORWARD;
	static List<Edge>[] LIST_BACKWARD;
	static int[] MIN_COST_FROM_X; // X 부터 i 까지 이동하는 최소 비용
	static int[] MIN_COST_TO_X; // i로부터 x까지 이동하는 최소 비용

	public static void main(String[] args) throws IOException {
		sc = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(sc.nextToken());
		int M = Integer.parseInt(sc.nextToken());
		int X = Integer.parseInt(sc.nextToken());

		LIST_FORWARD = new ArrayList[N + 1];
		LIST_BACKWARD = new ArrayList[N + 1];
		MIN_COST_FROM_X = new int[N + 1];
		MIN_COST_TO_X = new int[N + 1];

		for (int i = 0; i <= N; i++) {
			LIST_FORWARD[i] = new ArrayList<>();
			LIST_BACKWARD[i] = new ArrayList<>();
			MIN_COST_FROM_X[i] = Integer.MAX_VALUE / 2;
			MIN_COST_TO_X[i] = Integer.MAX_VALUE / 2;
		}

		for (int i = 0; i < M; i++) {
			sc = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(sc.nextToken());
			int to = Integer.parseInt(sc.nextToken());
			int cost = Integer.parseInt(sc.nextToken());

			LIST_FORWARD[from].add(new Edge(to, cost));
			LIST_BACKWARD[to].add(new Edge(from, cost));
		}

		Queue<Edge> que = new PriorityQueue<>(Comparator.comparingInt(a -> a.cost));
		que.add(new Edge(X, 0));
		MIN_COST_FROM_X[X] = 0;

		while (!que.isEmpty()) {
			Edge now = que.poll();
			if (MIN_COST_FROM_X[now.to] < now.cost) {
				continue;
			}
			for (Edge next : LIST_FORWARD[now.to]) {

				if (MIN_COST_FROM_X[next.to] <= now.cost + next.cost) {
					continue;
				}
				MIN_COST_FROM_X[next.to] = now.cost + next.cost;
				que.add(new Edge(next.to, now.cost + next.cost));
			}
		}

		// i -> x로 이동하는 비용
		// LIST_BACKWORD, MIN_COST_TO_X

		que = new PriorityQueue<>(Comparator.comparingInt(a -> a.cost));
		que.add(new Edge(X, 0));
		MIN_COST_TO_X[X] = 0;

		while (!que.isEmpty()) {
			Edge now = que.poll();

			if (MIN_COST_TO_X[now.to] < now.cost) {
				continue;
			}

			for (Edge next : LIST_BACKWARD[now.to]) {

				if (MIN_COST_TO_X[next.to] <= now.cost + next.cost) {
					continue;
				}
				MIN_COST_TO_X[next.to] = now.cost + next.cost;
				que.add(new Edge(next.to, now.cost + next.cost));
			}
		}

		int answer = 0;
		for (int i = 1; i <= N; i++) {
			answer = Math.max(answer, (MIN_COST_FROM_X[i] + MIN_COST_TO_X[i]));
		}
		System.out.println(answer);

	}
}
