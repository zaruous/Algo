package _2차;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 
 * 
 * @author KYJ (zaruous@naver.com)
 *
 */
public class 보석가게 {
	
	static class Node 
	{ 
		int node; 
		int cost; 
		Node (int node, int cost)
		{
			this.node = node; 
			this.cost = cost; 
		}
	}
	
	static StringTokenizer st;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int N, M, Q;
	static ArrayList<Node> adj[];

	static void input() throws IOException {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		Q = Integer.parseInt(st.nextToken());
		adj = new ArrayList[N + 1];
		for (int i = 1; i <= N; i++)
			adj[i] = new ArrayList<>();
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			adj[a].add(new Node(b, -c));
			adj[b].add(new Node(a, c));
		}
	}

	static int groupNum[]; // 0 으로 초기화 되어있다. 1이상의 값으로 저장합니다.
	static int price[];

	static void init() {
		groupNum = new int[N + 1]; // 0으로 초기화 되어있음
		price = new int[N + 1]; // 0으로 초기화 되어있음
	}

	static void bfs(int start) {
		Queue<Node> qu = new LinkedList<>();

		groupNum[start] = start;
		price[start] = 0;
		qu.add(new Node(start, 0));

		while (!qu.isEmpty()) {
			Node now = qu.poll();

			for (Node next : adj[now.node]) {
				if (groupNum[next.node] == start)
					continue;
				groupNum[next.node] = start;
				price[next.node] = price[now.node] + next.cost;
				qu.add(next);
			}
		}

	}

	public static void main(String[] args) throws IOException {
		int TC = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= TC; tc++) {
			input();
			init();
			// 모든 정점들에 대해 탐색
			for (int node = 1; node <= N; node++) {
				if (groupNum[node] != 0)
					continue;
				bfs(node);
			}

			// price 들이 기록 groupNum 기록
			long result = 0;
			for (int q = 0; q < Q; q++) {
				st = new StringTokenizer(br.readLine());
				int A = Integer.parseInt(st.nextToken());
				int B = Integer.parseInt(st.nextToken());
				if (groupNum[A] == groupNum[B]) {
					result += Math.abs(price[A] - price[B]);
				} else {
					result += (-1);
				}
			}
			System.out.println("#" + tc + " " + result);
		}

	}
}
