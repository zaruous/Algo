package _1차;
import java.io.*;
import java.util.*;

public class M4_3_통신탑_못품 {
	static class Node {
		int x, y, R;

		Node(int x, int y, int R) {
			this.x = x;
			this.y = y;
			this.R = R;
		}
	}

	// 항상 PS에서 꼭 넣고 시작하는 코드
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st; // <- 특정 기준을 통해 문자열을 자르는 역할

	static int parent[];

	static int Find(int a) {
		if (a == parent[a])
			return a;
		parent[a] = Find(parent[a]);
		return parent[a];
	}

	static void Union(int a, int b) {
		int pa = Find(a);
		int pb = Find(b);
		parent[pa] = pb;
	}

	public static void main(String[] args) throws IOException {
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(br.readLine());

			parent = new int[N + 1];
			for (int i = 1; i <= N; i++)
				parent[i] = i;

			Node node[] = new Node[N + 1];
			for (int i = 1; i <= N; i++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				int R = Integer.parseInt(st.nextToken());
				node[i] = new Node(x, y, R);
			}
			int answer = N;
			for (int A = 1; A <= N; A++) {
				for (int B = 1; B < A; B++) {
//					System.out.println(A + " " + B);
					int dist = (node[A].x - node[B].x) * (node[A].x - node[B].x) + (node[A].y - node[B].y) * (node[A].y - node[B].y);
					// 실제거리의 제곱

					int l = (node[A].R + node[B].R) * (node[A].R + node[B].R);
					// 완벽하게 인접할때의 거리 제곱

					if (l < dist)
						continue;

					if (Find(A) == Find(B))
						continue;

					// A와 B는 겹치는 원
					Union(A, B);
					answer--;
				}
			}
			System.out.println(answer);

		}
	}
}